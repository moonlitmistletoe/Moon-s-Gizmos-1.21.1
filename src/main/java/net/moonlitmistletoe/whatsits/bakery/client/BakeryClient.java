package net.moonlitmistletoe.whatsits.bakery.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.moonlitmistletoe.whatsits.bakery.client.gui.StreetSignEditGui;
import net.moonlitmistletoe.whatsits.bakery.client.renderer.block.*;
import net.moonlitmistletoe.whatsits.bakery.core.block.entity.StreetSignBlockEntity;
import net.moonlitmistletoe.whatsits.bakery.core.registry.EntityTypeRegistry;
import net.moonlitmistletoe.whatsits.bakery.core.registry.ObjectRegistry;
import net.moonlitmistletoe.whatsits.bakery.core.registry.StorageTypeRegistry;

public class BakeryClient {

    public static void initClient() {
        RenderTypeRegistry.register(RenderType.cutout(),
                , ObjectRegistry.SWEETBERRY_JAM.get(), ObjectRegistry.CHOCOLATE_JAM.get(),
                ObjectRegistry.STRAWBERRY_JAM.get(), ObjectRegistry.GLOWBERRY_JAM.get(), ObjectRegistry.APPLE_JAM.get(), ObjectRegistry.CAKE_DISPLAY.get(), ObjectRegistry.SMALL_COOKING_POT.get(),
                ObjectRegistry.IRON_BENCH.get(), ObjectRegistry.BAKER_STATION.get(), ObjectRegistry.TRAY.get()
        );

        registerStorageType();
        registerBlockEntityRenderer();
        RenderTypeRegistry.register(RenderType.translucent(), ObjectRegistry.CAKE_STAND.get());

        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) {
                return -1;
            }
            return BiomeColors.getAverageWaterColor(world, pos);
        }, ObjectRegistry.KITCHEN_SINK.get());

    }

    public static void openStreetSignScreen(StreetSignBlockEntity entity) {
        Minecraft.getInstance().setScreen(new StreetSignEditGui(entity));
    }

    public static void preInitClient() {
        registerEntityModelLayer();
    }

    public static void registerStorageType(ResourceLocation location, StorageTypeRenderer renderer) {
       StorageBlockEntityRenderer.registerStorageType(location, renderer);
    }

    public static void registerStorageType() {
        registerStorageType(StorageTypeRegistry.CAKE_STAND, new CakeStandRenderer());
        registerStorageType(StorageTypeRegistry.TRAY, new TrayRenderer());
        
        registerStorageType(StorageTypeRegistry.CAKE_DISPLAY, new CakeDisplayRenderer());
        registerStorageType(StorageTypeRegistry.CUPCAKE_DISPLAY, new CupcakeDisplayRenderer());
        registerStorageType(StorageTypeRegistry.WALL_DISPLAY, new WallDisplayRenderer());
    }

    public static void registerBlockEntityRenderer() {
        
        BlockEntityRendererRegistry.register(EntityTypeRegistry.STORAGE_ENTITY.get(), context -> new StorageBlockEntityRenderer());
        
    }

    public static void registerEntityModelLayer() {
        
    }
}
