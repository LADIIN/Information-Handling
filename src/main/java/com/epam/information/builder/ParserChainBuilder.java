package com.epam.information.builder;

import com.epam.information.parser.Parser;
import com.epam.information.parser.impl.SentenceParser;
import com.epam.information.parser.impl.ParagraphParser;
import com.epam.information.parser.impl.TextParser;

public class ParserChainBuilder {

    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser(null)));
    }
}
