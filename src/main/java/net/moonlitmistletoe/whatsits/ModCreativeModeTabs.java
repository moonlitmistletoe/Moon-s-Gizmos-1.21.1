package net.moonlitmistletoe.whatsits;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.moonlitmistletoe.whatsits.item.ModItems;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Whatsits.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WHATSITS_TAB =
            CREATIVE_MODE_TABS.register("whatsits", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.whatsits.whatsits"))
                    .withTabsImage(ResourceLocation.fromNamespaceAndPath(
                            Whatsits.MOD_ID,
                            "logo.png"
                    ))
                    .icon(() -> new ItemStack(ModItems.MOD_LOGO.get()))
                    .displayItems((parameters, output) -> {

                        // Existing Whatsits content
                        output.accept(ModItems.BLACKBERRY_SEED);
                        output.accept(ModItems.BLUEBERRY_SEED);
                        output.accept(ModItems.COFFEE_SEED);
                        output.accept(ModItems.STRAWBERRY_SEED);

                        output.accept(ModItems.EGG_YOLK);
                        output.accept(ModItems.AVOCADO);
                        output.accept(ModItems.BLACKBERRY);
                        output.accept(ModItems.BLUEBERRY);
                        output.accept(ModItems.CHERRY);
                        output.accept(ModItems.COFFEE_BEANS);
                        output.accept(ModItems.STRAWBERRY);
                        output.accept(ModItems.RAW_COW_RIBS);

                        output.accept(net.nimbu.scabbards.item.ModItems.SCABBARD);
                        output.accept(net.nimbu.scabbards.item.ModItems.HIP_SCABBARD);
                        output.accept(net.nimbu.scabbards.item.ModItems.WEAPON_HOlSTER);

                        output.accept(ModItems.APPLE_JUICE);
                        output.accept(ModItems.CHERRY_JUICE);
                        output.accept(ModItems.COFFEE);
                        output.accept(ModItems.STRAWBERRY_SMOOTHIE);

                        output.accept(ModItems.AVOCADO_TOAST);
                        output.accept(ModItems.BLACKBERRY_JAM);
                        output.accept(ModItems.BLUEBERRY_JAM);
                        output.accept(ModItems.CHERRY_JAM);
                        output.accept(ModItems.SCRAMBLED_EGGS);
                        output.accept(ModItems.SUNNY_SIDE_EGGS);
                        output.accept(ModItems.COOKED_COW_RIBS);

                        output.accept(ModItems.APPLE_PIE_SLICE);
                        output.accept(ModItems.CHERRY_PIE);
                        output.accept(ModItems.MOONCAKE);
                        output.accept(ModItems.STRAWBERRY_ICE_CREAM);

                        output.accept(ModItems.DORIME);
                        output.accept(ModItems.WORLD_OF_LIES);

                        // Bakery tools
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.ROLLING_PIN.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BREAD_KNIFE.get());

                        // Bakery food
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CAKE_DOUGH.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEET_DOUGH.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CROISSANT.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CRUSTY_BREAD.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BREAD.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BAGUETTE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.TOAST.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BRAIDED_BREAD.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SANDWICH.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.VEGETABLE_SANDWICH.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.GRILLED_SALMON_SANDWICH.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.GRILLED_BACON_SANDWICH.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BREAD_WITH_JAM.get());

                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_CAKE_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_CAKE_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_CAKE_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_GATEAU_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BUNDT_CAKE_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.LINZER_TART_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.GLOWBERRY_PIE_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_TART_SLICE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.PUDDING_SLICE.get());

                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_GLAZED_COOKIE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_GLAZED_COOKIE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_GLAZED_COOKIE.get());

                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_CUPCAKE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_CUPCAKE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.APPLE_CUPCAKE.get());

                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CORNET.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.JAM_ROLL.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_TRUFFLE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.MISSLILITU_BISCUIT.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.WAFFLE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BUN.get());

                        // Bakery cakes, pies and tarts
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_CAKE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_CAKE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_CAKE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BUNDT_CAKE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.LINZER_TART.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.APPLE_PIE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.GLOWBERRY_TART.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.PUDDING.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_GATEAU.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_TART.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BLANK_CAKE.get());

                        // Bakery food blocks
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_CUPCAKE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_CUPCAKE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.APPLE_CUPCAKE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_COOKIE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_COOKIE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_COOKIE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CRUSTY_BREAD_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BREAD_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BAGUETTE_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.TOAST_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BRAIDED_BREAD_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BUN_BLOCK.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.WAFFLE_BLOCK.get());

                        // Bakery jars and jams
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.JAR.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.STRAWBERRY_JAM.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.GLOWBERRY_JAM.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.SWEETBERRY_JAM.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CHOCOLATE_JAM.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.APPLE_JAM.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
