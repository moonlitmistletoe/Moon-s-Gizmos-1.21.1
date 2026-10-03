package net.satisfy.morrow.core.block.entity;

import net.minecraft.network.chat.Component;

public interface TextEditableBlockEntity {
    void setText(int line, Component text);
    int getTextLineCount();
}