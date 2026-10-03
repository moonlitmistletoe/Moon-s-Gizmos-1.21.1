package net.moonlitmistletoe.whatsits;
import net.moonlitmistletoe.whatsits.bakery.core.registry.ObjectRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.moonlitmistletoe.whatsits.item.ModItems;
import net.moonlitmistletoe.whatsits.block.ModBlocks;
import net.moonlitmistletoe.whatsits.scabbard.item.ModScabbardItems;

public class ModCreativeModeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Whatsits.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WHATSITS_TAB =
            CREATIVE_MODE_TABS.register("morrow", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.whatsits.whatsits"))

                    // The mod logo is the actual creative-tab icon
                    .icon(() -> new ItemStack(ModItems.MOD_LOGO.get()))

                    .displayItems((parameters, output) -> {
                        java.util.Set<net.minecraft.world.item.Item> added =
                                java.util.Collections.newSetFromMap(new java.util.IdentityHashMap<>());

                        // All of Morrow's own items, including the merged Bakery items.
                        for (net.minecraft.world.item.Item item : net.minecraft.core.registries.BuiltInRegistries.ITEM) {
                            net.minecraft.resources.ResourceLocation id =
                                    net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(item);

                            if (id.getNamespace().equals(Whatsits.MOD_ID) && id.getPath().equals("mod_logo") == false && added.add(item)) {
                                output.accept(item);
                            }
                        }

                        // Farm & Charm items are supplied by the dependency, so add every
                        // registered item from its namespace to the Morrow tab as well.
                        for (net.minecraft.world.item.Item item : net.minecraft.core.registries.BuiltInRegistries.ITEM) {
                            net.minecraft.resources.ResourceLocation id =
                                    net.minecraft.core.registries.BuiltInRegistries.ITEM.getKey(item);

                            if (id.getNamespace().equals("farm_and_charm") && added.add(item)) {
                                output.accept(item);
                            }
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}