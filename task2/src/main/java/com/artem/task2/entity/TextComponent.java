package com.artem.task2.entity;

import java.util.List;

public interface TextComponent {
    void add(TextComponent child);

    List<TextComponent> getChildren();

    TextComponentType getType();
}