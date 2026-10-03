package net.moonlitmistletoe.whatsits.scabbard.networking;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

public class ModScabbardNetworking {
    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ModScabbardNetworking::registerPayloads);
    }

    private static void registerPayloads(RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar("1");
        registrar.playToServer(
                ScabbardKeyPressedPayload.TYPE,
                ScabbardKeyPressedPayload.STREAM_CODEC,
                ScabbardKeyPressedPayload::handle
        );
    }
}
