package net.moonlitmistletoe.whatsits.item;

import net.minecraft.world.item.Item;
import net.moonlitmistletoe.whatsits.Whatsits;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(Whatsits.MOD_ID);

    public static final DeferredItem<Item> EGG_YOLK = ITEMS.register("egg_yolk",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.EGG_YOLK)));

    public static final DeferredItem<Item> APPLE_JUICE = ITEMS.register("apple_juice",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.APPLE_JUICE)));

    public static final DeferredItem<Item> APPLE_PIE = ITEMS.register("apple_pie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.APPLE_PIE)));

    public static final DeferredItem<Item> AVOCADO = ITEMS.register("avocado",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.AVOCADO)));

    public static final DeferredItem<Item> AVOCADO_TOAST = ITEMS.register("avocado_toast",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.AVOCADO_TOAST)));

    public static final DeferredItem<Item> BLACKBERRY = ITEMS.register("blackberry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLACKBERRY)));

    public static final DeferredItem<Item> BLACKBERRY_JAM = ITEMS.register("blackberry_jam",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLACKBERRY_JAM)));

    public static final DeferredItem<Item> BLUEBERRY = ITEMS.register("blueberry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLUEBERRY)));

    public static final DeferredItem<Item> BLUEBERRY_JAM = ITEMS.register("blueberry_jam",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.BLUEBERRY_JAM)));

    public static final DeferredItem<Item> CHERRY = ITEMS.register("cherry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHERRY)));

    public static final DeferredItem<Item> CHERRY_JAM = ITEMS.register("cherry_jam",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHERRY_JAM)));

    public static final DeferredItem<Item> CHERRY_JUICE = ITEMS.register("cherry_juice",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHERRY_JUICE)));

    public static final DeferredItem<Item> CHERRY_PIE = ITEMS.register("cherry_pie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.CHERRY_PIE)));

    public static final DeferredItem<Item> COFFEE = ITEMS.register("coffee",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.COFFEE)));

    public static final DeferredItem<Item> MOONCAKE = ITEMS.register("mooncake",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.MOONCAKE)));

    public static final DeferredItem<Item> SCRAMBLED_EGGS = ITEMS.register("scrambled_eggs",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.SCRAMBLED_EGGS)));

    public static final DeferredItem<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY)));

    public static final DeferredItem<Item> STRAWBERRY_ICE_CREAM = ITEMS.register("strawberry_ice_cream",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY_ICE_CREAM)));

    public static final DeferredItem<Item> STRAWBERRY_JAM = ITEMS.register("strawberry_jam",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY_JAM)));

    public static final DeferredItem<Item> STRAWBERRY_SMOOTHIE = ITEMS.register("strawberry_smoothie",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.STRAWBERRY_SMOOTHIE)));

    public static final DeferredItem<Item> SUNNY_SIDE_EGGS = ITEMS.register("sunny_side_eggs",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.SUNNY_SIDE_EGGS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}