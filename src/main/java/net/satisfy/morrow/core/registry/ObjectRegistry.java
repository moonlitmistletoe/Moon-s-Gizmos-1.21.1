package net.satisfy.morrow.core.registry;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.satisfy.morrow.FarmAndCharm;
import net.satisfy.morrow.core.block.*;
import net.satisfy.morrow.core.block.crops.*;
import net.satisfy.morrow.core.item.*;
import net.satisfy.morrow.core.item.food.*;
import net.satisfy.morrow.core.util.GeneralUtil;
import net.satisfy.morrow.platform.PlatformHelper;

import java.util.function.Consumer;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class ObjectRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(FarmAndCharm.MOD_ID, Registries.ITEM);
    public static final Registrar<Item> ITEM_REGISTRAR = ITEMS.getRegistrar();
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(FarmAndCharm.MOD_ID, Registries.BLOCK);
    public static final Registrar<Block> BLOCK_REGISTRAR = BLOCKS.getRegistrar();

    public static final RegistrySupplier<Item> SUPPLY_CART = registerItem("supply_cart", () -> new SupplyCartItem(getSettings()));
    public static final RegistrySupplier<Item> PLOW = registerItem("plow", () -> new PlowCartItem(getSettings()));
    public static final RegistrySupplier<Item> SEEDER = registerItem("seeder", () -> new SeederCartItem(getSettings()));
    public static final RegistrySupplier<Item> STRAWBERRY_TEA_CUP = registerItem("strawberry_tea_cup", () -> new EffectJugItem(getFoodItemSettings(1, 0.05f, MobEffects.DIG_SPEED, 120, false), 120, true));
    public static final RegistrySupplier<Item> CAT_FOOD = registerItem("cat_food", () -> new CatFoodItem(getSettings()));
    public static final RegistrySupplier<Item> DOG_FOOD = registerItem("dog_food", () -> new DogFoodItem(getSettings()));
    public static final RegistrySupplier<Block> WILD_EMMER = registerWithItem("wild_emmer", () -> new BonemealableFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> WILD_CARROTS = registerWithItem("wild_carrots", () -> new BonemealableFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> WILD_BEETROOTS = registerWithItem("wild_beetroots", () -> new BonemealableFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> WILD_POTATOES = registerWithItem("wild_potatoes", () -> new BonemealableFlowerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION)));
    public static final RegistrySupplier<Block> FEEDING_TROUGH = registerWithItem("feeding_trough", () -> new FeedingTroughBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> WATER_TROUGH = registerWithItem("water_trough", () -> new WaterTroughBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD).randomTicks()));
    public static final RegistrySupplier<Block> WATER_SPRINKLER = registerWithItem("water_sprinkler", () -> new WaterSprinklerBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).noOcclusion()));
    public static final RegistrySupplier<Block> COOKING_POT = registerWithItem("cooking_pot", () -> new CookingPotBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noOcclusion()));
    public static final RegistrySupplier<Block> TOOL_RACK = registerWithItem("tool_rack", () -> new ToolRackBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.FLOWER_POT).noCollission()));
    public static final RegistrySupplier<Block> OAT_PANCAKE_BLOCK = registerWithoutItem("oat_pancake_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 7));
    public static final RegistrySupplier<Block> ROASTED_CORN_BLOCK = registerWithoutItem("roasted_corn_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4));
    public static final RegistrySupplier<Block> POTATO_WITH_ROAST_MEAT = registerWithoutItem("potato_with_roast_meat_block", () -> new FoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(7).saturationModifier(0.7F).build()));
    public static final RegistrySupplier<Block> BAKED_LAMB_HAM = registerWithoutItem("baked_lamb_ham_block", () -> new FoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(8).saturationModifier(0.9F).build()));
    public static final RegistrySupplier<Block> FARMERS_BREAKFAST = registerWithoutItem("farmers_breakfast_block", () -> new FoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(12).saturationModifier(1.2F).build()));
    public static final RegistrySupplier<Block> STUFFED_CHICKEN = registerWithoutItem("stuffed_chicken_block", () -> new FoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(8).saturationModifier(0.8F).build()));
    public static final RegistrySupplier<Block> STUFFED_RABBIT = registerWithoutItem("stuffed_rabbit_block", () -> new FoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(9).saturationModifier(0.9F).build()));
    public static final RegistrySupplier<Block> FARMERS_BREAD = registerWithoutItem("farmers_bread_block", () -> new FoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(6).saturationModifier(0.8F).build()));
    public static final RegistrySupplier<Block> STRAWBERRY_TEA = registerTea("strawberry_tea", () -> new TeaJugBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.GLASS)), MobEffects.DIG_SPEED, 240);
    public static final RegistrySupplier<Item> DUNGAREES = registerItem("dungarees", () -> new DungareesItem(ArmorMaterialRegistry.withTextureNoOverlay(ArmorMaterialRegistry.CLOTH, FarmAndCharm.identifier("models/armor/dungarees")), ArmorItem.Type.LEGGINGS, getSettings().stacksTo(1).rarity(Rarity.EPIC), FarmAndCharm.identifier("models/armor/dungarees")));
    public static final RegistrySupplier<Item> OAT_PANCAKE = registerItem("oat_pancake", () -> new EffectBlockItem(OAT_PANCAKE_BLOCK.get(), getFoodItemSettings(PlatformHelper.getNutrition("oat_pancake"), PlatformHelper.getSaturationMod("oat_pancake"), MobEffectRegistry.SATIATION, 2400)));
    public static final RegistrySupplier<Item> ROASTED_CORN = registerItem("roasted_corn", () -> new EffectBlockItem(ROASTED_CORN_BLOCK.get(), getFoodItemSettings(PlatformHelper.getNutrition("roasted_corn"), PlatformHelper.getSaturationMod("roasted_corn"), MobEffectRegistry.FEAST, 3600)));
    public static final RegistrySupplier<Item> POTATO_WITH_ROAST_MEAT_ITEM = registerItem("potato_with_roast_meat", () -> new EffectBlockItem(POTATO_WITH_ROAST_MEAT.get(), getFoodItemSettings(PlatformHelper.getNutrition("potato_with_roast_meat"), PlatformHelper.getSaturationMod("potato_with_roast_meat"), MobEffectRegistry.SUSTENANCE, 3600)));
    public static final RegistrySupplier<Item> BAKED_LAMB_HAM_ITEM = registerItem("baked_lamb_ham", () -> new EffectBlockItem(BAKED_LAMB_HAM.get(), getFoodItemSettings(PlatformHelper.getNutrition("baked_lamb_ham"), PlatformHelper.getSaturationMod("baked_lamb_ham"), MobEffectRegistry.FEAST, 4800)));
    public static final RegistrySupplier<Item> FARMERS_BREAKFAST_ITEM = registerItem("farmers_breakfast", () -> new EffectBlockItem(FARMERS_BREAKFAST.get(), getFoodItemSettings(PlatformHelper.getNutrition("farmers_breakfast"), PlatformHelper.getSaturationMod("farmers_breakfast"), MobEffectRegistry.FARMERS_BLESSING, 9600)));
    public static final RegistrySupplier<Item> STUFFED_CHICKEN_ITEM = registerItem("stuffed_chicken", () -> new EffectBlockItem(STUFFED_CHICKEN.get(), getFoodItemSettings(PlatformHelper.getNutrition("stuffed_chicken"), PlatformHelper.getSaturationMod("stuffed_chicken"), MobEffectRegistry.FEAST, 9600)));
    public static final RegistrySupplier<Item> STUFFED_RABBIT_ITEM = registerItem("stuffed_rabbit", () -> new EffectBlockItem(STUFFED_RABBIT.get(), getFoodItemSettings(PlatformHelper.getNutrition("stuffed_rabbit"), PlatformHelper.getSaturationMod("stuffed_rabbit"), MobEffectRegistry.FEAST, 9600)));
    public static final RegistrySupplier<Item> FARMERS_BREAD_ITEM = registerItem("farmers_bread", () -> new EffectBlockItem(FARMERS_BREAD.get(), getFoodItemSettings(PlatformHelper.getNutrition("farmers_bread"), PlatformHelper.getSaturationMod("farmers_bread"), MobEffectRegistry.FARMERS_BLESSING, 3600)));
    public static final RegistrySupplier<Item> FARMER_SALAD = registerItem("farmer_salad", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("farmer_salad"), PlatformHelper.getSaturationMod("farmer_salad"), MobEffectRegistry.SATIATION, 4800, true, false), 4800, false));
    public static final RegistrySupplier<Item> GOULASH = registerItem("goulash", () -> new EffectFoodItem(getFoodItemSettings(PlatformHelper.getNutrition("goulash"), PlatformHelper.getSaturationMod("goulash"), (Holder<MobEffect>) null, 0, false), 0));
    public static final RegistrySupplier<Item> SIMPLE_TOMATO_SOUP = registerItem("simple_tomato_soup", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("simple_tomato_soup"), PlatformHelper.getSaturationMod("simple_tomato_soup"), MobEffectRegistry.RESTED, 1800, true, false), 1800, true));
    public static final RegistrySupplier<Item> BARLEY_SOUP = registerItem("barley_soup", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("barley_soup"), PlatformHelper.getSaturationMod("barley_soup"), MobEffectRegistry.RESTED, 3000, true, false), 3000, true));
    public static final RegistrySupplier<Item> ONION_SOUP = registerItem("onion_soup", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("onion_soup"), PlatformHelper.getSaturationMod("onion_soup"), MobEffectRegistry.RESTED, 2400, true, false), 2400, true));
    public static final RegistrySupplier<Item> POTATO_SOUP = registerItem("potato_soup", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("potato_soup"), PlatformHelper.getSaturationMod("potato_soup"), MobEffectRegistry.RESTED, 2400, true, false), 2400, true));
    public static final RegistrySupplier<Item> PASTA_WITH_ONION_SAUCE = registerItem("pasta_with_onion_sauce", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("pasta_with_onion_sauce"), PlatformHelper.getSaturationMod("pasta_with_onion_sauce"), MobEffectRegistry.SATIATION, 3600, true, false), 3600, false));
    public static final RegistrySupplier<Item> CORN_GRITS = registerItem("corn_grits", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("corn_grits"), PlatformHelper.getSaturationMod("corn_grits"), MobEffectRegistry.SATIATION, 2400, true, false), 2400, true));
    public static final RegistrySupplier<Item> OATMEAL_WITH_STRAWBERRIES = registerItem("oatmeal_with_strawberries", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("oatmeal_with_strawberries"), PlatformHelper.getSaturationMod("oatmeal_with_strawberries"), MobEffectRegistry.FARMERS_BLESSING, 900, true, false), 6000, false));
    public static final RegistrySupplier<Item> SAUSAGE_WITH_OAT_PATTY = registerItem("sausage_with_oat_patty", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("sausage_with_oat_patty"), PlatformHelper.getSaturationMod("sausage_with_oat_patty"), MobEffectRegistry.SUSTENANCE, 2400, true, false), 2400, true));
    public static final RegistrySupplier<Item> LAMB_WITH_CORN = registerItem("lamb_with_corn", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("lamb_with_corn"), PlatformHelper.getSaturationMod("lamb_with_corn"), MobEffectRegistry.SATIATION, 3600, true, false), 3600, true));
    public static final RegistrySupplier<Item> BEEF_PATTY_WITH_VEGETABLES = registerItem("beef_patty_with_vegetables", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("beef_patty_with_vegetables"), PlatformHelper.getSaturationMod("beef_patty_with_vegetables"), MobEffectRegistry.SUSTENANCE, 4800, true, false), 6000, true));
    public static final RegistrySupplier<Item> BACON_WITH_EGGS = registerItem("bacon_with_eggs", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("bacon_with_eggs"), PlatformHelper.getSaturationMod("bacon_with_eggs"), MobEffectRegistry.SUSTENANCE, 3600, true, false), 3600, true));
    public static final RegistrySupplier<Item> COOKED_SALMON = registerItem("cooked_salmon", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("cooked_salmon"), PlatformHelper.getSaturationMod("cooked_salmon"), MobEffectRegistry.SATIATION, 4800, true, false), 4800, true));
    public static final RegistrySupplier<Item> COOKED_COD = registerItem("cooked_cod", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("cooked_cod"), PlatformHelper.getSaturationMod("cooked_cod"), MobEffectRegistry.SUSTENANCE, 4800, true, false), 4800, true));
    public static final RegistrySupplier<Item> ROASTED_CHICKEN = registerItem("roasted_chicken", () -> new EffectItem(getFoodItemSettings(PlatformHelper.getNutrition("roasted_chicken"), PlatformHelper.getSaturationMod("roasted_chicken"), MobEffectRegistry.SATIATION, 4800, false, false), 4800, false));

    public static void init() {
        ITEMS.register();
        BLOCKS.register();
    }

    public static BlockBehaviour.Properties properties(float strength) {
        return properties(strength, strength);
    }

    public static BlockBehaviour.Properties properties(float breakSpeed, float explosionResist) {
        return BlockBehaviour.Properties.of().strength(breakSpeed, explosionResist);
    }

    private static Item.Properties getSettings(Consumer<Item.Properties> consumer) {
        Item.Properties settings = new Item.Properties();
        consumer.accept(settings);
        return settings;
    }

    static Item.Properties getSettings() {
        return getSettings(settings -> {});
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, Holder<MobEffect> effect, int duration) {
        return new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturationMod)
                .effect(new MobEffectInstance(effect, duration), 1.0f)
                .build());
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, ResourceLocation effectId, int duration) {
        return new Item.Properties().food(new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturationMod)
                .effect(MobEffectRegistry.inst(effectId, duration), 1.0f)
                .build());
    }

    private static RegistrySupplier<Block> registerBlockWithItem(String blockName, String itemName, Supplier<Block> blockSupplier) {
        RegistrySupplier<Block> block = registerWithoutItem(blockName, blockSupplier);
        registerItem(itemName, () -> new EffectBlockItem(block.get(), getFoodItemSettings(7, 0.7f, MobEffectRegistry.SUSTENANCE, 3600)));
        return block;
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, Holder<MobEffect> effect, int duration, boolean fast) {
        return getSettings().food(createFood(nutrition, saturationMod, effect, duration, true, fast));
    }

    private static Item.Properties getFoodItemSettings(int nutrition, float saturationMod, ResourceLocation effectId, int duration, boolean alwaysEat, boolean fast) {
        return getSettings().food(createFood(nutrition, saturationMod, effectId, duration, alwaysEat, fast));
    }

    private static FoodProperties createFood(int nutrition, float saturationMod, Holder<MobEffect> effect, int duration, boolean alwaysEat, boolean fast) {
        FoodProperties.Builder food = new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturationMod);
        if (alwaysEat) food.alwaysEdible();
        if (fast) food.fast();
        if (effect != null) food.effect(new MobEffectInstance(effect, duration), 1.0f);
        return food.build();
    }

    private static FoodProperties createFood(int nutrition, float saturationMod, ResourceLocation effectId, int duration, boolean alwaysEat, boolean fast) {
        FoodProperties.Builder food = new FoodProperties.Builder().nutrition(nutrition).saturationModifier(saturationMod);
        if (alwaysEat) food.alwaysEdible();
        if (fast) food.fast();
        if (effectId != null) food.effect(MobEffectRegistry.inst(effectId, duration), 1.0f);
        return food.build();
    }

    private static FoodProperties teaFoodComponent(Holder<MobEffect> effect, int duration) {
        FoodProperties.Builder component = new FoodProperties.Builder().nutrition(1).saturationModifier(1).alwaysEdible();
        if (effect != null) component.effect(new MobEffectInstance(effect, duration), 1.0f);
        return component.build();
    }

    private static RegistrySupplier<Block> registerTea(String name, Supplier<Block> blockSupplier, Holder<MobEffect> effect, int duration) {
        RegistrySupplier<Block> toReturn = registerWithoutItem(name, blockSupplier);
        registerItem(name, () -> new TeaJugItem(toReturn.get(), getSettings().food(teaFoodComponent(effect, duration)).craftRemainder(Items.GLASS_BOTTLE)));
        return toReturn;
    }

    public static <T extends Block> RegistrySupplier<T> registerWithItem(String name, Supplier<T> block) {
        return GeneralUtil.registerWithItem(BLOCKS, BLOCK_REGISTRAR, ITEMS, ITEM_REGISTRAR, FarmAndCharm.identifier(name), block);
    }

    public static <T extends Block> RegistrySupplier<T> registerWithoutItem(String path, Supplier<T> block) {
        return GeneralUtil.registerWithoutItem(BLOCKS, BLOCK_REGISTRAR, FarmAndCharm.identifier(path), block);
    }

    public static <T extends Item> RegistrySupplier<T> registerItem(String path, Supplier<T> itemSupplier) {
        return GeneralUtil.registerItem(ITEMS, ITEM_REGISTRAR, FarmAndCharm.identifier(path), itemSupplier);
    }
}