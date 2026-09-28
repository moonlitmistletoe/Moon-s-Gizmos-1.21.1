package net.moonlitmistletoe.whatsits;

import net.moonlitmistletoe.whatsits.block.ModBlocks;
import net.moonlitmistletoe.whatsits.event.CowRibDropHandler;
import net.moonlitmistletoe.whatsits.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.moonlitmistletoe.whatsits.event.CampfireCompatibilityHandler;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

@Mod(Whatsits.MOD_ID)
public class Whatsits {

    public static final String MOD_ID = "whatsits";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Whatsits(IEventBus modEventBus, ModContainer modContainer) {

        // Register common setup
        modEventBus.addListener(this::commonSetup);

        // Adds Right Click  cancellation
        NeoForge.EVENT_BUS.register(CampfireCompatibilityHandler.class);

        // Register Sounds
        ModSounds.register(modEventBus);

        // Register server/game events
        NeoForge.EVENT_BUS.register(this);

        // Register egg yolk event handler
        NeoForge.EVENT_BUS.register(EggYolkHandler.class);

        // Register crop harvest event handler
        NeoForge.EVENT_BUS.register(CropHarvestHandler.class);
        NeoForge.EVENT_BUS.register(CowRibDropHandler.class);

        // Register blocks
        ModBlocks.register(modEventBus);

        // Register items
        ModItems.register(modEventBus);

        // Register creative tab
        ModCreativeModeTabs.register(modEventBus);

        // Register config
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}