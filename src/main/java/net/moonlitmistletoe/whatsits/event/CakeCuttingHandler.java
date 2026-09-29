package net.moonlitmistletoe.whatsits.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.satisfy.bakery.core.block.cake.PieBlock;

public class CakeCuttingHandler {

    private static final ResourceLocation KNIVES_TAG =
            ResourceLocation.fromNamespaceAndPath("bakery", "knives");

    @SubscribeEvent
    public static void onRightClickCake(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();

        if (level.isClientSide()) {
            return;
        }

        ItemStack knife = event.getItemStack();

        if (!knife.is(net.minecraft.tags.TagKey.create(
                net.minecraft.core.registries.Registries.ITEM,
                KNIVES_TAG
        ))) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);

        if (!(state.getBlock() instanceof PieBlock pie)) {
            return;
        }

        if (!event.getEntity().getAbilities().mayBuild()) {
            return;
        }

        int cuts = state.getValue(PieBlock.CUTS);
        int maxCuts = pie.getMaxCuts();

        if (cuts < maxCuts - 1) {
            level.setBlock(pos, state.setValue(PieBlock.CUTS, cuts + 1), 3);
        } else {
            level.removeBlock(pos, false);
        }

        ItemStack slice = pie.getPieSliceItem();

        if (!slice.isEmpty() && slice.getItem() != Items.AIR) {
            Block.popResource(level, pos, slice);
        }

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}
