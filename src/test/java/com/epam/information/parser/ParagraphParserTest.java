package com.epam.information.parser;

import com.epam.information.entity.LexemeType;
import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.entity.impl.Lexeme;
import com.epam.information.parser.impl.ParagraphParser;
import com.epam.information.parser.impl.SentenceParser;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class ParagraphParserTest {
    private static final String VALID_PARAGRAPH = "First sentence. Second sentence!";
    private static final String FIRST_SENTENCE = "First sentence.";
    private static final String SECOND_SENTENCE = "Second sentence!";
    private static final TextComponent FIRST_COMPONENT = Lexeme.word(FIRST_SENTENCE);
    private static final TextComponent SECOND_COMPONENT = Lexeme.word(SECOND_SENTENCE);

    @Test
    public void testParsShouldReturnCorrectComponentWhenParagraphIsValid() {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        Mockito.when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(FIRST_COMPONENT);
        Mockito.when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(SECOND_COMPONENT);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);

        //when
        TextComponent actual = paragraphParser.parse(VALID_PARAGRAPH);

        //then
        TextComponent expected = new TextComposite();
        expected.add(FIRST_COMPONENT);
        expected.add(SECOND_COMPONENT);
        Assert.assertEquals(expected, actual);
    }

}
