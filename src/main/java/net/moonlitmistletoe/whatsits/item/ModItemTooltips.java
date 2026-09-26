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

        if (stack.is(ModItems.DORIME.get())) {
            event.getToolTip().add(
                    Component.translatable("item.whatsits.dorime.description")
                            .withStyle(ChatFormatting.GRAY)
            );
        }
    }
}