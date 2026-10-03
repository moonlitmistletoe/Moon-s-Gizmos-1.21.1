package net.moonlitmistletoe.whatsits.scabbard.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.moonlitmistletoe.whatsits.scabbard.networking.ScabbardKeyPressedPayload;
import org.lwjgl.glfw.GLFW;

public class ScabbardClient {
    public static final String CATEGORY = "key.categories.whatsits";
    public static final KeyMapping SCABBARD_KEY = new KeyMapping(
            "key.whatsits.scabbard_key",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            CATEGORY
    );

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ScabbardClient::registerKeyMappings);
    }

    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(SCABBARD_KEY);
    }

    public static void registerGameEvents() {
        net.neoforged.neoforge.common.NeoForge.EVENT_BUS.addListener(ScabbardClient::onClientTick);
    }

    public static void onClientTick(ClientTickEvent.Post event) {
        while (SCABBARD_KEY.consumeClick()) {
            if (Minecraft.getInstance().player != null) {
                PacketDistributor.sendToServer(new ScabbardKeyPressedPayload());
            }
        }
    }
}
