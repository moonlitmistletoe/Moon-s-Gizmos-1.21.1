package net.satisfy.morrow.neoforge.core.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Animal;
import net.satisfy.morrow.core.util.SaturationTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "dropAllDeathLoot", at = @At("TAIL"))
    private void morrow$injectExtraLoot(ServerLevel serverLevel, DamageSource damageSource, CallbackInfo ci) {
        if (!(((Object)this) instanceof Animal animal)) return;

        EntityType<?> type = animal.getType();
        if (!(type == EntityType.COW || type == EntityType.PIG || type == EntityType.SHEEP || type == EntityType.CHICKEN)) return;

        if (!(animal instanceof SaturationTracker.SaturatedAnimal saturated)) return;

        saturated.morrow$getSaturationTracker().dropExtraLoot(animal, damageSource);
    }
}