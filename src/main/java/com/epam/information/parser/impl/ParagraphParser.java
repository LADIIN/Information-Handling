package com.epam.information.parser.impl;

import com.epam.information.parser.Parser;
import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.parser.AbstractParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    private static final String SENTENCE_REGEX = "(\\p{Upper}|[A-Za-z]).+?([.!?…])(\\s|$)";
    private static final Logger LOGGER = LogManager.getLogger(ParagraphParser.class);

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public TextComponent parse(String paragraph) {
        TextComposite composite = new TextComposite();

        Pattern pattern = Pattern.compile(SENTENCE_REGEX);
        Matcher matcher = pattern.matcher(paragraph);

        while (matcher.find()) {
            String part = matcher.group().trim();
            TextComponent sentence = getSuccessor().parse(part);
            composite.add(sentence);
        }

        return composite;
    }
}
