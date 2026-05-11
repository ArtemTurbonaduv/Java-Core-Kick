package com.artem.task2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    protected List<TextComponent> components = new ArrayList<>();
    protected TextComponentType type;

    public TextComposite(TextComponentType type) {
        this.type = type;
    }

    @Override
    public void add(TextComponent child) {
        components.add(child);
    }

    @Override
    public List<TextComponent> getChildren() {
        return components;
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        String delimiter = type.getDelimiter();
        String[] stringComponents = components.stream()
                .map(TextComponent::toString)
                .toArray(String[]::new);

        return String.join(delimiter, stringComponents);
    }
}
