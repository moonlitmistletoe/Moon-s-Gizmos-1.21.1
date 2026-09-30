package net.moonlitmistletoe.whatsits.util;

import com.mojang.logging.LogUtils;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

public final class HandcuffManager {

    private static final Logger LOGGER = LogUtils.getLogger();

    private static final Map<UUID, UUID> CUFFED_PLAYERS =
            new HashMap<>();

    private static final String EMOTE_RESOURCE =
            "/emotes/SPE_Hands behind.json";

    private static Object cachedAnimation;
    private static boolean emoteLoadAttempted = false;

    private HandcuffManager() {
    }

    public static boolean isCuffed(ServerPlayer player) {
        return CUFFED_PLAYERS.containsKey(player.getUUID());
    }

    public static boolean isHolder(
            ServerPlayer target,
            ServerPlayer holder
    ) {
        UUID holderUUID = CUFFED_PLAYERS.get(target.getUUID());

        return holderUUID != null
                && holderUUID.equals(holder.getUUID());
    }

    public static void cuff(
            ServerPlayer holder,
            ServerPlayer target
    ) {
        if (holder == target) {
            return;
        }

        if (isCuffed(holder) || isCuffed(target)) {
            return;
        }

        CUFFED_PLAYERS.put(
                target.getUUID(),
                holder.getUUID()
        );

        target.addEffect(
                new MobEffectInstance(
                        MobEffects.MOVEMENT_SLOWDOWN,
                        40,
                        255,
                        false,
                        false,
                        false
                )
        );

        positionTarget(holder, target);

        playCuffEmote(target);

        LOGGER.debug(
                "Cuffed {} to {}",
                target.getGameProfile().getName(),
                holder.getGameProfile().getName()
        );
    }

    public static void uncuff(ServerPlayer target) {
        UUID targetUUID = target.getUUID();

        if (!CUFFED_PLAYERS.containsKey(targetUUID)) {
            return;
        }

        CUFFED_PLAYERS.remove(targetUUID);

        stopCuffEmote(target);

        target.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);

        LOGGER.debug(
                "Uncuffed {}",
                target.getGameProfile().getName()
        );
    }

    @net.neoforged.bus.api.SubscribeEvent
    public static void onServerTick(ServerTickEvent.Post event) {
        if (CUFFED_PLAYERS.isEmpty()) {
            return;
        }

        Iterator<Map.Entry<UUID, UUID>> iterator =
                CUFFED_PLAYERS.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<UUID, UUID> entry = iterator.next();

            ServerPlayer target =
                    event.getServer()
                            .getPlayerList()
                            .getPlayer(entry.getKey());

            ServerPlayer holder =
                    event.getServer()
                            .getPlayerList()
                            .getPlayer(entry.getValue());

            if (target == null || holder == null) {
                if (target != null) {
                    stopCuffEmote(target);
                    target.removeEffect(
                            MobEffects.MOVEMENT_SLOWDOWN
                    );
                }

                iterator.remove();
                continue;
            }

            positionTarget(holder, target);

            target.addEffect(
                    new MobEffectInstance(
                            MobEffects.MOVEMENT_SLOWDOWN,
                            40,
                            255,
                            false,
                            false,
                            false
                    )
            );
        }
    }

    private static void positionTarget(
            ServerPlayer holder,
            ServerPlayer target
    ) {
        double yawRadians =
                Math.toRadians(holder.getYRot());

        double forwardX =
                -Math.sin(yawRadians);

        double forwardZ =
                Math.cos(yawRadians);

        double distance = 0.85D;

        double x =
                holder.getX()
                        + forwardX * distance;

        double y =
                holder.getY();

        double z =
                holder.getZ()
                        + forwardZ * distance;

        target.teleportTo(
                x,
                y,
                z
        );
    }

    private static void playCuffEmote(
            ServerPlayer target
    ) {
        Object animation = getAnimation();

        if (animation == null) {
            return;
        }

        try {
            Class<?> animationClass =
                    Class.forName(
                            "com.zigythebird.playeranimcore.animation.Animation"
                    );

            Class<?> serverApiClass =
                    Class.forName(
                            "io.github.kosmx.emotes.api.events.server.ServerEmoteAPI"
                    );

            Method forcePlayEmote =
                    serverApiClass.getMethod(
                            "forcePlayEmote",
                            UUID.class,
                            animationClass
                    );

            forcePlayEmote.invoke(
                    null,
                    target.getUUID(),
                    animation
            );

        } catch (Throwable throwable) {
            LOGGER.error(
                    "Failed to play the handcuff Emotecraft animation.",
                    throwable
            );
        }
    }

    private static void stopCuffEmote(
            ServerPlayer target
    ) {
        try {
            Class<?> animationClass =
                    Class.forName(
                            "com.zigythebird.playeranimcore.animation.Animation"
                    );

            Class<?> serverApiClass =
                    Class.forName(
                            "io.github.kosmx.emotes.api.events.server.ServerEmoteAPI"
                    );

            Method forcePlayEmote =
                    serverApiClass.getMethod(
                            "forcePlayEmote",
                            UUID.class,
                            animationClass
                    );

            forcePlayEmote.invoke(
                    null,
                    target.getUUID(),
                    new Object[]{null}
            );

        } catch (Throwable throwable) {
            LOGGER.error(
                    "Failed to stop the handcuff Emotecraft animation.",
                    throwable
            );
        }
    }

    private static Object getAnimation() {
        if (emoteLoadAttempted) {
            return cachedAnimation;
        }

        emoteLoadAttempted = true;

        try (InputStream inputStream =
                     HandcuffManager.class.getResourceAsStream(
                             EMOTE_RESOURCE
                     )) {

            if (inputStream == null) {
                LOGGER.error(
                        "Could not find bundled Emotecraft emote: {}",
                        EMOTE_RESOURCE
                );

                return null;
            }

            Class<?> loaderClass =
                    Class.forName(
                            "com.zigythebird.playeranimcore.loading.UniversalAnimLoader"
                    );

            Method loadAnimations =
                    loaderClass.getMethod(
                            "loadAnimations",
                            InputStream.class
                    );

            Object result =
                    loadAnimations.invoke(
                            null,
                            inputStream
                    );

            if (!(result instanceof Map<?, ?> animations)) {
                LOGGER.error(
                        "Emotecraft returned an invalid animation map."
                );

                return null;
            }

            for (Object value : animations.values()) {
                if (value != null) {
                    cachedAnimation = value;
                    return value;
                }
            }

            LOGGER.error(
                    "The bundled handcuff emote did not contain an animation."
            );

        } catch (Throwable throwable) {
            LOGGER.error(
                    "Failed to load bundled handcuff Emotecraft animation.",
                    throwable
            );
        }

        return null;
    }
}