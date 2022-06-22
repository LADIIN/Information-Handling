package com.epam.information.interpreter;

import com.epam.information.exception.InformationHandlingException;

public interface AbstractExpression {
    void interpret(Context context) throws InformationHandlingException;
}
