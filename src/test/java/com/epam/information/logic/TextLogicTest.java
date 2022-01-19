package com.epam.information.logic;

import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.exception.InformationHandlingException;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TextLogicTest {
    private static final TextLogic textLogic = new TextLogic();

    //TODO: Mock it
    @Test
    public void testRestoreShouldReturnCorrectTextWhenCompositeIsValid() {
        String expected = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +] essentially [15  3 /] unchanged. It was popularised in the [5 x *] with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using [2 3 * y +] Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
                "\nIt is a [1200  5 /] established fact that a reader will be of a page when looking at its layout." +
                "\nBye.";
        TextComposite composite = (TextComposite) textLogic.parse(expected);

        //when
        String actual = textLogic.restore(composite);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateExpressionsShouldCalculateCorrectlyWhenCompositeIsValid() throws InformationHandlingException {
        String text = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +] essentially [15  3 /] unchanged. It was popularised in the [5 x *] with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using [2 3 * y +] Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
                "\nIt is a [1200  5 /] established fact that a reader will be of a page when looking at its layout." +
                "\nBye.";

        String parsedText = "It has survived - not only (five) centuries, but also the leap into 15.0 electronic typesetting, remaining 8.0 essentially 5.0 unchanged. It was popularised in the 10.0 with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
                "\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using 9.0 Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
                "\nIt is a 240.0 established fact that a reader will be of a page when looking at its layout." +
                "\nBye.";

        Map<String, Double> parameters = new HashMap<>();
        parameters.put("x", 2.0);
        parameters.put("y", 3.0);

        TextComposite composite = (TextComposite) textLogic.parse(text);
        TextComponent expected = textLogic.parse(parsedText);

        //when
        TextComponent actual = textLogic.calculateExpressions(composite, parameters);

        //then
        System.out.println(textLogic.restore(actual));
        Assert.assertEquals(expected, actual);
    }

//    @Test
//    public void testSortWordsInSentencesShouldSortByLengthWhenCompositeIsValid() {
//        //given
//        String text = "Short Looongest Looong.\nShort Looongest Looong.";
//        String sorted = "Short Looong. Looongest\nShort Looong. Looongest";
//        TextComposite composite = (TextComposite) textLogic.parse(text);
//        TextComposite expected = (TextComposite) textLogic.parse(sorted);
//
//        //when
//        TextComposite actual = textLogic.sortWordsInSentencesByLength(composite);
//
//        //then
//        System.out.println(actual);
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void testSortParagraphsShouldSortByAmountOfSentencesWhenCompositeIsValid() {
        //given
        String text = "Sentence. Sentence. Sentence!\nSentence.\nSentence. Sentence.";
        String sorted = "Sentence. \nSentence. Sentence.\nSentence. Sentence. Sentence!";
        TextComposite composite = (TextComposite) textLogic.parse(text);
        TextComposite expected = (TextComposite) textLogic.parse(sorted);

        //when
        TextComposite actual = textLogic.sortParagraphsBySentenceAmount(composite);

        //then
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }
}
