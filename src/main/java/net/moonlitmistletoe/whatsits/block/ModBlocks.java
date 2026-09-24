package net.moonlitmistletoe.whatsits.block;

import net.minecraft.world.level.block.Blocks;
import net.moonlitmistletoe.whatsits.Whatsits;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(Whatsits.MOD_ID);

    public static final DeferredBlock<BlackberryCropBlock> BLACKBERRY_CROP =
            BLOCKS.register("blackberry_crop",
                    () -> new BlackberryCropBlock(Blocks.WHEAT.properties()));

    public static final DeferredBlock<BlueberryCropBlock> BLUEBERRY_CROP =
            BLOCKS.register("blueberry_crop",
                    () -> new BlueberryCropBlock(Blocks.WHEAT.properties()));

    public static final DeferredBlock<CoffeeCropBlock> COFFEE_CROP =
            BLOCKS.register("coffee_crop",
                    () -> new CoffeeCropBlock(Blocks.WHEAT.properties()));

    public static final DeferredBlock<StrawberryCropBlock> STRAWBERRY_CROP =
            BLOCKS.register("strawberry_crop",
                    () -> new StrawberryCropBlock(Blocks.WHEAT.properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}