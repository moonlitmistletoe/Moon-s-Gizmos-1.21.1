package net.moonlitmistletoe.whatsits;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.moonlitmistletoe.whatsits.item.ModItems;

import java.util.Set;

public class ModCreativeModeTabs {

    private static final Set<String> REMOVED_MORROW_ITEMS = Set.of(
            "cabinet", "drawer", "wall_cabinet",
            "iron_bench", "iron_chair", "iron_table", "street_sign",
            "breadbox", "croissant", "crusty_bread", "bread", "toast",
            "braided_bread", "sandwich", "vegetable_sandwich",
            "grilled_salmon_sandwich", "grilled_bacon_sandwich", "cornet"
    );

    private static final Set<String> REMOVED_FARM_AND_CHARM_ITEMS = Set.of(
            "fertilizer", "pitchfork", "yeast", "butter", "dough", "raw_pasta",
            "flour", "minced_beef", "lamb_ham", "bacon", "chicken_parts",
            "corn", "barley", "oat", "strawberry", "lettuce", "tomato",
            "rotten_tomato", "compost", "nettle_tea_cup", "ribwort_tea_cup",
            "chicken_feed", "horse_feeder", "tomato_seeds", "lettuce_seeds",
            "strawberry_seeds", "oat_seeds", "barley_seeds", "corn_kernels",
            "onion", "wild_ribwort", "wild_nettle", "wild_corn", "wild_barley",
            "wild_oat", "wild_tomatoes", "wild_lettuce", "wild_onions",
            "wild_strawberries", "lettuce_bag", "tomato_bag", "corn_bag",
            "onion_bag", "flour_bag", "oat_bale", "barley_bale",
            "fertilized_soil", "fertilized_farmland", "wooden_silo",
            "copper_silo", "stove", "mincer", "crafting_bowl", "cooking_pot",
            "roaster", "window_sill", "scarecrow", "nettle_tea", "ribwort_tea",
            "chicken_nest", "chicken_coop", "oat_pancake", "roasted_corn",
            "potato_with_roast_meat", "baked_lamb_ham", "farmers_breakfast",
            "stuffed_chicken", "stuffed_rabbit", "grandmas_strawberry_cake",
            "farmers_bread", "farmer_salad", "goulash", "simple_tomato_soup",
            "barley_soup", "onion_soup", "potato_soup", "pasta_with_onion_sauce",
            "corn_grits", "oatmeal_with_strawberries", "sausage_with_oat_patty",
            "lamb_with_corn", "beef_patty_with_vegetables", "barley_patty_with_potatoes",
            "bacon_with_eggs", "chicken_wrapped_in_bacon_with_noodles",
            "cooked_salmon", "cooked_cod", "roasted_chicken", "rope",
            "packed_dirt", "trampled_packed_dirt", "stable_floor",
            "trampled_stable_floor", "straw_stable_floor", "cattlegrid"
    );

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.CREATIVE_MODE_TAB, Whatsits.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WHATSITS_TAB =
            CREATIVE_MODE_TABS.register("morrow", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.morrow.morrow"))
                    .icon(() -> new ItemStack(ModItems.MOD_LOGO.get()))
                    .displayItems((parameters, output) -> {
                        Set<net.minecraft.world.item.Item> added =
                                java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());

                        for (net.minecraft.world.item.Item item : BuiltInRegistries.ITEM) {
                            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);

                            if (!id.getNamespace().equals(Whatsits.MOD_ID)
                                    || id.getPath().equals("mod_logo")
                                    || REMOVED_MORROW_ITEMS.contains(id.getPath())) {
                                continue;
                            }

                            if (added.add(item)) {
                                output.accept(item);
                            }
                        }

                        for (net.minecraft.world.item.Item item : BuiltInRegistries.ITEM) {
                            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);

                            if (!id.getNamespace().equals("farm_and_charm")
                                    || REMOVED_FARM_AND_CHARM_ITEMS.contains(id.getPath())) {
                                continue;
                            }

                            if (added.add(item)) {
                                output.accept(item);
                            }
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
