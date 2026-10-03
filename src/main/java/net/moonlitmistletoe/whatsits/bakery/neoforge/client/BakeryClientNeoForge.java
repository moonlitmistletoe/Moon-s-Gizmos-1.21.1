package net.moonlitmistletoe.whatsits.bakery.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.moonlitmistletoe.whatsits.bakery.Bakery;
import net.moonlitmistletoe.whatsits.bakery.client.BakeryClient;

@EventBusSubscriber(modid = Bakery.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class BakeryClientNeoForge {

    @SubscribeEvent
    public static void beforeClientSetup(RegisterEvent event) {
        BakeryClient.preInitClient();
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        BakeryClient.initClient();
    }
}
