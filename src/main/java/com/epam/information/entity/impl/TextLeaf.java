package com.epam.information.entity.impl;

import com.epam.information.entity.LeafType;
import com.epam.information.entity.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class TextLeaf implements TextComponent {
    private final String value;
    private final LeafType type;

    public TextLeaf(String value, LeafType type) {
        this.value = value;
        this.type = type;
    }

    @Override
    public List<TextComponent> getComponents() {
//        throw new UnsupportedOperationException("Can't use operation on leaf.");
        return new ArrayList<>();
    }

    @Override
    public void add(TextComponent textComponent) {
        throw new UnsupportedOperationException("Can't use operation on leaf.");
    }

    @Override
    public void remove(TextComponent textComponent) {
        throw new UnsupportedOperationException("Can't use operation on leaf.");
    }

    public LeafType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TextLeaf textLeaf = (TextLeaf) o;
        return value.equals(textLeaf.value) && type == textLeaf.type;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = type != null ? type.hashCode() : 0;
        result = prime * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return value;
    }
}
