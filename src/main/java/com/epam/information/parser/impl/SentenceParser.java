package com.epam.information.parser.impl;

import com.epam.information.parser.Parser;
import com.epam.information.entity.LeafType;
import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.entity.impl.TextLeaf;
import com.epam.information.parser.AbstractParser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {
    private static final String LEAF_REGEX = "\\[[^]\\[]*]|[^ \\[\\]]+\\n?";
    private static final String EXPRESSION_REGEX = "\\[[^]\\[]*]";

    public SentenceParser(Parser successor) {
        super(successor);
    }

    @Override
    public TextComponent parse(String text) {
        TextComposite composite = new TextComposite();

        Pattern pattern = Pattern.compile(LEAF_REGEX);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String value = matcher.group();
            TextLeaf leaf;

            if (value.matches(EXPRESSION_REGEX)) {
                leaf = new TextLeaf(value, LeafType.EXPRESSION);
            } else {
                leaf = new TextLeaf(value, LeafType.WORD);
            }
            composite.add(leaf);
        }
        return composite;
    }

}