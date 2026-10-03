package net.satisfy.morrow.core.network.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.satisfy.morrow.core.network.packet.SyncSaturationPacket;
import net.satisfy.morrow.core.util.SaturationTracker;

public class SyncSaturationPacketClientHandler {
    public static void handle(SyncSaturationPacket packet) {
        Level level = Minecraft.getInstance().level;
        if (level == null) return;
        

        Entity entity = level.getEntity(packet.entityId());
        if (entity instanceof SaturationTracker.SaturatedAnimal saturated) {
            saturated.morrow$getSaturationTracker().clientSync(packet.level(), packet.foodCounter());
        }
    }
}