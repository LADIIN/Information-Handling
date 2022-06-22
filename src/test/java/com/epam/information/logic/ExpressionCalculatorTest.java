package com.epam.information.logic;

import com.epam.information.exception.InformationHandlingException;
import com.epam.information.interpreter.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ExpressionCalculatorTest {
    private static final double DELTA = 0.1;
    private static final ExpressionCalculator expressionCalculator = new ExpressionCalculator();
    private static final Map<String, Double> parameters = new HashMap<String, Double>() {
        {
            put("x", 2.0);
        }
    };

    @Test
    public void testCalculateShouldReturnCorrectDoubleSumWhenExpressionIsCorrect() throws InformationHandlingException {
        //given
        String expression = "[8 x +]";
        //when
        double actual = expressionCalculator.calculate(expression, parameters);
        //then
        double expected = 10.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateShouldReturnCorrectDoubleSubtractionWhenExpressionIsCorrect() throws InformationHandlingException {
        //given
        String expression = "[8 x -]";
        //when
        double actual = expressionCalculator.calculate(expression, parameters);
        //then
        double expected = 6.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateShouldReturnCorrectDoubleDividingWhenExpressionIsCorrect() throws InformationHandlingException {
        //given
        String expression = "[8 x /]";
        //when
        double actual = expressionCalculator.calculate(expression, parameters);
        //then
        double expected = 4.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateShouldReturnCorrectDoubleMultiplyingWhenExpressionIsCorrect() throws InformationHandlingException {
        //given
        String expression = "[8 x *]";
        //when
        double actual = expressionCalculator.calculate(expression, parameters);
        //then
        double expected = 16.0;
        Assert.assertEquals(expected, actual, DELTA);
    }

    //then
    @Test(expected = InformationHandlingException.class)
    public void testCalculateShouldThrowExceptionWhenExpressionHasUnknownVariable() throws NoSuchElementException, InformationHandlingException {
        //given
        String expression = "[8 y *]";
        //when
        double actual = expressionCalculator.calculate(expression, parameters);
    }
}

