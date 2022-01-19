package com.epam.information.logic;

import com.epam.information.builder.ParserChainBuilder;
import com.epam.information.comparator.ComponentSizeComparator;
import com.epam.information.entity.TextComponent;
import com.epam.information.entity.impl.TextComposite;
import com.epam.information.entity.impl.Lexeme;
import com.epam.information.exception.InformationHandlingException;
import com.epam.information.interpreter.ExpressionCalculator;
import com.epam.information.parser.Parser;

import java.util.List;
import java.util.Map;

public class TextLogic {
    private static final String EXPRESSION_REGEX = "\\[[^]\\[]*]";
    private static final ExpressionCalculator calculator = new ExpressionCalculator();

    public TextComponent parse(String text) {
        ParserChainBuilder parserChainBuilder = new ParserChainBuilder();
        Parser parser = parserChainBuilder.build();
        return parser.parse(text);
    }

    public String restore(TextComponent composite) {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component : composite.getComponents()) {
            stringBuilder.append("\n").append(component);
        }
        String text = stringBuilder.toString();
        return text.replaceFirst("\n", "");
    }

    public TextComposite calculateExpressions(TextComposite composite, Map<String, Double> parameters) throws InformationHandlingException {
        List<TextComponent> text = composite.getComponents();
        for (TextComponent paragraph : text) {
            for (TextComponent sentence : paragraph.getComponents()) {
                List<TextComponent> lexemes = sentence.getComponents();
                for (TextComponent lexemeComponent : lexemes) {
                    String value = lexemeComponent.toString();
                    if (value.matches(EXPRESSION_REGEX)) {
                        double calculatedValue = calculator.calculate(value, parameters);
                        String stringValue = Double.toString(calculatedValue);
                        TextComponent lexeme = Lexeme.word(stringValue);
                        int index = lexemes.indexOf(lexemeComponent);
                        lexemes.set(index, lexeme);
                    }
                }
            }
        }
        return new TextComposite(text);
    }

    public TextComposite sortParagraphsBySentenceAmount(TextComposite composite) {
        List<TextComponent> paragraphs = composite.getComponents();
        ComponentSizeComparator componentSizeComparator = new ComponentSizeComparator();
        paragraphs.sort(componentSizeComparator);
        return new TextComposite(paragraphs);
    }

    public TextComposite sortWordsInSentencesByLength(TextComposite composite) {
        List<TextComponent> paragraphs = composite.getComponents();
        ComponentSizeComparator componentSizeComparator = new ComponentSizeComparator();

        for (TextComponent paragraph : paragraphs) {
            for (TextComponent sentence : paragraph.getComponents()) {
                List<TextComponent> lexemes = sentence.getComponents();
                lexemes.sort(componentSizeComparator);
            }
        }
        return new TextComposite(paragraphs);
    }
}
