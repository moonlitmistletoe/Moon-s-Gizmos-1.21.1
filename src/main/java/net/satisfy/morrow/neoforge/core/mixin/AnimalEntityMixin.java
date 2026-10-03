package net.satisfy.morrow.neoforge.core.mixin;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.satisfy.morrow.core.entity.ai.ApproachFeedingTroughGoal;
import net.satisfy.morrow.core.entity.ai.ApproachWaterTroughGoal;
import net.satisfy.morrow.core.network.PacketHandler;
import net.satisfy.morrow.core.network.packet.SyncSaturationPacket;
import net.satisfy.morrow.core.util.SaturationTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Animal.class)
public abstract class AnimalEntityMixin extends Mob implements SaturationTracker.SaturatedAnimal {

    @Unique
    private SaturationTracker morrow$saturation;

    protected AnimalEntityMixin(EntityType<? extends Mob> entityType, Level world) {
        super(entityType, world);
    }

    @Override
    public SaturationTracker morrow$getSaturationTracker() {
        if (morrow$saturation == null) {
            morrow$saturation = new SaturationTracker();
        }
        return morrow$saturation;
    }

    @Override
    public void morrow$setSaturationTracker(SaturationTracker tracker) {
        this.morrow$saturation = tracker;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void morrow$addSelfFeedingGoal(EntityType<? extends Animal> entityType, Level level, CallbackInfo ci) {
        if (!level.isClientSide) {
            this.goalSelector.addGoal(3, new ApproachFeedingTroughGoal((Animal) (Object) this, 1.2D));
            this.goalSelector.addGoal(3, new ApproachWaterTroughGoal((Animal) (Object) this, 1.2D));
        }
    }

    @Inject(method = "aiStep", at = @At("HEAD"))
    private void morrow$tickSaturation(CallbackInfo ci) {
        if (!this.level().isClientSide) {
            EntityType<?> type = this.getType();
            if (!(type == EntityType.COW || type == EntityType.PIG || type == EntityType.SHEEP || type == EntityType.CHICKEN)) return;

            SaturationTracker tracker = morrow$getSaturationTracker();
            tracker.tick((Animal)(Object)this);

            SyncSaturationPacket packet = new SyncSaturationPacket(this.getId(), tracker.level(), tracker.foodCounter());
            PacketHandler.sendSaturationSync(packet, this);
        }
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void morrow$injectSaturationFeeding(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        EntityType<?> type = this.getType();
        if (!(type == EntityType.COW || type == EntityType.PIG || type == EntityType.SHEEP || type == EntityType.CHICKEN)) return;

        Animal animal = (Animal)(Object)this;
        ItemStack stack = player.getItemInHand(hand);

        if (!animal.isFood(stack) || animal.isBaby()) return;
        if (animal.canFallInLove()) return;

        SaturationTracker tracker = morrow$getSaturationTracker();
        tracker.tryFeed(animal, player, hand);

        if (!animal.level().isClientSide) {
            SyncSaturationPacket packet = new SyncSaturationPacket(this.getId(), tracker.level(), tracker.foodCounter());
            PacketHandler.sendSaturationSync(packet, this);
            ((ServerLevel)animal.level()).sendParticles(ParticleTypes.HAPPY_VILLAGER, animal.getX(), animal.getY() + 1.0, animal.getZ(), 5, 0.2, 0.2, 0.2, 0.05);
        }

        cir.setReturnValue(InteractionResult.sidedSuccess(animal.level().isClientSide));
    }

    @Inject(method = "addAdditionalSaveData", at = @At("HEAD"))
    private void morrow$saveSaturation(CompoundTag tag, CallbackInfo ci) {
        SaturationTracker tracker = morrow$getSaturationTracker();
        CompoundTag trackerTag = new CompoundTag();
        trackerTag.putInt("SaturationLevel", tracker.level());
        trackerTag.putInt("SaturationCounter", tracker.foodCounter());
        trackerTag.putLong("SaturationLastFed", tracker.getLastFedTick());
        trackerTag.putInt("SaturationDecayDelay", tracker.getDecayDelay());
        tag.put("FarmAndCharmSaturation", trackerTag);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("HEAD"))
    private void morrow$loadSaturation(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains("FarmAndCharmSaturation", 10)) {
            CompoundTag trackerTag = tag.getCompound("FarmAndCharmSaturation");
            SaturationTracker tracker = new SaturationTracker();
            tracker.setLevel(trackerTag.getInt("SaturationLevel"));
            tracker.setFoodCounter(trackerTag.getInt("SaturationCounter"));
            tracker.setLastFedTick(trackerTag.getLong("SaturationLastFed"));
            tracker.setDecayDelay(trackerTag.getInt("SaturationDecayDelay"));
            morrow$setSaturationTracker(tracker);
        }
    }
}
