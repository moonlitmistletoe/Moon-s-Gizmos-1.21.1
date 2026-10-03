package net.satisfy.morrow;

import net.minecraft.resources.ResourceLocation;
import net.satisfy.morrow.core.event.VanillaItemPlacements;
import net.satisfy.morrow.core.network.PacketHandler;
import net.satisfy.morrow.core.registry.*;
import net.satisfy.morrow.core.util.CartInteractionHooks;

public class FarmAndCharm {
    public static final String MOD_ID = "morrow";

    public static ResourceLocation identifier(String name) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }

    public static void init() {
        MobEffectRegistry.init();
        ObjectRegistry.init();
        ParticleTypeRegistry.init();
        VanillaItemPlacements.init();
        EntityTypeRegistry.init();
        TabRegistry.init();
        ScreenhandlerTypeRegistry.init();
        SoundEventRegistry.init();
        RecipeTypeRegistry.init();
        VillagerTradeRegistryHandler.init();
        PacketHandler.init();
        CartInteractionHooks.init();
    }
}