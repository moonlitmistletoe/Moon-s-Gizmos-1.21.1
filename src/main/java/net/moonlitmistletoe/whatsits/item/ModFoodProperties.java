package net.moonlitmistletoe.whatsits.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {

    // Raw ingredients
    public static final FoodProperties EGG_YOLK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.1F)
            .build();

    public static final FoodProperties AVOCADO = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.3F)
            .build();

    public static final FoodProperties BLACKBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties BLUEBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties CHERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();

    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .build();


    // Drinks
    public static final FoodProperties APPLE_JUICE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties CHERRY_JUICE = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties COFFEE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.2F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties STRAWBERRY_SMOOTHIE = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();


    // Prepared foods
    public static final FoodProperties AVOCADO_TOAST = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(0.6F)
            .build();

    public static final FoodProperties BLACKBERRY_JAM = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.4F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties BLUEBERRY_JAM = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.4F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties CHERRY_JAM = new FoodProperties.Builder()
            .nutrition(4)
            .saturationModifier(0.4F)
            .usingConvertsTo(Items.GLASS_BOTTLE)
            .build();

    public static final FoodProperties SCRAMBLED_EGGS = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6F)
            .build();

    public static final FoodProperties SUNNY_SIDE_EGGS = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.6F)
            .build();


    // Desserts
    public static final FoodProperties APPLE_PIE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.8F)
            .build();

    public static final FoodProperties CHERRY_PIE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.8F)
            .build();

    public static final FoodProperties MOONCAKE = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(0.8F)
            .build();

    public static final FoodProperties STRAWBERRY_ICE_CREAM = new FoodProperties.Builder()
            .nutrition(6)
            .saturationModifier(0.5F)
            .build();
}