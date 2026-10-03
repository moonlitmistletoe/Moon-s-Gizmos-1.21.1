package net.moonlitmistletoe.whatsits.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.moonlitmistletoe.whatsits.block.ModBlocks;
import net.moonlitmistletoe.whatsits.item.custom.DrinkItem;
import net.moonlitmistletoe.whatsits.item.custom.HandcuffsItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems("whatsits");

    public static final DeferredItem<Item> MOD_LOGO;
    public static final DeferredItem<Item> MANUAL;
    public static final DeferredItem<Item> BLACKBERRY_SEED;
    public static final DeferredItem<Item> BLUEBERRY_SEED;
    public static final DeferredItem<Item> COFFEE_SEED;
    public static final DeferredItem<Item> STRAWBERRY_SEED;
    public static final DeferredItem<Item> EGG_YOLK;
    public static final DeferredItem<Item> AVOCADO;
    public static final DeferredItem<Item> BLACKBERRY;
    public static final DeferredItem<Item> BLUEBERRY;
    public static final DeferredItem<Item> CHERRY;
    public static final DeferredItem<Item> COFFEE_BEANS;
    public static final DeferredItem<Item> STRAWBERRY;
    public static final DeferredItem<Item> RAW_COW_RIBS;
    public static final DeferredItem<Item> APPLE_JUICE;
    public static final DeferredItem<Item> CHERRY_JUICE;
    public static final DeferredItem<Item> COFFEE;
    public static final DeferredItem<Item> STRAWBERRY_SMOOTHIE;
    public static final DeferredItem<Item> AVOCADO_TOAST;
    public static final DeferredItem<Item> BLACKBERRY_JAM;
    public static final DeferredItem<Item> BLUEBERRY_JAM;
    public static final DeferredItem<Item> CHERRY_JAM;
    public static final DeferredItem<Item> SCRAMBLED_EGGS;
    public static final DeferredItem<Item> SUNNY_SIDE_EGGS;
    public static final DeferredItem<Item> COOKED_COW_RIBS;
    public static final DeferredItem<Item> APPLE_PIE_SLICE;
    public static final DeferredItem<Item> CHERRY_PIE;
    public static final DeferredItem<Item> MOONCAKE;
    public static final DeferredItem<Item> STRAWBERRY_ICE_CREAM;
    public static final ResourceKey<JukeboxSong> DORIME_SONG;
    public static final DeferredItem<Item> DORIME;
    public static final ResourceKey<JukeboxSong> WORLD_OF_LIES_SONG;
    public static final DeferredItem<Item> WORLD_OF_LIES;
    public static final DeferredItem<Item> HANDCUFFS;

    public static final DeferredItem<Item> ROLLING_PIN;
    public static final DeferredItem<Item> BREAD_KNIFE;
    public static final DeferredItem<Item> STRAWBERRY_CAKE_SLICE;
    public static final DeferredItem<Item> SWEETBERRY_CAKE_SLICE;
    public static final DeferredItem<Item> CHOCOLATE_CAKE_SLICE;
    public static final DeferredItem<Item> CHOCOLATE_GATEAU_SLICE;
    public static final DeferredItem<Item> BUNDT_CAKE_SLICE;
    public static final DeferredItem<Item> LINZER_TART_SLICE;
    public static final DeferredItem<Item> GLOWBERRY_PIE_SLICE;
    public static final DeferredItem<Item> CHOCOLATE_TART_SLICE;
    public static final DeferredItem<Item> PUDDING_SLICE;
    public static final DeferredItem<Item> CAKE_DOUGH;
    public static final DeferredItem<Item> SWEET_DOUGH;
    public static final DeferredItem<Item> CROISSANT;
    public static final DeferredItem<Item> CRUSTY_BREAD;
    public static final DeferredItem<Item> BREAD;
    public static final DeferredItem<Item> BAGUETTE;
    public static final DeferredItem<Item> TOAST;
    public static final DeferredItem<Item> BRAIDED_BREAD;
    public static final DeferredItem<Item> SANDWICH;
    public static final DeferredItem<Item> VEGETABLE_SANDWICH;
    public static final DeferredItem<Item> GRILLED_SALMON_SANDWICH;
    public static final DeferredItem<Item> GRILLED_BACON_SANDWICH;
    public static final DeferredItem<Item> BREAD_WITH_JAM;
    public static final DeferredItem<Item> STRAWBERRY_GLAZED_COOKIE;
    public static final DeferredItem<Item> SWEETBERRY_GLAZED_COOKIE;
    public static final DeferredItem<Item> CHOCOLATE_GLAZED_COOKIE;
    public static final DeferredItem<Item> STRAWBERRY_CUPCAKE;
    public static final DeferredItem<Item> SWEETBERRY_CUPCAKE;
    public static final DeferredItem<Item> APPLE_CUPCAKE;
    public static final DeferredItem<Item> CORNET;
    public static final DeferredItem<Item> JAM_ROLL;
    public static final DeferredItem<Item> CHOCOLATE_TRUFFLE;
    public static final DeferredItem<Item> MISSLILITU_BISCUIT;
    public static final DeferredItem<Item> WAFFLE;
    public static final DeferredItem<Item> BUN;
    public static final DeferredItem<Item> STRAWBERRY_JAM;

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    static {
        MOD_LOGO = ITEMS.register("mod_logo", () -> new Item(new Item.Properties()));
        MANUAL = ITEMS.register("manual", () -> new Item(new Item.Properties()));

        BLACKBERRY_SEED = ITEMS.register("blackberry_seed", () -> new ItemNameBlockItem((Block) ModBlocks.BLACKBERRY_CROP.get(), new Item.Properties()));
        BLUEBERRY_SEED = ITEMS.register("blueberry_seed", () -> new ItemNameBlockItem((Block) ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties()));
        COFFEE_SEED = ITEMS.register("coffee_seed", () -> new ItemNameBlockItem((Block) ModBlocks.COFFEE_CROP.get(), new Item.Properties()));
        STRAWBERRY_SEED = ITEMS.register("strawberry_seed", () -> new ItemNameBlockItem((Block) ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));

        EGG_YOLK = ITEMS.register("egg_yolk", () -> new Item(new Item.Properties().food(ModFoodProperties.EGG_YOLK)));
        AVOCADO = ITEMS.register("avocado", () -> new Item(new Item.Properties().food(ModFoodProperties.AVOCADO)));
        BLACKBERRY = ITEMS.register("blackberry", () -> new Item(new Item.Properties().food(ModFoodProperties.BLACKBERRY)));
        BLUEBERRY = ITEMS.register("blueberry", () -> new Item(new Item.Properties().food(ModFoodProperties.BLUEBERRY)));
        CHERRY = ITEMS.register("cherry", () -> new Item(new Item.Properties().food(ModFoodProperties.CHERRY)));
        COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new Item(new Item.Properties()));
        STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties().food(ModFoodProperties.STRAWBERRY)));
        RAW_COW_RIBS = ITEMS.register("raw_cow_ribs", () -> new Item(new Item.Properties().food(ModFoodProperties.RAW_COW_RIBS)));
        APPLE_JUICE = ITEMS.register("apple_juice", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.APPLE_JUICE)));
        CHERRY_JUICE = ITEMS.register("cherry_juice", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.CHERRY_JUICE)));
        COFFEE = ITEMS.register("coffee", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.COFFEE)));
        STRAWBERRY_SMOOTHIE = ITEMS.register("strawberry_smoothie", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.STRAWBERRY_SMOOTHIE)));
        AVOCADO_TOAST = ITEMS.register("avocado_toast", () -> new Item(new Item.Properties().food(ModFoodProperties.AVOCADO_TOAST)));
        BLACKBERRY_JAM = ITEMS.register("blackberry_jam", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.BLACKBERRY_JAM)));
        BLUEBERRY_JAM = ITEMS.register("blueberry_jam", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.BLUEBERRY_JAM)));
        CHERRY_JAM = ITEMS.register("cherry_jam", () -> new DrinkItem(new Item.Properties().food(ModFoodProperties.CHERRY_JAM)));
        SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs", () -> new Item(new Item.Properties().food(ModFoodProperties.SCRAMBLED_EGGS)));
        SUNNY_SIDE_EGGS = ITEMS.register("sunny_side_eggs", () -> new Item(new Item.Properties().food(ModFoodProperties.SUNNY_SIDE_EGGS)));
        COOKED_COW_RIBS = ITEMS.register("cooked_cow_ribs", () -> new Item(new Item.Properties().food(ModFoodProperties.COOKED_COW_RIBS)));
        APPLE_PIE_SLICE = ITEMS.register("apple_pie_slice", () -> new Item(new Item.Properties().food(ModFoodProperties.APPLE_PIE_SLICE)));
        CHERRY_PIE = ITEMS.register("cherry_pie", () -> new Item(new Item.Properties().food(ModFoodProperties.CHERRY_PIE)));
        MOONCAKE = ITEMS.register("mooncake", () -> new Item(new Item.Properties().food(ModFoodProperties.MOONCAKE)));
        STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream", () -> new Item(new Item.Properties().food(ModFoodProperties.STRAWBERRY_ICE_CREAM)));

        ROLLING_PIN = ITEMS.register("rolling_pin", () -> new SwordItem(Tiers.WOOD, new Item.Properties()));
        BREAD_KNIFE = ITEMS.register("bread_knife", () -> new SwordItem(Tiers.IRON, new Item.Properties()));

        STRAWBERRY_CAKE_SLICE = registerBakeryFood("strawberry_cake_slice", 5, 0.7F);
        SWEETBERRY_CAKE_SLICE = registerBakeryFood("sweetberry_cake_slice", 5, 0.7F);
        CHOCOLATE_CAKE_SLICE = registerBakeryFood("chocolate_cake_slice", 5, 0.7F);
        CHOCOLATE_GATEAU_SLICE = registerBakeryFood("chocolate_gateau_slice", 5, 0.7F);
        BUNDT_CAKE_SLICE = registerBakeryFood("bundt_cake_slice", 5, 0.7F);
        LINZER_TART_SLICE = registerBakeryFood("linzer_tart_slice", 5, 0.7F);
        GLOWBERRY_PIE_SLICE = registerBakeryFood("glowberry_pie_slice", 5, 0.7F);
        CHOCOLATE_TART_SLICE = registerBakeryFood("chocolate_tart_slice", 5, 0.7F);
        PUDDING_SLICE = registerBakeryFood("pudding_slice", 5, 0.7F);
        CAKE_DOUGH = registerBakeryFood("cake_dough", 5, 0.6F);
        SWEET_DOUGH = registerBakeryFood("sweet_dough", 5, 0.6F);
        CROISSANT = registerBakeryFood("croissant", 5, 0.6F);
        CRUSTY_BREAD = registerBakeryFood("crusty_bread", 5, 1.2F);
        BREAD = registerBakeryFood("bread", 5, 1.2F);
        BAGUETTE = registerBakeryFood("baguette", 5, 1.2F);
        TOAST = registerBakeryFood("toast", 3, 0.8F);
        BRAIDED_BREAD = registerBakeryFood("braided_bread", 5, 1.2F);
        SANDWICH = registerBakeryFood("sandwich", 7, 0.7F);
        VEGETABLE_SANDWICH = registerBakeryFood("vegetable_sandwich", 8, 0.6F);
        GRILLED_SALMON_SANDWICH = registerBakeryFood("grilled_salmon_sandwich", 6, 0.8F);
        GRILLED_BACON_SANDWICH = registerBakeryFood("grilled_bacon_sandwich", 7, 0.7F);
        BREAD_WITH_JAM = registerBakeryFood("bread_with_jam", 5, 0.5F);
        STRAWBERRY_GLAZED_COOKIE = registerBakeryFood("strawberry_glazed_cookie", 3, 0.5F);
        SWEETBERRY_GLAZED_COOKIE = registerBakeryFood("sweetberry_glazed_cookie", 3, 0.5F);
        CHOCOLATE_GLAZED_COOKIE = registerBakeryFood("chocolate_glazed_cookie", 3, 0.5F);
        STRAWBERRY_CUPCAKE = registerBakeryFood("strawberry_cupcake", 3, 0.5F);
        SWEETBERRY_CUPCAKE = registerBakeryFood("sweetberry_cupcake", 3, 0.5F);
        APPLE_CUPCAKE = registerBakeryFood("apple_cupcake", 3, 0.5F);
        CORNET = registerBakeryFood("cornet", 3, 0.5F);
        JAM_ROLL = registerBakeryFood("jam_roll", 3, 0.5F);
        CHOCOLATE_TRUFFLE = registerBakeryFood("chocolate_truffle", 2, 0.4F);
        MISSLILITU_BISCUIT = registerBakeryFood("misslilitu_biscuit", 6, 0.6F);
        WAFFLE = registerBakeryFood("waffle", 5, 0.5F);
        BUN = registerBakeryFood("bun", 5, 1.2F);

        STRAWBERRY_JAM = ITEMS.register("strawberry_jam", () -> new DrinkItem(
                new Item.Properties().food(new FoodProperties.Builder()
                        .nutrition(3)
                        .saturationModifier(0.4F)
                        .build())
        ));

        registerBlockItem("strawberry_cake", ModBlocks.STRAWBERRY_CAKE);
        registerBlockItem("sweetberry_cake", ModBlocks.SWEETBERRY_CAKE);
        registerBlockItem("chocolate_cake", ModBlocks.CHOCOLATE_CAKE);
        registerBlockItem("bundt_cake", ModBlocks.BUNDT_CAKE);
        registerBlockItem("linzer_tart", ModBlocks.LINZER_TART);
        registerBlockItem("glowberry_tart", ModBlocks.GLOWBERRY_TART);
        registerBlockItem("pudding", ModBlocks.PUDDING);
        registerBlockItem("chocolate_gateau", ModBlocks.CHOCOLATE_GATEAU);
        registerBlockItem("chocolate_tart", ModBlocks.CHOCOLATE_TART);
        registerBlockItem("apple_pie", ModBlocks.APPLE_PIE);
        registerBlockItem("blank_cake", ModBlocks.BLANK_CAKE);
        registerBlockItem("apple_cupcake_block", ModBlocks.APPLE_CUPCAKE_BLOCK);
        registerBlockItem("sweetberry_cupcake_block", ModBlocks.SWEETBERRY_CUPCAKE_BLOCK);
        registerBlockItem("strawberry_cupcake_block", ModBlocks.STRAWBERRY_CUPCAKE_BLOCK);
        registerBlockItem("chocolate_cookie_block", ModBlocks.CHOCOLATE_COOKIE_BLOCK);
        registerBlockItem("sweetberry_cookie_block", ModBlocks.SWEETBERRY_COOKIE_BLOCK);
        registerBlockItem("strawberry_cookie_block", ModBlocks.STRAWBERRY_COOKIE_BLOCK);
        registerBlockItem("crusty_bread_block", ModBlocks.CRUSTY_BREAD_BLOCK);
        registerBlockItem("bread_block", ModBlocks.BREAD_BLOCK);
        registerBlockItem("baguette_block", ModBlocks.BAGUETTE_BLOCK);
        registerBlockItem("toast_block", ModBlocks.TOAST_BLOCK);
        registerBlockItem("braided_bread_block", ModBlocks.BRAIDED_BREAD_BLOCK);
        registerBlockItem("bun_block", ModBlocks.BUN_BLOCK);
        registerBlockItem("waffle_block", ModBlocks.WAFFLE_BLOCK);
        registerBlockItem("jar", ModBlocks.JAR);
        registerBlockItem("glowberry_jam", ModBlocks.GLOWBERRY_JAM);
        registerBlockItem("sweetberry_jam", ModBlocks.SWEETBERRY_JAM);
        registerBlockItem("chocolate_jam", ModBlocks.CHOCOLATE_JAM);
        registerBlockItem("apple_jam", ModBlocks.APPLE_JAM);

        DORIME_SONG = ResourceKey.create(Registries.JUKEBOX_SONG,
                ResourceLocation.fromNamespaceAndPath("whatsits", "dorime"));
        DORIME = ITEMS.register("dorime",
                () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(DORIME_SONG)));

        WORLD_OF_LIES_SONG = ResourceKey.create(Registries.JUKEBOX_SONG,
                ResourceLocation.fromNamespaceAndPath("whatsits", "worldoflies"));
        WORLD_OF_LIES = ITEMS.register("world_of_lies",
                () -> new Item(new Item.Properties().rarity(Rarity.RARE).jukeboxPlayable(WORLD_OF_LIES_SONG)));

        HANDCUFFS = ITEMS.register("handcuffs", () -> new HandcuffsItem(new Item.Properties()));
    }

    private static DeferredItem<Item> registerBlockItem(String name, net.neoforged.neoforge.registries.DeferredBlock<?> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    private static DeferredItem<Item> registerBakeryFood(String name, int nutrition, float saturation) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().food(createBakeryFood(name, nutrition, saturation))));
    }

    private static FoodProperties createBakeryFood(String name, int nutrition, float saturation) {
        FoodProperties.Builder food = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation)
                .alwaysEdible();

        switch (name) {
            case "croissant" -> food.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 0.25F);
            case "chocolate_truffle" -> food.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 0.5F);
            case "misslilitu_biscuit" -> food.effect(() -> new MobEffectInstance(MobEffects.LUCK, 300, 0), 0.5F);
            case "strawberry_cupcake" -> food.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 80, 0), 0.4F);
            case "sweetberry_cupcake" -> food.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 0.4F);
            case "apple_cupcake" -> food.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 0), 0.4F);
            case "chocolate_glazed_cookie" -> food.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 120, 0), 0.35F);
            case "strawberry_glazed_cookie" -> food.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 50, 0), 0.35F);
            case "sweetberry_glazed_cookie" -> food.effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 80, 0), 0.35F);
            case "waffle" -> food.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 1.0F);
            case "grilled_salmon_sandwich" -> food.effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 300, 0), 0.4F);
            case "grilled_bacon_sandwich" -> food.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 120, 0), 0.35F);
            case "vegetable_sandwich" -> food.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 60, 0), 0.3F);
            case "bread_with_jam" -> food.effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 120, 0), 0.3F);
            case "strawberry_cake_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 0.5F);
            case "sweetberry_cake_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 300, 0), 0.5F);
            case "chocolate_cake_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 300, 0), 0.5F);
            case "chocolate_gateau_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 160, 0), 0.35F);
            case "bundt_cake_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.SATURATION, 1, 0), 1.0F);
            case "linzer_tart_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.LUCK, 400, 0), 0.5F);
            case "glowberry_pie_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.GLOWING, 300, 0), 0.75F);
            case "chocolate_tart_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 200, 0), 0.5F);
            case "pudding_slice" -> food.effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 80, 0), 0.5F);
        }

        return food.build();
    }
}
