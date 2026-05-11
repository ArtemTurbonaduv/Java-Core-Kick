package com.artem.task2.entity;

import java.util.List;

public class Symbol implements TextComponent {
    private final TextComponentType type;
    private final char symbol;

    public Symbol(char symbol) {
        this.symbol = symbol;

        if(Character.isLetter(symbol)) {
            this.type = TextComponentType.LETTER;
        } else {
            this.type = TextComponentType.PUNCTUATION;
        }
    }

    public char getSymbol(){
        return symbol;
    }

    @Override
    public void add(TextComponent child) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<TextComponent> getChildren() {
        throw  new UnsupportedOperationException();
    }

    @Override
    public TextComponentType getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
