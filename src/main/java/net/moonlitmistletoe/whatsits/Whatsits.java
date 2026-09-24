package net.moonlitmistletoe.whatsits;

import net.minecraft.world.item.CreativeModeTabs;
import net.moonlitmistletoe.whatsits.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Whatsits.MOD_ID)
public class Whatsits {

    public static final String MOD_ID = "whatsits";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Whatsits(IEventBus modEventBus, ModContainer modContainer) {

        // Register common setup
        modEventBus.addListener(this::commonSetup);

        // Register server/game events
        NeoForge.EVENT_BUS.register(this);

        // Register egg yolk event handler
        NeoForge.EVENT_BUS.register(EggYolkHandler.class);

        // Register items
        ModItems.register(modEventBus);

        // Register creative tab contents
        modEventBus.addListener(this::addCreative);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {

            event.accept(ModItems.EGG_YOLK);
            event.accept(ModItems.APPLE_JUICE);
            event.accept(ModItems.APPLE_PIE);
            event.accept(ModItems.AVOCADO);
            event.accept(ModItems.AVOCADO_TOAST);
            event.accept(ModItems.BLACKBERRY);
            event.accept(ModItems.BLACKBERRY_JAM);
            event.accept(ModItems.BLUEBERRY);
            event.accept(ModItems.BLUEBERRY_JAM);
            event.accept(ModItems.CHERRY);
            event.accept(ModItems.CHERRY_JAM);
            event.accept(ModItems.CHERRY_JUICE);
            event.accept(ModItems.CHERRY_PIE);
            event.accept(ModItems.COFFEE);
            event.accept(ModItems.MOONCAKE);
            event.accept(ModItems.SCRAMBLED_EGGS);
            event.accept(ModItems.STRAWBERRY);
            event.accept(ModItems.STRAWBERRY_ICE_CREAM);
            event.accept(ModItems.STRAWBERRY_JAM);
            event.accept(ModItems.STRAWBERRY_SMOOTHIE);
            event.accept(ModItems.SUNNY_SIDE_EGGS);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}