package com.artem.task2.parser;

public abstract class AbstractParser implements TextParser {
    protected TextParser next;

    @Override
    public void setNext(TextParser next) {
        this.next = next;
    }
}