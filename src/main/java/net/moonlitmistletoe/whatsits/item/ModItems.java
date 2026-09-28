package net.moonlitmistletoe.whatsits.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.JukeboxSong;
import net.minecraft.world.item.Rarity;
import net.moonlitmistletoe.whatsits.Whatsits;
import net.moonlitmistletoe.whatsits.block.ModBlocks;
import net.moonlitmistletoe.whatsits.item.custom.DrinkItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Whatsits.MOD_ID);

    // Logo
    public static final DeferredItem<Item> MOD_LOGO = ITEMS.register("mod_logo",
            () -> new Item(new Item.Properties()));

    // Seeds
    public static final DeferredItem<Item> BLACKBERRY_SEED = ITEMS.register("blackberry_seed",
            () -> new ItemNameBlockItem(ModBlocks.BLACKBERRY_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> BLUEBERRY_SEED = ITEMS.register("blueberry_seed",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> COFFEE_SEED = ITEMS.register("coffee_seed",
            () -> new ItemNameBlockItem(ModBlocks.COFFEE_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> STRAWBERRY_SEED = ITEMS.register("strawberry_seed",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));


    // Raw ingredients
    public static final DeferredItem<Item> EGG_YOLK = ITEMS.register("egg_yolk",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.EGG_YOLK)));

    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.AVOCADO)));

    public static final DeferredItem<Item> BLACKBERRY = ITEMS.register("blackberry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLACKBERRY)));

    public static final DeferredItem<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLUEBERRY)));

    public static final DeferredItem<Item> CHERRY = ITEMS.register("cherry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHERRY)));

    public static final DeferredItem<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY)));


    // Drinks
    public static final DeferredItem<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.APPLE_JUICE)));

    public static final DeferredItem<Item> CHERRY_JUICE = ITEMS.register("cherry_juice",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.CHERRY_JUICE)));

    public static final DeferredItem<Item> COFFEE = ITEMS.register("coffee",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.COFFEE)));

    public static final DeferredItem<Item> STRAWBERRY_SMOOTHIE = ITEMS.register("strawberry_smoothie",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY_SMOOTHIE)));


    // Prepared foods
    public static final DeferredItem<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.AVOCADO_TOAST)));

    public static final DeferredItem<Item> BLACKBERRY_JAM = ITEMS.register("blackberry_jam",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.BLACKBERRY_JAM)));

    public static final DeferredItem<Item> BLUEBERRY_JAM = ITEMS.register("blueberry_jam",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.BLUEBERRY_JAM)));

    public static final DeferredItem<Item> CHERRY_JAM = ITEMS.register("cherry_jam",
            () -> new DrinkItem(new Item.Properties()
                    .food(ModFoodProperties.CHERRY_JAM)));

    public static final DeferredItem<Item> SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.SCRAMBLED_EGGS)));

    public static final DeferredItem<Item> SUNNY_SIDE_EGGS = ITEMS.register("sunny_side_eggs",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.SUNNY_SIDE_EGGS)));


    // Desserts
    public static final DeferredItem<Item> APPLE_PIE = ITEMS.register("apple_pie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.APPLE_PIE)));

    public static final DeferredItem<Item> CHERRY_PIE = ITEMS.register("cherry_pie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHERRY_PIE)));

    public static final DeferredItem<Item> MOONCAKE = ITEMS.register("mooncake",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.MOONCAKE)));

    public static final DeferredItem<Item> STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY_ICE_CREAM)));


    // Music Discs
    public static final ResourceKey<JukeboxSong> DORIME_SONG =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    ResourceLocation.fromNamespaceAndPath(Whatsits.MOD_ID, "dorime")
            );

    public static final DeferredItem<Item> DORIME = ITEMS.register("dorime",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(DORIME_SONG)));

    public static final ResourceKey<JukeboxSong> WORLD_OF_LIES_SONG =
            ResourceKey.create(
                    Registries.JUKEBOX_SONG,
                    ResourceLocation.fromNamespaceAndPath(Whatsits.MOD_ID, "worldoflies")
            );

    public static final DeferredItem<Item> WORLD_OF_LIES = ITEMS.register("world_of_lies",
            () -> new Item(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .jukeboxPlayable(WORLD_OF_LIES_SONG)));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}