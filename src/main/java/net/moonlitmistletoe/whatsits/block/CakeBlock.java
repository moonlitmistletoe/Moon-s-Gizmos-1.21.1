package net.moonlitmistletoe.whatsits.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.function.Supplier;

public class CakeBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<CakeBlock> CODEC = simpleCodec(CakeBlock::new);
    public static final IntegerProperty CUTS = IntegerProperty.create("cuts", 0, 3);

    private static final VoxelShape FULL_SHAPE =
            Shapes.box(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D);

    private static final VoxelShape THREE_QUARTERS_SHAPE =
            Shapes.or(
                    Shapes.box(0.5D, 0.0D, 0.5D, 0.9375D, 0.5D, 0.9375D),
                    Shapes.box(0.0625D, 0.0D, 0.0625D, 0.5D, 0.5D, 0.9375D)
            );

    private static final VoxelShape HALF_SHAPE =
            Shapes.box(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.5D, 0.9375D);

    private static final VoxelShape QUARTER_SHAPE =
            Shapes.box(0.0625D, 0.0D, 0.0625D, 0.5D, 0.5D, 0.9375D);

    private final Supplier<Item> slice;

    public CakeBlock(Properties properties) {
        this(properties, null);
    }

    public CakeBlock(Properties properties, Supplier<Item> slice) {
        super(properties);
        this.slice = slice != null ? slice : () -> Items.AIR;

        this.registerDefaultState(this.defaultBlockState()
                .setValue(FACING, Direction.NORTH)
                .setValue(CUTS, 0));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, CUTS);
    }

    @Override
    protected ItemInteractionResult useItemOn(
            ItemStack stack,
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            InteractionHand hand,
            BlockHitResult hit
    ) {
        ItemStack held = player.getItemInHand(hand);

        if (held.isEmpty() && !player.isShiftKeyDown()) {
            if (!level.isClientSide) {
                popResource(level, pos, new ItemStack(this));
                level.removeBlock(pos, false);
            }
            return ItemInteractionResult.SUCCESS;
        }

        if (player.isShiftKeyDown()
                && (held.isEmpty() || held.getItem() instanceof SwordItem)) {
            if (!level.isClientSide) {
                Item sliceItem = slice.get();

                if (sliceItem != Items.AIR) {
                    ItemStack sliceStack = new ItemStack(sliceItem);
                    FoodProperties food = sliceStack.get(DataComponents.FOOD);

                    if (food != null && player.canEat(false)) {
                        player.getFoodData().eat(food);

                        int cuts = state.getValue(CUTS);
                        if (cuts < 2) {
                            level.setBlock(pos, state.setValue(CUTS, cuts + 1), 3);
                        } else {
                            level.removeBlock(pos, false);
                        }
                    }
                }
            }
            return ItemInteractionResult.SUCCESS;
        }

        if (!player.isShiftKeyDown() && held.getItem() instanceof SwordItem) {
            if (!level.isClientSide) {
                Item sliceItem = slice.get();

                if (sliceItem != Items.AIR) {
                    popResource(level, pos, new ItemStack(sliceItem));
                }

                int cuts = state.getValue(CUTS);
                if (cuts < 2) {
                    level.setBlock(pos, state.setValue(CUTS, cuts + 1), 3);
                } else {
                    level.removeBlock(pos, false);
                }
            }
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public VoxelShape getShape(
            BlockState state,
            BlockGetter level,
            BlockPos pos,
            CollisionContext context
    ) {
        return switch (state.getValue(CUTS)) {
            case 1 -> THREE_QUARTERS_SHAPE;
            case 2 -> HALF_SHAPE;
            case 3 -> QUARTER_SHAPE;
            default -> FULL_SHAPE;
        };
    }
}
