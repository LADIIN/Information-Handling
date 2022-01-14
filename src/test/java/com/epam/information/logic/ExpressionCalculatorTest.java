package com.epam.information.logic;

import com.epam.information.interpreter.ExpressionCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ExpressionCalculatorTest {

    @Test
    public void testCalculateShouldReturnCorrectDoubleWhenExpressionIsCorrect() {
        //given
        String expression = "[8 x y 7 4 + * -]";
        ExpressionCalculator expressionCalculator = new ExpressionCalculator();
        Map<String, Double> parameters = new HashMap<>();
        parameters.put("x", 2.0);

        //when
        double actual = expressionCalculator.calculate(expression, parameters);

        //then
        double expected = 14.0;

        Assert.assertEquals(expected, actual, 0.1);
    }

}
