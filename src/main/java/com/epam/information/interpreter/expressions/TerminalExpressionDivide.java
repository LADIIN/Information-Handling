package com.epam.information.interpreter.expressions;

import com.epam.information.exception.InformationHandlingException;
import com.epam.information.interpreter.AbstractExpression;
import com.epam.information.interpreter.Context;

public class TerminalExpressionDivide implements AbstractExpression {
    @Override
    public void interpret(Context context) throws InformationHandlingException {
        Double secondMember = context.popValue();
        Double firstMember = context.popValue();

        if (secondMember == 0) {
            throw new InformationHandlingException("Dividing by zero");
        }
        context.pushValue(firstMember / secondMember);
    }
}
