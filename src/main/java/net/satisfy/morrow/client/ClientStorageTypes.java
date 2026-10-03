package net.satisfy.morrow.client;

import net.minecraft.resources.ResourceLocation;
import net.satisfy.morrow.client.renderer.block.*;
import net.satisfy.morrow.core.registry.StorageTypeRegistry;

public class ClientStorageTypes {
    public static void registerStorageType(ResourceLocation location, StorageTypeRenderer renderer) {
        StorageBlockEntityRenderer.registerStorageType(location, renderer);
    }

    public static void init() {
        registerStorageType(StorageTypeRegistry.TOOL_RACK, new ToolRackRenderer());
        registerStorageType(StorageTypeRegistry.WINDOW_SILL, new WindowSillRenderer());
        registerStorageType(StorageTypeRegistry.CHICKEN_NEST, new ChickenNestRenderer());
    }
}
