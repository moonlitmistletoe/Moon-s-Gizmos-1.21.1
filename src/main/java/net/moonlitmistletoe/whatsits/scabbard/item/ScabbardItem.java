package net.moonlitmistletoe.whatsits.scabbard.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.BundleTooltip;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.Level;
import net.moonlitmistletoe.whatsits.scabbard.component.ModDataComponents;
import net.moonlitmistletoe.whatsits.scabbard.component.StoredItem;
import net.moonlitmistletoe.whatsits.scabbard.config.ScabbardItemCache;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import java.util.List;
import java.util.Optional;

public class ScabbardItem extends Item implements ICurioItem {
    private final Class<? extends Item> itemType;

    public ScabbardItem(Properties properties, Class<? extends Item> itemType) {
        super(properties);
        this.itemType = itemType;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        super.inventoryTick(stack, level, entity, slotId, isSelected);
        StoredItem storedItem = stack.get(ModDataComponents.STORED_ITEM);
        if (storedItem == null) return;

        ItemStack stored = storedItem.stack().copy();
        stored.getItem().inventoryTick(stored, level, entity, slotId, isSelected);
        stack.set(ModDataComponents.STORED_ITEM, new StoredItem(stored));
    }

    public static boolean matches(ItemStack stack, Class<? extends Item> type) {
        if (stack == null || stack.isEmpty() || type == null) return false;

        boolean defaultItem = type.isInstance(stack.getItem());
        if (type == SwordItem.class) {
            return defaultItem || ScabbardItemCache.isScabbardExtra(stack.getItem());
        }
        return defaultItem || ScabbardItemCache.isWeaponHolsterExtra(stack.getItem());
    }

    public void drawOrSheathSword(ServerPlayer player, ItemStack scabbardItem) {
        Inventory inventory = player.getInventory();
        int selectedSlot = inventory.selected;
        ItemStack heldItem = inventory.getItem(selectedSlot).copy();

        StoredItem storedItem = scabbardItem.get(ModDataComponents.STORED_ITEM);

        if (storedItem != null) {
            inventory.setItem(selectedSlot, storedItem.stack());
            inventory.add(heldItem);
            player.drop(heldItem, false);
            scabbardItem.remove(ModDataComponents.STORED_ITEM);

            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BUNDLE_REMOVE_ONE, player.getSoundSource(), 1.0F, 1.0F);
        } else if (matches(heldItem, itemType)) {
            scabbardItem.set(ModDataComponents.STORED_ITEM, new StoredItem(heldItem.copy()));
            inventory.setItem(selectedSlot, ItemStack.EMPTY);

            player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.BUNDLE_INSERT, player.getSoundSource(), 1.0F, 1.0F);
        }
    }

    @Override
    public boolean overrideStackedOnOther(ItemStack stack, Slot slot, ClickAction action, Player player) {
        if (stack.getCount() != 1 || action != ClickAction.SECONDARY) return false;

        StoredItem storedItem = stack.get(ModDataComponents.STORED_ITEM);
        ItemStack target = slot.getItem();

        if (storedItem == null) {
            if (!matches(target, itemType)) return false;

            ItemStack taken = slot.safeTake(1, 1, player);
            if (!taken.isEmpty()) {
                stack.set(ModDataComponents.STORED_ITEM, new StoredItem(taken.copy()));
                playInsertSound(player);
            }
            return true;
        }

        ItemStack storedStack = storedItem.stack();
        if (storedStack.isEmpty() || !target.isEmpty()) return false;

        ItemStack remainder = slot.safeInsert(storedStack.copy());
        if (remainder.isEmpty()) stack.remove(ModDataComponents.STORED_ITEM);
        else stack.set(ModDataComponents.STORED_ITEM, new StoredItem(remainder.copy()));

        playRemoveSound(player);
        return true;
    }

    @Override
    public boolean overrideOtherStackedOnMe(ItemStack stack, ItemStack other, Slot slot,
                                            ClickAction action, Player player, SlotAccess access) {
        if (!matches(other, itemType) || other.getCount() != 1
                || action != ClickAction.SECONDARY
                || stack.get(ModDataComponents.STORED_ITEM) != null) return false;

        stack.set(ModDataComponents.STORED_ITEM, new StoredItem(other.copy()));
        access.set(ItemStack.EMPTY);
        playInsertSound(player);
        return true;
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
        return !stack.has(DataComponents.HIDE_TOOLTIP)
                && !stack.has(DataComponents.HIDE_ADDITIONAL_TOOLTIP)
                ? Optional.ofNullable((BundleContents) stack.get(DataComponents.BUNDLE_CONTENTS)).map(BundleTooltip::new)
                : Optional.empty();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents,
                                TooltipFlag tooltipFlag) {
        StoredItem storedItem = stack.get(ModDataComponents.STORED_ITEM);
        if (storedItem != null) {
            List<Component> storedTooltip = storedItem.stack().getTooltipLines(context, null, tooltipFlag);
            tooltipComponents.add(Component.empty());
            tooltipComponents.add(Component.translatable("tooltip.whatsits.stored_sword").withStyle(ChatFormatting.GOLD));
            for (Component component : storedTooltip) {
                tooltipComponents.add(Component.literal("  ").append(component));
            }
        }
    }

    private void playRemoveSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_REMOVE_ONE, 0.8F,
                0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void playInsertSound(Entity entity) {
        entity.playSound(SoundEvents.BUNDLE_INSERT, 0.8F,
                0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }
}
