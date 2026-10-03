package net.moonlitmistletoe.whatsits.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks("whatsits");

    public static final DeferredBlock<BlackberryCropBlock> BLACKBERRY_CROP;
    public static final DeferredBlock<BlueberryCropBlock> BLUEBERRY_CROP;
    public static final DeferredBlock<CoffeeCropBlock> COFFEE_CROP;
    public static final DeferredBlock<StrawberryCropBlock> STRAWBERRY_CROP;

    public static final DeferredBlock<CakeBlock> STRAWBERRY_CAKE;
    public static final DeferredBlock<CakeBlock> SWEETBERRY_CAKE;
    public static final DeferredBlock<CakeBlock> CHOCOLATE_CAKE;
    public static final DeferredBlock<CakeBlock> BUNDT_CAKE;
    public static final DeferredBlock<CakeBlock> LINZER_TART;
    public static final DeferredBlock<CakeBlock> GLOWBERRY_TART;
    public static final DeferredBlock<CakeBlock> PUDDING;
    public static final DeferredBlock<CakeBlock> CHOCOLATE_GATEAU;
    public static final DeferredBlock<CakeBlock> CHOCOLATE_TART;
    public static final DeferredBlock<CakeBlock> APPLE_PIE;

    public static final DeferredBlock<SimpleBlock> BLANK_CAKE;
    public static final DeferredBlock<FoodBlock> APPLE_CUPCAKE_BLOCK;
    public static final DeferredBlock<FoodBlock> SWEETBERRY_CUPCAKE_BLOCK;
    public static final DeferredBlock<FoodBlock> STRAWBERRY_CUPCAKE_BLOCK;
    public static final DeferredBlock<FoodBlock> CHOCOLATE_COOKIE_BLOCK;
    public static final DeferredBlock<FoodBlock> SWEETBERRY_COOKIE_BLOCK;
    public static final DeferredBlock<FoodBlock> STRAWBERRY_COOKIE_BLOCK;
    public static final DeferredBlock<FoodBlock> CRUSTY_BREAD_BLOCK;
    public static final DeferredBlock<FoodBlock> BREAD_BLOCK;
    public static final DeferredBlock<FoodBlock> BAGUETTE_BLOCK;
    public static final DeferredBlock<FoodBlock> TOAST_BLOCK;
    public static final DeferredBlock<FoodBlock> BRAIDED_BREAD_BLOCK;
    public static final DeferredBlock<FoodBlock> BUN_BLOCK;
    public static final DeferredBlock<StackableBlock> WAFFLE_BLOCK;
    public static final DeferredBlock<StackableBlock> JAR;
    public static final DeferredBlock<SimpleBlock> GLOWBERRY_JAM;
    public static final DeferredBlock<SimpleBlock> SWEETBERRY_JAM;
    public static final DeferredBlock<StackableBlock> CHOCOLATE_JAM;
    public static final DeferredBlock<SimpleBlock> APPLE_JAM;

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    static {
        BLACKBERRY_CROP = BLOCKS.register("blackberry_crop",
                () -> new BlackberryCropBlock(Blocks.WHEAT.properties()));
        BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
                () -> new BlueberryCropBlock(Blocks.WHEAT.properties()));
        COFFEE_CROP = BLOCKS.register("coffee_crop",
                () -> new CoffeeCropBlock(Blocks.WHEAT.properties()));
        STRAWBERRY_CROP = BLOCKS.register("strawberry_crop",
                () -> new StrawberryCropBlock(Blocks.WHEAT.properties()));

        STRAWBERRY_CAKE = registerCakeBlock("strawberry_cake", () -> ModItems.STRAWBERRY_CAKE_SLICE.get());
        SWEETBERRY_CAKE = registerCakeBlock("sweetberry_cake", () -> ModItems.SWEETBERRY_CAKE_SLICE.get());
        CHOCOLATE_CAKE = registerCakeBlock("chocolate_cake", () -> ModItems.CHOCOLATE_CAKE_SLICE.get());
        BUNDT_CAKE = registerCakeBlock("bundt_cake", () -> ModItems.BUNDT_CAKE_SLICE.get());
        LINZER_TART = registerCakeBlock("linzer_tart", () -> ModItems.LINZER_TART_SLICE.get());
        GLOWBERRY_TART = registerCakeBlock("glowberry_tart", () -> ModItems.GLOWBERRY_PIE_SLICE.get());
        PUDDING = registerCakeBlock("pudding", () -> ModItems.PUDDING_SLICE.get());
        CHOCOLATE_GATEAU = registerCakeBlock("chocolate_gateau", () -> ModItems.CHOCOLATE_GATEAU_SLICE.get());
        CHOCOLATE_TART = registerCakeBlock("chocolate_tart", () -> ModItems.CHOCOLATE_TART_SLICE.get());
        APPLE_PIE = registerCakeBlock("apple_pie", () -> ModItems.APPLE_PIE_SLICE.get());

        BLANK_CAKE = registerSimpleBlock("blank_cake",
                () -> new SimpleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)));

        APPLE_CUPCAKE_BLOCK = registerFoodBlock("apple_cupcake_block");
        SWEETBERRY_CUPCAKE_BLOCK = registerFoodBlock("sweetberry_cupcake_block");
        STRAWBERRY_CUPCAKE_BLOCK = registerFoodBlock("strawberry_cupcake_block");
        CHOCOLATE_COOKIE_BLOCK = registerFoodBlock("chocolate_cookie_block");
        SWEETBERRY_COOKIE_BLOCK = registerFoodBlock("sweetberry_cookie_block");
        STRAWBERRY_COOKIE_BLOCK = registerFoodBlock("strawberry_cookie_block");
        CRUSTY_BREAD_BLOCK = registerFoodBlock("crusty_bread_block");
        BREAD_BLOCK = registerFoodBlock("bread_block");
        BAGUETTE_BLOCK = registerFoodBlock("baguette_block");
        TOAST_BLOCK = registerFoodBlock("toast_block");
        BRAIDED_BREAD_BLOCK = registerFoodBlock("braided_bread_block");
        BUN_BLOCK = registerFoodBlock("bun_block");

        WAFFLE_BLOCK = registerStackableBlock("waffle_block",
                BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE));
        JAR = registerStackableBlock("jar",
                BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion());

        GLOWBERRY_JAM = registerSimpleBlock("glowberry_jam",
                () -> new SimpleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
        SWEETBERRY_JAM = registerSimpleBlock("sweetberry_jam",
                () -> new SimpleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
        CHOCOLATE_JAM = registerStackableBlock("chocolate_jam",
                BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion());
        APPLE_JAM = registerSimpleBlock("apple_jam",
                () -> new SimpleBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS).noOcclusion()));
    }

    private static DeferredBlock<CakeBlock> registerCakeBlock(
            String name,
            java.util.function.Supplier<net.minecraft.world.item.Item> slice
    ) {
        return BLOCKS.register(name, () -> new CakeBlock(
                BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE).noOcclusion(),
                slice
        ));
    }

    private static DeferredBlock<SimpleBlock> registerSimpleBlock(
            String name,
            java.util.function.Supplier<SimpleBlock> supplier
    ) {
        return BLOCKS.register(name, supplier);
    }

    private static DeferredBlock<FoodBlock> registerFoodBlock(String name) {
        return BLOCKS.register(name, () -> new FoodBlock(
                BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE)
        ));
    }

    private static DeferredBlock<StackableBlock> registerStackableBlock(
            String name,
            BlockBehaviour.Properties properties
    ) {
        return BLOCKS.register(name, () -> new StackableBlock(properties));
    }
}
