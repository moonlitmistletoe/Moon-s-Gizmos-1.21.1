package net.moonlitmistletoe.whatsits.scabbard.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TieredItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.moonlitmistletoe.whatsits.Whatsits;

public class ModScabbardItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Whatsits.MOD_ID);

    public static final DeferredItem<Item> SCABBARD = ITEMS.register("scabbard",
            () -> new ScabbardItem(new Item.Properties().stacksTo(1), SwordItem.class));
    public static final DeferredItem<Item> HIP_SCABBARD = ITEMS.register("hip_scabbard",
            () -> new ScabbardItem(new Item.Properties().stacksTo(1), SwordItem.class));
    public static final DeferredItem<Item> WEAPON_HOLSTER = ITEMS.register("weapon_holster",
            () -> new ScabbardItem(new Item.Properties().stacksTo(1), TieredItem.class));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
