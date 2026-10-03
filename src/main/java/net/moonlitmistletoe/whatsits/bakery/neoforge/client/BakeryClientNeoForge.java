package net.moonlitmistletoe.whatsits.bakery.neoforge.client;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.moonlitmistletoe.whatsits.bakery.client.BakeryClient;

public class BakeryClientNeoForge {

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(BakeryClientNeoForge::beforeClientSetup);
        modEventBus.addListener(BakeryClientNeoForge::onClientSetup);
    }

    public static void beforeClientSetup(RegisterEvent event) {
        BakeryClient.preInitClient();
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        BakeryClient.initClient();
    }
}
