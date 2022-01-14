package com.epam.information.parser.impl;

import com.epam.information.parser.Parser;
import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.parser.AbstractParser;

public class TextParser extends AbstractParser {
    private static final String DELIMITER = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite composite = new TextComposite();
        String[] parts = text.split(DELIMITER);

        for (String part : parts) {
            TextComponent paragraph = getSuccessor().parse(part);
            composite.add(paragraph);
        }

        return composite;
    }
}
