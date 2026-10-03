package net.moonlitmistletoe.whatsits.scabbard.component;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.moonlitmistletoe.whatsits.Whatsits;

public class ModDataComponents {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES =
            DeferredRegister.createDataComponents(Whatsits.MOD_ID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<StoredItem>> STORED_ITEM =
            DATA_COMPONENT_TYPES.register("stored_item", () -> DataComponentType.<StoredItem>builder()
                    .persistent(StoredItem.CODEC)
                    .networkSynchronized(StoredItem.STREAM_CODEC)
                    .build());

    public static void register(IEventBus eventBus) {
        DATA_COMPONENT_TYPES.register(eventBus);
    }
}
