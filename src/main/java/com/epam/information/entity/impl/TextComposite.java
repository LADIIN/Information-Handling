package com.epam.information.entity.impl;

import com.epam.information.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private final List<TextComponent> components = new ArrayList<>();

    @Override
    public List<TextComponent> getComponents() {
        return components;
    }

    @Override
    public void add(TextComponent textComponent) {
        components.add(textComponent);
    }

    @Override
    public void remove(TextComponent textComponent) {
        components.remove(textComponent);
    }

   
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextComposite that = (TextComposite) o;

        return components.equals(that.components);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        return prime + (components.isEmpty() ? 0 : components.hashCode());
    }

    @Override
    public String toString() {
        return String.format("Components: %s", components);
    }
}
