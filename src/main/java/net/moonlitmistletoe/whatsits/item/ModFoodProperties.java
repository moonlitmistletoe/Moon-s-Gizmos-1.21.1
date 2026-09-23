package net.moonlitmistletoe.whatsits.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties EGG_YOLK = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .saturationModifier(0.1F)
            .build();
}
