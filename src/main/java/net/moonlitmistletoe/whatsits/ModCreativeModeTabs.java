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

                        // Seeds
                        output.accept(ModItems.BLACKBERRY_SEED);
                        output.accept(ModItems.BLUEBERRY_SEED);
                        output.accept(ModItems.COFFEE_SEED);
                        output.accept(ModItems.STRAWBERRY_SEED);

                        // Raw ingredients
                        output.accept(ModItems.EGG_YOLK);
                        output.accept(ModItems.AVOCADO);
                        output.accept(ModItems.BLACKBERRY);
                        output.accept(ModItems.BLUEBERRY);
                        output.accept(ModItems.CHERRY);
                        output.accept(ModItems.COFFEE_BEANS);
                        output.accept(ModItems.STRAWBERRY);
                        output.accept(ModItems.RAW_COW_RIBS);

                        // Scabbards
                        output.accept(net.nimbu.scabbards.item.ModItems.SCABBARD);
                        output.accept(net.nimbu.scabbards.item.ModItems.HIP_SCABBARD);
                        output.accept(net.nimbu.scabbards.item.ModItems.WEAPON_HOlSTER);

                        // Drinks
                        output.accept(ModItems.APPLE_JUICE);
                        output.accept(ModItems.CHERRY_JUICE);
                        output.accept(ModItems.COFFEE);
                        output.accept(ModItems.STRAWBERRY_SMOOTHIE);

                        // Prepared foods
                        output.accept(ModItems.AVOCADO_TOAST);
                        output.accept(ModItems.BLACKBERRY_JAM);
                        output.accept(ModItems.BLUEBERRY_JAM);
                        output.accept(ModItems.CHERRY_JAM);
                        output.accept(ModItems.SCRAMBLED_EGGS);
                        output.accept(ModItems.SUNNY_SIDE_EGGS);
                        output.accept(ModItems.COOKED_COW_RIBS);

                        // Desserts
                        output.accept(ModItems.APPLE_PIE_SLICE);
                        output.accept(ModItems.CHERRY_PIE);
                        output.accept(ModItems.MOONCAKE);
                        output.accept(ModItems.STRAWBERRY_ICE_CREAM);

                        // Music Discs
                        output.accept(ModItems.DORIME);
                        output.accept(ModItems.WORLD_OF_LIES);
                        // Bakery - self-contained content
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.CABINET.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.DRAWER.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.WALL_CABINET.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.IRON_TABLE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.ROLLING_PIN.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BREAD_KNIFE.get());
                        output.accept(net.satisfy.bakery.core.registry.ObjectRegistry.BAKERY_BANNER.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}