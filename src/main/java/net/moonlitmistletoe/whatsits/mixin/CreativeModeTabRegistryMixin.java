package net.moonlitmistletoe.whatsits.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.common.CreativeModeTabRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(CreativeModeTabRegistry.class)
public class CreativeModeTabRegistryMixin {

    @Inject(
            method = "getSortedCreativeModeTabs",
            at = @At("RETURN"),
            cancellable = true,
            remap = false
    )
    private static void removeUnwantedTabs(CallbackInfoReturnable<List<CreativeModeTab>> cir) {
        List<CreativeModeTab> tabs = new ArrayList<>(cir.getReturnValue());

        tabs.removeIf(tab -> {
            ResourceLocation id = CreativeModeTabRegistry.getName(tab);

            if (id == null) {
                return false;
            }

            // Farm & Charm is still a runtime dependency, so remove its own tab
            // while keeping all of its items available through Morrow's tab.
            if (id.getNamespace().equals("morrow")) {
                return true;
            }

            // Safety net for any old Bakery tab that may still be registered under
            // Morrow's namespace.
            return id.getNamespace().equals("morrow") && id.getPath().equals("bakery");
        });

        cir.setReturnValue(tabs);
    }
}
