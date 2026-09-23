package net.moonlitmistletoe.whatsits.item;

import net.minecraft.world.item.Item;
import net.moonlitmistletoe.whatsits.Whatsits;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Whatsits.MOD_ID);

    public static final DeferredItem<Item> EGG_YOLK = ITEMS.register("egg_yolk",
            () -> new Item(new Item.Properties().food(ModFoodProperties.EGG_YOLK)));



    public static <voice> voice register(IEventBus eventBus) {
        ITEMS.register(eventBus) ;
        return null;
    }
}
