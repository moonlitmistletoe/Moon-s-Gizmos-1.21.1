package net.moonlitmistletoe.whatsits;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.projectile.ThrownEgg;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.ProjectileImpactEvent;
import net.moonlitmistletoe.whatsits.item.ModItems;

public class EggYolkHandler {

    @SubscribeEvent
    public static void onEggImpact(ProjectileImpactEvent event) {

        // Make sure this is a normal thrown egg
        if (!(event.getProjectile() instanceof ThrownEgg egg)) {
            return;
        }

        // Make sure the egg hit a block
        if (event.getRayTraceResult().getType() != HitResult.Type.BLOCK) {
            return;
        }

        // Get the block hit result
        BlockHitResult hitResult = (BlockHitResult) event.getRayTraceResult();

        // Only drop a yolk when hitting the top of a block (the ground)
        if (!hitResult.getDirection().getAxis().isVertical()
                || hitResult.getDirection().getAxisDirection() != net.minecraft.core.Direction.AxisDirection.POSITIVE) {
            return;
        }

        // 25% chance
        if (egg.level().random.nextFloat() >= 0.25f) {
            return;
        }

        // Create one egg yolk
        ItemStack yolk = new ItemStack(ModItems.EGG_YOLK.get());

        // Spawn the yolk where the egg landed
        ItemEntity yolkEntity = new ItemEntity(
                egg.level(),
                egg.getX(),
                egg.getY(),
                egg.getZ(),
                yolk
        );

        egg.level().addFreshEntity(yolkEntity);
    }
}