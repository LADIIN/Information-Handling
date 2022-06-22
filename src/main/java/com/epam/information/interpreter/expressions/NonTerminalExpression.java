package com.epam.information.interpreter.expressions;

import com.epam.information.interpreter.AbstractExpression;
import com.epam.information.interpreter.Context;

public class NonTerminalExpression implements AbstractExpression {
    private final Double number;

    public NonTerminalExpression(Double number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.pushValue(number);
    }
}
