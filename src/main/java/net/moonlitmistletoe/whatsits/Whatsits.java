package net.moonlitmistletoe.whatsits;

import net.moonlitmistletoe.whatsits.block.ModBlocks;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.moonlitmistletoe.whatsits.bakery.neoforge.core.config.BakeryNeoForgeConfig;
import net.moonlitmistletoe.whatsits.bakery.core.registry.CompostableRegistry;
import net.moonlitmistletoe.whatsits.bakery.Bakery;
import net.moonlitmistletoe.whatsits.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.moonlitmistletoe.whatsits.event.EggYolkHandler;
import net.moonlitmistletoe.whatsits.event.CropHarvestHandler;
import net.moonlitmistletoe.whatsits.event.CowRibDropHandler;
import net.moonlitmistletoe.whatsits.event.FoodEffectTooltipHandler;
import net.moonlitmistletoe.whatsits.util.HandcuffManager;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.moonlitmistletoe.whatsits.scabbard.component.ModDataComponents;
import net.moonlitmistletoe.whatsits.scabbard.config.ScabbardConfig;
import net.moonlitmistletoe.whatsits.scabbard.config.ScabbardItemCache;
import net.moonlitmistletoe.whatsits.scabbard.item.ModScabbardItems;
import net.moonlitmistletoe.whatsits.scabbard.networking.ModScabbardNetworking;

@Mod(Whatsits.MOD_ID)
public class Whatsits {

    public static final String MOD_ID = "whatsits";
    public static final Logger LOGGER = LogUtils.getLogger();

    public Whatsits(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);


        modContainer.registerConfig(
      ModConfig.Type.COMMON,
      BakeryNeoForgeConfig.COMMON_CONFIG
        );

        modEventBus.addListener((ModConfigEvent.Loading event) -> {
  if (event.getConfig().getSpec() == BakeryNeoForgeConfig.COMMON_CONFIG) {
      BakeryNeoForgeConfig.sync();
  }
        });

        modEventBus.addListener((ModConfigEvent.Reloading event) -> {
  if (event.getConfig().getSpec() == BakeryNeoForgeConfig.COMMON_CONFIG) {
      BakeryNeoForgeConfig.sync();
  }
        });

        Bakery.init();


        ModSounds.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        NeoForge.EVENT_BUS.register(EggYolkHandler.class);
        NeoForge.EVENT_BUS.register(CropHarvestHandler.class);
        NeoForge.EVENT_BUS.register(CowRibDropHandler.class);
        NeoForge.EVENT_BUS.register(FoodEffectTooltipHandler.class);
        NeoForge.EVENT_BUS.register(HandcuffManager.class);

        ModBlocks.register(modEventBus);
        ModItems.register(modEventBus);

        ModScabbardItems.register(modEventBus);
        ModDataComponents.register(modEventBus);
        ModScabbardNetworking.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.SERVER, ScabbardConfig.SPEC);


        ModCreativeModeTabs.register(modEventBus);

        // Only Whatsits' own config is registered.
        modContainer.registerConfig(
                ModConfig.Type.COMMON,
                Config.SPEC
        );
    }

    private void commonSetup(FMLCommonSetupEvent event) {
    event.enqueueWork(CompostableRegistry::registerCompostable);
}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        ScabbardItemCache.reload();
    }

}
