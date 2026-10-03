package net.moonlitmistletoe.whatsits.bakery;

import net.minecraft.resources.ResourceLocation;
import net.moonlitmistletoe.whatsits.bakery.core.event.CommonEvents;
import net.moonlitmistletoe.whatsits.bakery.core.network.PacketHandler;
import net.moonlitmistletoe.whatsits.bakery.core.registry.*;

public class Bakery {
    public static final String MOD_ID = "whatsits";

    public static ResourceLocation identifier(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        MobEffectRegistry.init();
        ObjectRegistry.init();
        EntityTypeRegistry.init();
        RecipeTypeRegistry.init();
        PacketHandler.init();
        CommonEvents.init();
        TabRegistry.init();
        SoundEventRegistry.init();
    }
}

