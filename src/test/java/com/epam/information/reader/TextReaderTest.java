package com.epam.information.reader;

import com.epam.information.exception.InformationHandlingException;
import org.junit.Assert;
import org.junit.Test;

public class TextReaderTest {
    private static final String VALID_FILE_PATH = "src/main/java/resources/text.txt";
    private static final String INVALID_FILE_PATH = "invalidFilePath";
    private static final String NULL_FILE_PATH = null;
    private static final String EMPTY_FILE_PATH = "";
    private static final String EXPECTED = "It has survived - not only (five) centuries, but also the leap into [13  2 +] electronic typesetting, remaining [3  5 +] essentially [15  3 /] unchanged. It was popularised in the [5 x *] with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum." +
            "\nIt is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using [2 3 * y +] Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using (Content here), content here, making it look like readable English." +
            "\nIt is a [1200  5 /] established fact that a reader will be of a page when looking at its layout." +
            "\nBye.";

    @Test
    public void testReadShouldReturnCorrectTextWhenFileIsValid() throws InformationHandlingException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(VALID_FILE_PATH);
        //then
        Assert.assertEquals(EXPECTED, actual);
    }

    //then
    @Test(expected = InformationHandlingException.class)
    public void testReadShouldThrowExceptionWhenFilePathIsNull() throws InformationHandlingException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(NULL_FILE_PATH);
    }

    //then
    @Test(expected = InformationHandlingException.class)
    public void testReadShouldThrowExceptionWhenFilePathIsEmpty() throws InformationHandlingException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(EMPTY_FILE_PATH);
    }

    //then
    @Test(expected = InformationHandlingException.class)
    public void testReadShouldThrowExceptionWhenFilePathIsInvalid() throws InformationHandlingException {
        //given
        TextReader textReader = new TextReader();
        //when
        String actual = textReader.read(INVALID_FILE_PATH);
    }
}
