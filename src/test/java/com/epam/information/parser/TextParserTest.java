package com.epam.information.parser;

import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.entity.impl.Lexeme;
import com.epam.information.parser.impl.ParagraphParser;
import com.epam.information.parser.impl.TextParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class TextParserTest {
    private static final String VALID_TEXT = "First paragraph! Still first.\nSecond Paragraph.";
    private static final String FIRST_PARAGRAPH = "First paragraph! Still first.";
    private static final String SECOND_PARAGRAPH = "Second Paragraph.";
    private static final TextComponent FIRST_COMPONENT = Lexeme.word(FIRST_PARAGRAPH);
    private static final TextComponent SECOND_COMPONENT = Lexeme.word(SECOND_PARAGRAPH);

    @Test
    public void testParseShouldReturnCorrectComponentWhenTextIsValid() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(FIRST_COMPONENT);
        Mockito.when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(SECOND_COMPONENT);
        TextParser textParser = new TextParser(paragraphParser);

        //when
        TextComponent actual = textParser.parse(VALID_TEXT);

        //then
        TextComponent expected = new TextComposite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);

        Assert.assertEquals(expected, actual);
    }
}
