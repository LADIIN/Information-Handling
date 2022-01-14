package com.epam.information.parser;

import com.epam.information.entity.TextComponent;

public interface Parser {
    TextComponent parse(String text);
}
