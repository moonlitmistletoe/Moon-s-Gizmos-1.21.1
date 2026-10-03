package net.moonlitmistletoe.whatsits.client;

import net.satisfy.morrow.client.FarmAndCharmClient;

public final class MorrowClient {
    private MorrowClient() {
    }

    public static void register() {
        FarmAndCharmClient.preInitClient();
        FarmAndCharmClient.onInitializeClient();
    }

    public static void registerCreativeTabEvents(net.neoforged.bus.api.IEventBus modEventBus) {
    }
}
