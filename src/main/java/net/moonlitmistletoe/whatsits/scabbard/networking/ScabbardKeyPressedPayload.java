package net.moonlitmistletoe.whatsits.scabbard.networking;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.moonlitmistletoe.whatsits.Whatsits;
import net.moonlitmistletoe.whatsits.scabbard.item.ModScabbardItems;
import net.moonlitmistletoe.whatsits.scabbard.item.ScabbardItem;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import top.theillusivec4.curios.api.CuriosApi;

public record ScabbardKeyPressedPayload() implements CustomPacketPayload {
    public static final Type<ScabbardKeyPressedPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(Whatsits.MOD_ID, "scabbard_key"));

    public static final StreamCodec<RegistryFriendlyByteBuf, ScabbardKeyPressedPayload> STREAM_CODEC =
            StreamCodec.of((buf, pkt) -> {}, buf -> new ScabbardKeyPressedPayload());

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(ScabbardKeyPressedPayload payload, IPayloadContext context) {
        context.enqueueWork(() -> {
            if (!(context.player() instanceof ServerPlayer player)) return;

            CuriosApi.getCuriosInventory(player).ifPresent(curios -> {
                Item[] items = {
                        ModScabbardItems.SCABBARD.get(),
                        ModScabbardItems.WEAPON_HOLSTER.get(),
                        ModScabbardItems.HIP_SCABBARD.get()
                };

                for (Item item : items) {
                    curios.findFirstCurio(item).ifPresent(slot -> {
                        ItemStack stack = slot.stack();
                        if (stack.getItem() instanceof ScabbardItem scabbard) {
                            scabbard.drawOrSheathSword(player, stack);
                        }
                    });
                }
            });
        });
    }
}
