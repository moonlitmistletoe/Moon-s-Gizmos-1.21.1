package net.satisfy.morrow.core.registry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.satisfy.morrow.FarmAndCharm;

import java.util.Set;

public class StorageTypeRegistry {
    public static final ResourceLocation TOOL_RACK = FarmAndCharm.identifier("tool_rack");

    public static Set<Block> registerBlocks(Set<Block> blocks) {
        blocks.add(ObjectRegistry.TOOL_RACK.get());
        return blocks;
    }
}
