package net.moonlitmistletoe.whatsits;

import net.minecraft.client.Minecraft;
import net.satisfy.bakery.client.BakeryClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Whatsits.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Whatsits.MOD_ID, value = Dist.CLIENT)
public class WhatsitsClient {

    public WhatsitsClient(ModContainer container, net.neoforged.bus.api.IEventBus modEventBus) {
        modEventBus.addListener(RegisterEvent.class, event -> BakeryClient.preInitClient());
        modEventBus.addListener(FMLClientSetupEvent.class, event -> BakeryClient.initClient());

        container.registerExtensionPoint(
                IConfigScreenFactory.class,
                ConfigurationScreen::new
        );
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        Whatsits.LOGGER.info("HELLO FROM CLIENT SETUP");
        Whatsits.LOGGER.info(
                "MINECRAFT NAME >> {}",
                Minecraft.getInstance().getUser().getName()
        );
    }
}