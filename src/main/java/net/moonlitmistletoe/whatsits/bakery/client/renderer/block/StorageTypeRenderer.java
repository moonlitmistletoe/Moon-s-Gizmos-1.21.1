package net.moonlitmistletoe.whatsits.bakery.client.renderer.block;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.moonlitmistletoe.whatsits.bakery.core.block.entity.StorageBlockEntity;

public interface StorageTypeRenderer {
    void render(StorageBlockEntity var1, PoseStack var2, MultiBufferSource var3, NonNullList<ItemStack> var4);
}
