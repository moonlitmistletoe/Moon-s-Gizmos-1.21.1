package net.moonlitmistletoe.whatsits;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = Whatsits.MOD_ID, dist = Dist.CLIENT)
public class WhatsitsClient {

    public WhatsitsClient(ModContainer container) {
        container.registerExtensionPoint(
                IConfigScreenFactory.class,
                ConfigurationScreen::new
        );
    }
}
