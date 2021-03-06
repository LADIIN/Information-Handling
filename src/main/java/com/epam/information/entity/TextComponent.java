package com.epam.information.entity;

import java.util.List;

public interface TextComponent {
    List<TextComponent> getComponents();

    void add(TextComponent textComponent);

    void remove(TextComponent textComponent);

    int size();
}
