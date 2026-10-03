package net.moonlitmistletoe.whatsits;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.moonlitmistletoe.whatsits.item.ModItems;
import net.moonlitmistletoe.whatsits.scabbard.item.ModScabbardItems;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Whatsits.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WHATSITS_TAB =
            CREATIVE_MODE_TABS.register("whatsits", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.whatsits.whatsits"))

                    // The mod logo is the actual creative-tab icon
                    .icon(() -> new ItemStack(ModItems.MOD_LOGO.get()))

                    .displayItems((parameters, output) -> {

                        // =========================
                        // Whatsits seeds
                        // =========================

                        output.accept(ModItems.BLACKBERRY_SEED);
                        output.accept(ModItems.BLUEBERRY_SEED);
                        output.accept(ModItems.COFFEE_SEED);
                        output.accept(ModItems.STRAWBERRY_SEED);

                        // =========================
                        // Whatsits food
                        // =========================

                        output.accept(ModItems.EGG_YOLK);
                        output.accept(ModItems.AVOCADO);
                        output.accept(ModItems.BLACKBERRY);
                        output.accept(ModItems.BLUEBERRY);
                        output.accept(ModItems.CHERRY);
                        output.accept(ModItems.COFFEE_BEANS);
                        output.accept(ModItems.STRAWBERRY);
                        output.accept(ModItems.RAW_COW_RIBS);
                        output.accept(ModItems.HANDCUFFS);

                        // =========================
                        // Scabbards
                        // =========================

                        output.accept(ModScabbardItems.SCABBARD);
                        output.accept(ModScabbardItems.HIP_SCABBARD);
                        output.accept(ModScabbardItems.WEAPON_HOLSTER);

                        // =========================
                        // Drinks
                        // =========================

                        output.accept(ModItems.APPLE_JUICE);
                        output.accept(ModItems.CHERRY_JUICE);
                        output.accept(ModItems.COFFEE);
                        output.accept(ModItems.STRAWBERRY_SMOOTHIE);

                        // =========================
                        // Prepared food
                        // =========================

                        output.accept(ModItems.AVOCADO_TOAST);
                        output.accept(ModItems.BLACKBERRY_JAM);
                        output.accept(ModItems.BLUEBERRY_JAM);
                        output.accept(ModItems.CHERRY_JAM);
                        output.accept(ModItems.SCRAMBLED_EGGS);
                        output.accept(ModItems.SUNNY_SIDE_EGGS);
                        output.accept(ModItems.COOKED_COW_RIBS);

                        // =========================
                        // Pies / desserts
                        // =========================

                        output.accept(ModItems.APPLE_PIE_SLICE);
                        output.accept(ModItems.CHERRY_PIE);
                        output.accept(ModItems.MOONCAKE);
                        output.accept(ModItems.STRAWBERRY_ICE_CREAM);

                        // =========================
                        // Music
                        // =========================

                        output.accept(ModItems.DORIME);
                        output.accept(ModItems.WORLD_OF_LIES);

                        // =========================
                        // Bakery tools
                        // =========================

                        output.accept(
                                ModItems.ROLLING_PIN.get()
                        );

                        output.accept(
                                ModItems.BREAD_KNIFE.get()
                        );

                        // =========================
                        // Bakery food
                        // =========================

                        output.accept(
                                ModItems.CAKE_DOUGH.get()
                        );

                        output.accept(
                                ModItems.SWEET_DOUGH.get()
                        );

                        output.accept(
                                ModItems.CROISSANT.get()
                        );

                        output.accept(
                                ModItems.SANDWICH.get()
                        );

                        output.accept(
                                ModItems.VEGETABLE_SANDWICH.get()
                        );

                        output.accept(
                                ModItems.GRILLED_SALMON_SANDWICH.get()
                        );

                        output.accept(
                                ModItems.GRILLED_BACON_SANDWICH.get()
                        );

                        output.accept(
                                ModItems.BREAD_WITH_JAM.get()
                        );

                        // =========================
                        // Bakery cake slices
                        // =========================

                        output.accept(
                                ModItems.STRAWBERRY_CAKE_SLICE.get()
                        );

                        output.accept(
                                ModItems.SWEETBERRY_CAKE_SLICE.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_CAKE_SLICE.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_GATEAU_SLICE.get()
                        );

                        output.accept(
                                ModItems.BUNDT_CAKE_SLICE.get()
                        );

                        output.accept(
                                ModItems.LINZER_TART_SLICE.get()
                        );

                        output.accept(
                                ModItems.GLOWBERRY_PIE_SLICE.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_TART_SLICE.get()
                        );

                        output.accept(
                                ModItems.PUDDING_SLICE.get()
                        );

                        // =========================
                        // Bakery pastries
                        // =========================

                        output.accept(
                                ModItems.CORNET.get()
                        );

                        output.accept(
                                ModItems.JAM_ROLL.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_TRUFFLE.get()
                        );

                        output.accept(
                                ModItems.MISSLILITU_BISCUIT.get()
                        );

                        // =========================
                        // Bakery cakes
                        // =========================

                        output.accept(
                                ModItems.STRAWBERRY_CAKE.get()
                        );

                        output.accept(
                                ModItems.SWEETBERRY_CAKE.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_CAKE.get()
                        );

                        output.accept(
                                ModItems.BUNDT_CAKE.get()
                        );

                        output.accept(
                                ModItems.LINZER_TART.get()
                        );

                        output.accept(
                                ModItems.APPLE_PIE.get()
                        );

                        output.accept(
                                ModItems.GLOWBERRY_TART.get()
                        );

                        output.accept(
                                ModItems.PUDDING.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_GATEAU.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_TART.get()
                        );

                        // =========================
                        // Bakery jams
                        // =========================

                        output.accept(
                                ModItems.STRAWBERRY_JAM.get()
                        );

                        output.accept(
                                ModItems.GLOWBERRY_JAM.get()
                        );

                        output.accept(
                                ModItems.SWEETBERRY_JAM.get()
                        );

                        output.accept(
                                ModItems.CHOCOLATE_JAM.get()
                        );

                        output.accept(
                                ModItems.APPLE_JAM.get()
                        );
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}