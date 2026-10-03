package net.moonlitmistletoe.whatsits.client;

import com.mojang.datafixers.util.Either;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.neoforge.client.event.RenderTooltipEvent;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

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
