package com.epam.information.comparator;

import com.epam.information.entity.TextComponent;

import java.util.Comparator;

public class ComponentSizeComparator implements Comparator<TextComponent> {

    @Override
    public int compare(TextComponent firstComponent, TextComponent secondComponent) {
        return firstComponent.size() - secondComponent.size();
    }
}
