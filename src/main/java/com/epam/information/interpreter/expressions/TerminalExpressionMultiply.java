package com.epam.information.interpreter.expressions;

import com.epam.information.interpreter.AbstractExpression;
import com.epam.information.interpreter.Context;

public class TerminalExpressionMultiply implements AbstractExpression {
    @Override
    public void interpret(Context context) {
        Double result = context.popValue() * context.popValue();
        context.pushValue(result);
    }
}
