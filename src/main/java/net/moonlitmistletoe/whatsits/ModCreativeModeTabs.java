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
            "bakery_banner", "cabinet", "drawer", "wall_cabinet",
            "iron_bench", "iron_chair", "iron_table", "street_sign",
            "breadbox", "croissant", "crusty_bread", "bread", "toast",
            "braided_bread", "sandwich", "vegetable_sandwich",
            "grilled_salmon_sandwich", "grilled_bacon_sandwich", "cornet"
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
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
