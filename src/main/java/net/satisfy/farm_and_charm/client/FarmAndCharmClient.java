package net.satisfy.morrow.client;

import dev.architectury.registry.client.level.entity.EntityModelLayerRegistry;
import dev.architectury.registry.client.level.entity.EntityRendererRegistry;
import dev.architectury.registry.client.particle.ParticleProviderRegistry;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.architectury.registry.client.rendering.ColorHandlerRegistry;
import dev.architectury.registry.client.rendering.RenderTypeRegistry;
import dev.architectury.registry.menu.MenuRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.RenderType;
import net.satisfy.morrow.client.gui.CookingPotGui;
import net.satisfy.morrow.client.model.DungareesLeggingsModel;
import net.satisfy.morrow.client.model.PlowCartModel;
import import import net.satisfy.morrow.client.model.SeederCartModel;
import net.satisfy.morrow.client.model.SupplyCartModel;
import net.satisfy.morrow.client.model.WaterSprinklerModel;
import net.satisfy.morrow.client.particle.SoupBubbleParticle;
import net.satisfy.morrow.client.particle.SoupCookingBubbleParticle;
import net.satisfy.morrow.client.particle.SoupSteamParticle;
import net.satisfy.morrow.client.renderer.block.StorageBlockEntityRenderer;
import net.satisfy.morrow.client.renderer.block.ToolRackRenderer;
import net.satisfy.morrow.client.renderer.block.WaterSprinklerRenderer;
import net.satisfy.morrow.client.renderer.entity.PlowCartRenderer;
import net.satisfy.morrow.client.renderer.entity.SeederCartRenderer;
import net.satisfy.morrow.client.renderer.entity.SupplyCartRenderer;
import net.satisfy.morrow.core.registry.EntityTypeRegistry;
import net.satisfy.morrow.core.registry.ParticleTypeRegistry;
import net.satisfy.morrow.core.registry.ScreenhandlerTypeRegistry;
import net.satisfy.morrow.core.registry.StorageTypeRegistry;

import static net.satisfy.morrow.core.registry.ObjectRegistry.*;

public class FarmAndCharmClient {
    public static void onInitializeClient() {
        RenderTypeRegistry.register(RenderType.cutout(), WATER_SPRINKLER.get(), COOKING_POT.get());
        ParticleProviderRegistry.register(ParticleTypeRegistry.SOUP_BUBBLE.get(), SoupBubbleParticle.Provider::new);
        ParticleProviderRegistry.register(ParticleTypeRegistry.SOUP_STEAM.get(), SoupSteamParticle.Provider::new);
        ParticleProviderRegistry.register(ParticleTypeRegistry.SOUP_COOKING_BUBBLE.get(), SoupCookingBubbleParticle.Provider::new);
        ColorHandlerRegistry.registerBlockColors((state, world, pos, tintIndex) -> {
            if (world == null || pos == null) return -1;
            return BiomeColors.getAverageWaterColor(world, pos);
        }, WATER_TROUGH.get());
        registerStorageTypeRenderers();
        registerBlockEntityRenderer();
        MenuRegistry.registerScreenFactory(ScreenhandlerTypeRegistry.COOKING_POT_SCREEN_HANDLER.get(), CookingPotGui::new);
    }

    public static void registerEntityRenderers() {
        EntityRendererRegistry.register(EntityTypeRegistry.SUPPLY_CART, SupplyCartRenderer::new);
        EntityRendererRegistry.register(EntityTypeRegistry.PLOW, PlowCartRenderer::new);
        EntityRendererRegistry.register(EntityTypeRegistry.SEEDER, SeederCartRenderer::new);
    }

    public static void preInitClient() {
        registerEntityRenderers();
        registerEntityModelLayer();
    }

    public static void registerEntityModelLayer() {
        EntityModelLayerRegistry.register(WaterSprinklerModel.LAYER_LOCATION, WaterSprinklerModel::getTexturedModelData);
        EntityModelLayerRegistry.register(SupplyCartModel.LAYER_LOCATION, SupplyCartModel::createBodyLayer);
        EntityModelLayerRegistry.register(PlowCartModel.LAYER_LOCATION, PlowCartModel::createBodyLayer);
        EntityModelLayerRegistry.register(SeederCartModel.LAYER_LOCATION, SeederCartModel::createBodyLayer);
        EntityModelLayerRegistry.register(DungareesLeggingsModel.LAYER_LOCATION, DungareesLeggingsModel::createBodyLayer);
    }

    public static void registerStorageTypeRenderers() {
        StorageBlockEntityRenderer.registerStorageType(StorageTypeRegistry.TOOL_RACK, new ToolRackRenderer());
    }

    public static void registerBlockEntityRenderer() {
        BlockEntityRendererRegistry.register(EntityTypeRegistry.SPRINKLER_BLOCK_ENTITY.get(), WaterSprinklerRenderer::new);
        BlockEntityRendererRegistry.register(EntityTypeRegistry.STORAGE_ENTITY.get(), context -> new StorageBlockEntityRenderer());
    }
}
