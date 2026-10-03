package net.moonlitmistletoe.whatsits.client;

import com.mojang.datafixers.util.Either;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.neoforged.bus.api.EventPriority;

import java.util.List;

public final class MorrowClient {
    private MorrowClient() {
    }

    public static void register() {
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.addListener(
                EventPriority.LOWEST,
                (RenderTooltipEvent.GatherComponents event) -> removeFarmAndCharmModName(event)
        );
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.addListener(
                EventPriority.LOWEST,
                (ItemTooltipEvent event) -> removeFarmAndCharmModName(event)
        );
    }

    public static void registerCreativeTabEvents(net.neoforged.bus.api.IEventBus modEventBus) {
        modEventBus.addListener(MorrowClient::removeFarmAndCharmTabContents);
    }

    private static void removeFarmAndCharmTabContents(BuildCreativeModeTabContentsEvent event) {
        String name = event.getTab().getDisplayName().getString();

        if (name.equals("Farm & Charm") || name.equals("[Let's Do] Farm & Charm")) {
            for (net.minecraft.world.item.ItemStack stack : new java.util.ArrayList<>(event.getParentEntries())) {
                event.remove(stack, net.minecraft.world.item.CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
            }

            for (net.minecraft.world.item.ItemStack stack : new java.util.ArrayList<>(event.getSearchEntries())) {
                event.remove(stack, net.minecraft.world.item.CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            }
        }
    }

    private static void removeFarmAndCharmModName(RenderTooltipEvent.GatherComponents event) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());

        if (!"farm_and_charm".equals(id.getNamespace())) {
            return;
        }

        List<Either<net.minecraft.network.chat.FormattedText, net.minecraft.world.inventory.tooltip.TooltipComponent>> elements =
                event.getTooltipElements();

        elements.removeIf(element -> element.left().map(text -> {
            String value = text.getString();
            return value.equals("Farm & Charm") || value.equals("[Let's Do] Farm & Charm");
        }).orElse(false));
    }

    private static void removeFarmAndCharmModName(ItemTooltipEvent event) {
        ResourceLocation id = BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem());

        if (!"farm_and_charm".equals(id.getNamespace())) {
            return;
        }

        event.getToolTip().removeIf(component -> {
            String value = component.getString();
            return value.equals("Farm & Charm") || value.equals("[Let's Do] Farm & Charm");
        });
    }
}
