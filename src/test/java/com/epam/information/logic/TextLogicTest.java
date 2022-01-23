package com.epam.information.logic;

import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.Lexeme;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.exception.InformationHandlingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TextLogicTest {
    private static final TextLogic textLogic = new TextLogic();
    private static final Lexeme FIRST_LEXEME = Lexeme.word("File");
    private static final Lexeme SECOND_LEXEME = Lexeme.expression("[2 x *]");
    private static final Lexeme THIRD_LEXEME = Lexeme.word("Megabytes.");
    private static final Lexeme CALCULATED_EXPRESSION = Lexeme.word("4.0");

    @Test
    public void testRestoreShouldReturnCorrectTextWhenCompositeIsValid() {
        //given
        String expected = "File [2 x *] Megabytes.";
        TextComposite composite = createTextComposite();
        //when
        String actual = textLogic.restore(composite);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateExpressionsShouldCalculateCorrectlyWhenCompositeIsValid() throws InformationHandlingException {
        //given
        Map<String, Double> parameters = new HashMap<>();
        parameters.put("x", 2.0);
        parameters.put("y", 3.0);
        TextComposite composite = createTextComposite();
        //when
        TextComponent actual = textLogic.calculateExpressions(composite, parameters);
        //then
        TextComponent expected = createExpectedTextCompositeToCalculateExpressionsTest();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortLexemesInSentencesShouldSortByLengthWhenCompositeIsValid() {
        //given
        TextComposite composite = createUnsortedTextComposite();
        //when
        TextComposite actual = textLogic.sortWordsInSentencesByLength(composite);
        //then
        TextComposite expected = createSortedTextCompositeToSortLexemesTest();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortParagraphsShouldSortByAmountOfSentencesWhenCompositeIsValid() {
        //given
        TextComposite composite = createUnsortedTextCompositeToSortParagraphsTest();
        //when
        TextComposite actual = textLogic.sortParagraphsBySentenceAmount(composite);
        //then
        TextComposite expected = createSortedTextCompositeToSortParagraphsTest();
        Assert.assertEquals(expected, actual);
    }

    private TextComposite createTextComposite() {
        List<Lexeme> lexemes = Arrays.asList(FIRST_LEXEME, SECOND_LEXEME, THIRD_LEXEME);
        TextComposite sentence = new TextComposite(lexemes);
        TextComposite paragraph = new TextComposite();
        paragraph.add(sentence);
        TextComposite text = new TextComposite();
        text.add(paragraph);
        return text;
    }

    private TextComposite createExpectedTextCompositeToCalculateExpressionsTest() {
        List<Lexeme> lexemes = Arrays.asList(FIRST_LEXEME, CALCULATED_EXPRESSION, THIRD_LEXEME);
        TextComposite sentence = new TextComposite(lexemes);
        TextComposite paragraph = new TextComposite();
        paragraph.add(sentence);
        TextComposite text = new TextComposite();
        text.add(paragraph);
        return text;
    }

    private TextComposite createUnsortedTextComposite() {
        List<Lexeme> lexemes = Arrays.asList(Lexeme.word("Longest"), Lexeme.word("short"), Lexeme.word("longer"));
        TextComposite sentence = new TextComposite(lexemes);
        TextComposite paragraph = new TextComposite();
        paragraph.add(sentence);
        TextComposite text = new TextComposite();
        text.add(paragraph);
        return text;
    }

    private TextComposite createSortedTextCompositeToSortLexemesTest() {
        List<Lexeme> lexemes = Arrays.asList(Lexeme.word("short"), Lexeme.word("longer"), Lexeme.word("Longest"));
        TextComposite sentence = new TextComposite(lexemes);
        TextComposite paragraph = new TextComposite();
        paragraph.add(sentence);
        TextComposite text = new TextComposite();
        text.add(paragraph);
        return text;
    }

    private TextComposite createUnsortedTextCompositeToSortParagraphsTest() {
        List<Lexeme> lexemes = Arrays.asList(FIRST_LEXEME, SECOND_LEXEME, THIRD_LEXEME);
        TextComposite sentence = new TextComposite(lexemes);
        TextComposite firstParagraph = new TextComposite();
        firstParagraph.add(sentence);
        firstParagraph.add(sentence);
        TextComposite secondParagraph = new TextComposite();
        secondParagraph.add(sentence);
        TextComposite text = new TextComposite();
        text.add(firstParagraph);
        text.add(secondParagraph);
        return text;
    }

    private TextComposite createSortedTextCompositeToSortParagraphsTest() {
        List<Lexeme> lexemes = Arrays.asList(FIRST_LEXEME, SECOND_LEXEME, THIRD_LEXEME);
        TextComposite sentence = new TextComposite(lexemes);
        TextComposite firstParagraph = new TextComposite();
        firstParagraph.add(sentence);
        firstParagraph.add(sentence);
        TextComposite secondParagraph = new TextComposite();
        secondParagraph.add(sentence);
        TextComposite text = new TextComposite();
        text.add(secondParagraph);
        text.add(firstParagraph);
        return text;
    }
}
