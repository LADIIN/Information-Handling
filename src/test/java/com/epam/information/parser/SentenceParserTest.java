package com.epam.information.parser;

import com.epam.information.entity.LeafType;
import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.entity.impl.TextLeaf;
import com.epam.information.parser.impl.SentenceParser;
import org.junit.Assert;
import org.junit.Test;

public class SentenceParserTest {
    private static final String VALID_SENTENCE = "[10 x /] word!";
    private static final String Expression = "[10 x /]";
    private static final String WORD = "word!";
    private static final TextComponent FIRST_COMPONENT = new TextLeaf(Expression, LeafType.EXPRESSION);
    private static final TextComponent SECOND_COMPONENT = new TextLeaf(WORD, LeafType.WORD);

    @Test
    public void testParseShouldReturnCorrectComponentWhenSentenceIsValid() {
        //given
        SentenceParser sentenceParser = new SentenceParser(null);

        //when
        TextComponent actual = sentenceParser.parse(VALID_SENTENCE);

        //then
        TextComponent expected = new TextComposite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);
        Assert.assertEquals(expected, actual);
    }


}
