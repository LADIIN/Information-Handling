package com.epam.information.interpreter;

import com.epam.information.exception.InformationHandlingException;
import com.epam.information.interpreter.expressions.*;

import java.util.*;

public class ExpressionCalculator {
    private static final String EXPRESSION_SEPARATOR = "\\p{Blank}+";

    public double calculate(String expression, Map<String, Double> parameters) throws InformationHandlingException {
        List<AbstractExpression> expressions = parse(expression, parameters);
        Context context = new Context();
        for (AbstractExpression terminal : expressions) {
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private List<AbstractExpression> parse(String expression, Map<String, Double> parameters) throws InformationHandlingException {
        List<AbstractExpression> expressions = new ArrayList<>();
        String expressionValue = removeBrackets(expression);

        for (String part : expressionValue.split(EXPRESSION_SEPARATOR)) {
            if (!part.isEmpty()) {
                switch (part) {
                    case "+":
                        expressions.add(new TerminalExpressionAdd());
                        break;
                    case "-":
                        expressions.add(new TerminalExpressionSubtract());
                        break;
                    case "*":
                        expressions.add(new TerminalExpressionMultiply());
                        break;
                    case "/":
                        expressions.add(new TerminalExpressionDivide());
                        break;
                    default:
                        Scanner scanner = new Scanner(part);
                        if (scanner.hasNextDouble()) {
                            Double number = scanner.nextDouble();
                            expressions.add(new NonTerminalExpression(number));
                        } else {
                            String key = scanner.next();
                            if (parameters.containsKey(key)) {
                                Double number = parameters.get(key);
                                expressions.add(new NonTerminalExpression(number));
                            } else {
                                throw new InformationHandlingException("There is unknown variable in expression: " + key);
                            }
                        }
                }
            }
        }
        return expressions;
    }

    private String removeBrackets(String expression) {
        return expression.replaceAll("[\\[\\]]", "");
    }
}
