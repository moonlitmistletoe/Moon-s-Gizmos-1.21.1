package net.moonlitmistletoe.whatsits.scabbard.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.moonlitmistletoe.whatsits.Whatsits;
import net.moonlitmistletoe.whatsits.scabbard.networking.ScabbardKeyPressedPayload;
import org.lwjgl.glfw.GLFW;

@EventBusSubscriber(modid = Whatsits.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = net.neoforged.api.distmarker.Dist.CLIENT)
public class ScabbardClient {
    public static final String CATEGORY = "key.categories.whatsits";
    public static final KeyMapping SCABBARD_KEY = new KeyMapping(
            "key.whatsits.scabbard_key",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            CATEGORY
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(SCABBARD_KEY);
    }

    @EventBusSubscriber(modid = Whatsits.MOD_ID, bus = EventBusSubscriber.Bus.GAME, value = net.neoforged.api.distmarker.Dist.CLIENT)
    public static class ClientGameEvents {
        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            while (SCABBARD_KEY.consumeClick()) {
                if (Minecraft.getInstance().player != null) {
                    PacketDistributor.sendToServer(new ScabbardKeyPressedPayload());
                }
            }
        }
    }
}
