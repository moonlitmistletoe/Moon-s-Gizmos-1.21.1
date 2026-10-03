package net.moonlitmistletoe.whatsits.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;

public class ModItemTooltips {

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {

        ItemStack stack = event.getItemStack();

        if (stack.is(ModItems.DORIME.get()) || stack.is(ModItems.WORLD_OF_LIES.get())) {
            event.getToolTip().add(
                    Component.translatable(stack.is(ModItems.DORIME.get()) ? "tooltip.whatsits.dorime.description" : "tooltip.whatsits.world_of_lies.description")
                            .withStyle(ChatFormatting.GRAY)
            );
        }
    }
}