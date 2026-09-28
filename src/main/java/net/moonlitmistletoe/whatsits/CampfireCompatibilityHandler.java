package net.moonlitmistletoe.whatsits.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CampfireCookingRecipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.moonlitmistletoe.whatsits.Whatsits;

import java.util.Optional;

public class CampfireCompatibilityHandler {

    private static final ResourceLocation SUNNY_SIDE_EGGS_RECIPE =
            ResourceLocation.fromNamespaceAndPath(
                    Whatsits.MOD_ID,
                    "sunny_side_eggs"
            );

    private static final RecipeManager.CachedCheck<SingleRecipeInput, CampfireCookingRecipe> CAMPFIRE_CHECK =
            RecipeManager.createCheck(RecipeType.CAMPFIRE_COOKING);

    @SubscribeEvent
    public static void preventSunnySideEggsOnCampfire(PlayerInteractEvent.RightClickBlock event) {

        if (event.getLevel().isClientSide()) {
            return;
        }

        if (!event.getLevel().getBlockState(event.getPos()).is(Blocks.CAMPFIRE)
                && !event.getLevel().getBlockState(event.getPos()).is(Blocks.SOUL_CAMPFIRE)) {
            return;
        }

        if (!event.getItemStack().is(Items.EGG)) {
            return;
        }

        Optional<net.minecraft.world.item.crafting.RecipeHolder<CampfireCookingRecipe>> recipe =
                CAMPFIRE_CHECK.getRecipeFor(
                        new SingleRecipeInput(event.getItemStack()),
                        event.getLevel()
                );

        if (recipe.isPresent() && recipe.get().id().equals(SUNNY_SIDE_EGGS_RECIPE)) {
            event.setCancellationResult(InteractionResult.FAIL);
            event.setCanceled(true);
        }
    }
}