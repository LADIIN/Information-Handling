package com.epam.information.parser;

public abstract class AbstractParser implements Parser {
    private final Parser successor;

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    protected Parser getSuccessor() {
        return successor;
    }
}
