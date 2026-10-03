package net.moonlitmistletoe.whatsits.scabbard.config;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.HashSet;
import java.util.Set;

public class ScabbardItemCache {

    private static final Set<Item> SCABBARD_EXTRAS = new HashSet<>();
    private static final Set<Item> WEAPON_HOLSTER_EXTRAS = new HashSet<>();

    private static final Set<String> SCABBARD_EXTRA_IDS = Set.of(
            "endermanoverhaul:corrupted_blade",

            "farmersdelight:diamond_knife",
            "farmersdelight:flint_knife",
            "farmersdelight:golden_knife",
            "farmersdelight:iron_knife",
            "farmersdelight:netherrite_knife",

            "moredelight:stone_knife",
            "moredelight:wooden_knife",

            "block_factorys_bosses:large_sword",
            "block_factorys_bosses:warrior_sword",
            "block_factorys_bosses:dagger",
            "block_factorys_bosses:knight_sword",
            "block_factorys_bosses:pirate_saber",

            "born_in_chaos_v1:soul_cutlass",
            "born_in_chaos_v1:frostbitten_blade",
            "born_in_chaos_v1:dark_ritual_dagger",
            "born_in_chaos_v1:spiritual_sword",
            "born_in_chaos_v1:sharpened_dark_metal_sword",
            "born_in_chaos_v1:spider_bite_sword",
            "born_in_chaos_v1:intoxicating_dagger",
            "born_in_chaos_v1:soulbane",
            "born_in_chaos_v1:sweet_sword",
            "born_in_chaos_v1:carrot_sword",

            "dungeonsdelight:flint_cleaver",
            "dungeonsdelight:diamond_cleaver",
            "dungeonsdelight:golden_cleaver",
            "dungeonsdelight:iron_cleaver",
            "dungeonsdelight:netherrite_cleaver",
            "dungeonsdelight:stained_cleaver",

            "alexscaves:desolate_dagger",

            "eternalnether:cutlass"
    );

    private static final Set<String> WEAPON_HOLSTER_EXTRA_IDS = Set.of(
            "supplementaries:wrench",
            "create:wrench",

            "block_factorys_bosses:kraken_trident",

            "luminousworld:ironhammer",
            "luminousworld:goldhammer",
            "luminousworld:diamond_hammer",
            "luminousworld:netherrite_hammer",

            "born_in_chaos_v1:staff_of_magic_arrows",
            "born_in_chaos_v1:shell_mace",
            "born_in_chaos_v1:pumpkinstaffa",
            "born_in_chaos_v1:sweet_axe",
            "born_in_chaos_v1:trident_hayfork",
            "born_in_chaos_v1:wood_splitter_axe",
            "born_in_chaos_v1:birch_branches",
            "born_in_chaos_v1:icy_sweetness",

            "alexscaves:primitive_club",

            "farmersdelight:skillet"
    );

    public static void reload() {
        SCABBARD_EXTRAS.clear();
        WEAPON_HOLSTER_EXTRAS.clear();

        for (String id : ScabbardConfig.SCABBARD_EXTRAS.get()) {
            addToSet(id, SCABBARD_EXTRAS);
        }

        for (String id : ScabbardConfig.WEAPON_HOLSTER_EXTRAS.get()) {
            addToSet(id, WEAPON_HOLSTER_EXTRAS);
        }

        for (String id : SCABBARD_EXTRA_IDS) {
            addToSet(id, SCABBARD_EXTRAS);
        }

        for (String id : WEAPON_HOLSTER_EXTRA_IDS) {
            addToSet(id, WEAPON_HOLSTER_EXTRAS);
        }

        // Advanced Netherite compatibility
        for (Item item : BuiltInRegistries.ITEM) {
            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);

            if (id == null || !id.getNamespace().equals("advancednetherite")) {
                continue;
            }

            String path = id.getPath();

            if (!isAdvancedNetheriteTool(path)) {
                continue;
            }

            if (isScabbardSizedWeapon(path)) {
                SCABBARD_EXTRAS.add(item);
            } else {
                WEAPON_HOLSTER_EXTRAS.add(item);
            }
        }

        // Exclusive Weapons compatibility
        for (Item item : BuiltInRegistries.ITEM) {
            ResourceLocation id = BuiltInRegistries.ITEM.getKey(item);

            if (id == null || !id.getNamespace().equals("exclusive_weapons")) {
                continue;
            }

            String path = id.getPath();

            if (!path.startsWith("super") || !path.contains("_")) {
                continue;
            }

            WEAPON_HOLSTER_EXTRAS.add(item);

            if (isScabbardSizedWeapon(path)) {
                SCABBARD_EXTRAS.add(item);
            }
        }
    }

    private static void addToSet(String id, Set<Item> targetSet) {
        Item item = BuiltInRegistries.ITEM.get(ResourceLocation.parse(id));

        if (item != Items.AIR) {
            targetSet.add(item);
        }
    }

    private static boolean isAdvancedNetheriteTool(String path) {
        return path.matches(
                "^(netherite|super)_.+_(sword|axe|pickaxe|shovel|hoe)$"
        );
    }

    private static boolean isScabbardSizedWeapon(String path) {
        return path.endsWith("_sword")
                || path.endsWith("_dagger")
                || path.endsWith("_blade")
                || path.endsWith("_cutlass")
                || path.endsWith("_saber")
                || path.endsWith("_cleaver")
                || path.endsWith("_trident");
    }

    public static boolean isScabbardExtra(Item item) {
        return SCABBARD_EXTRAS.contains(item);
    }

    public static boolean isWeaponHolsterExtra(Item item) {
        return WEAPON_HOLSTER_EXTRAS.contains(item);
    }
}
