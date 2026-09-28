package net.moonlitmistletoe.whatsits.event;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.moonlitmistletoe.whatsits.item.ModItems;

public class CowRibDropHandler {

    @SubscribeEvent
    public static void onCowKilled(LivingDeathEvent event) {
        if (!(event.getEntity() instanceof Cow cow)) {
            return;
        }

        if (cow.level().isClientSide()) {
            return;
        }

        if (!(event.getSource().getEntity() instanceof Player player)) {
            return;
        }

        ItemStack weapon = player.getMainHandItem();

        if (weapon.isEmpty()) {
            return;
        }

        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(weapon.getItem());

        if (itemId == null || !itemId.getPath().contains("cleaver")) {
            return;
        }

        if (cow.getRandom().nextFloat() >= 0.25F) {
            return;
        }

        cow.level().addFreshEntity(new ItemEntity(
                cow.level(),
                cow.getX(),
                cow.getY(),
                cow.getZ(),
                new ItemStack(ModItems.RAW_COW_RIBS.get())
        ));
    }
}
