package net.satisfy.morrow.client.gui;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.satisfy.morrow.core.block.entity.PetBowlBlockEntity;
import net.satisfy.morrow.core.network.PacketHandler;
import net.satisfy.morrow.core.network.packet.SetTextPacket;

import java.util.List;

public class PetBowlEditGui extends Screen {
    private final PetBowlBlockEntity entity;
    private EditBox textField;

    public PetBowlEditGui(PetBowlBlockEntity entity) {
        super(Component.translatable("gui.morrow.pet_bowl.edit"));
        this.entity = entity;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int centerY = this.height / 2;

        textField = new EditBox(this.font, centerX - 100, centerY - 10, 200, 20, Component.literal(""));
        textField.setMaxLength(6);
        textField.setValue(entity.getText().getString());
        this.addRenderableWidget(textField);
        this.setInitialFocus(textField);

        this.addRenderableWidget(Button.builder(Component.translatable("gui.morrow.text_edit.done"), button -> this.onClose())
                .bounds(centerX - 50, centerY + 20, 100, 20)
                .build());
    }

    @Override
    public void onClose() {
        PacketHandler.sendToServer(new SetTextPacket(entity.getBlockPos(), List.of(textField.getValue())));
        super.onClose();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        //this.renderBackground(graphics, mouseX, mouseY, partialTick);
        super.render(graphics, mouseX, mouseY, partialTick);
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 16777215);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (keyCode == 256 || keyCode == 257 || keyCode == 335) {
            this.onClose();
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }
}