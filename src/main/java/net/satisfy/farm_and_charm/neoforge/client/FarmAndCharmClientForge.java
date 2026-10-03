package net.satisfy.morrow.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.satisfy.morrow.FarmAndCharm;
import net.satisfy.morrow.client.FarmAndCharmClient;
import net.satisfy.morrow.client.gui.CookingPotGui;
import net.satisfy.morrow.client.gui.RoasterGui;
import net.satisfy.morrow.client.gui.StoveGui;
import net.satisfy.morrow.client.particle.SoupBubbleParticle;
import net.satisfy.morrow.client.particle.SoupCookingBubbleParticle;
import net.satisfy.morrow.client.particle.SoupSteamParticle;
import net.satisfy.morrow.core.registry.ObjectRegistry;
import net.satisfy.morrow.core.registry.ParticleTypeRegistry;
import net.satisfy.morrow.core.registry.ScreenhandlerTypeRegistry;
import net.satisfy.morrow.neoforge.client.extensions.DungareesLeggingsExtensions;

@SuppressWarnings("removal")
@EventBusSubscriber(modid = FarmAndCharm.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class FarmAndCharmClientForge {

    @SubscribeEvent
    public static void beforeClientSetup(RegisterEvent event) {
        FarmAndCharmClient.preInitClient();
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        FarmAndCharmClient.onInitializeClient();
    }

    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ParticleTypeRegistry.SOUP_BUBBLE.get(), SoupBubbleParticle.Provider::new);
        event.registerSpriteSet(ParticleTypeRegistry.SOUP_STEAM.get(), SoupSteamParticle.Provider::new);
        event.registerSpriteSet(ParticleTypeRegistry.SOUP_COOKING_BUBBLE.get(), SoupCookingBubbleParticle.Provider::new);
    }

    @SubscribeEvent
    public static void clientSetup(RegisterMenuScreensEvent event) {
        event.register(ScreenhandlerTypeRegistry.STOVE_SCREEN_HANDLER.get(), StoveGui::new);
        event.register(ScreenhandlerTypeRegistry.COOKING_POT_SCREEN_HANDLER.get(), CookingPotGui::new);
        event.register(ScreenhandlerTypeRegistry.ROASTER_SCREEN_HANDLER.get(), RoasterGui::new);
    }

    @SubscribeEvent
    public static void registerClientExtensions(RegisterClientExtensionsEvent event) {
        event.registerItem(new DungareesLeggingsExtensions(), ObjectRegistry.DUNGAREES.get());
    }
}
