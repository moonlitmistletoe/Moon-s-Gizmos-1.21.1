package net.moonlitmistletoe.whatsits.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import java.util.Map;

public class CakeCuttingHandler {

    private static final String KNIFE_ID = "bakery:bread_knife";

    private static final Map<String, String> CAKE_SLICES = Map.ofEntries(
            Map.entry("bakery:strawberry_cake", "bakery:strawberry_cake_slice"),
            Map.entry("bakery:sweetberry_cake", "bakery:sweetberry_cake_slice"),
            Map.entry("bakery:chocolate_cake", "bakery:chocolate_cake_slice"),
            Map.entry("bakery:bundt_cake", "bakery:bundt_cake_slice"),
            Map.entry("bakery:linzer_tart", "bakery:linzer_tart_slice"),
            Map.entry("bakery:apple_pie", "bakery:apple_pie_slice"),
            Map.entry("bakery:glowberry_tart", "bakery:glowberry_pie_slice"),
            Map.entry("bakery:pudding", "bakery:pudding_slice"),
            Map.entry("bakery:chocolate_gateau", "bakery:chocolate_gateau_slice"),
            Map.entry("bakery:chocolate_tart", "bakery:chocolate_tart_slice")
    );

    @SubscribeEvent
    public static void onRightClickCake(PlayerInteractEvent.RightClickBlock event) {
        Level level = event.getLevel();

        if (level.isClientSide()) {
            return;
        }

        ItemStack knife = event.getItemStack();

        if (!KNIFE_ID.equals(BuiltInRegistries.ITEM.getKey(knife.getItem()).toString())) {
            return;
        }

        BlockPos pos = event.getPos();
        BlockState state = level.getBlockState(pos);
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(state.getBlock());

        String sliceId = CAKE_SLICES.get(blockId.toString());

        if (sliceId == null) {
            return;
        }

        ItemStack slice = new ItemStack(
                BuiltInRegistries.ITEM.get(ResourceLocation.parse(sliceId))
        );

        if (!event.getEntity().getAbilities().mayBuild()) {
            return;
        }

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        net.minecraft.world.level.block.Block.popResource(level, pos, slice);

        knife.hurtAndBreak(1, event.getEntity(), event.getHand().asEquipmentSlot());

        event.setCanceled(true);
        event.setCancellationResult(InteractionResult.SUCCESS);
    }
}
