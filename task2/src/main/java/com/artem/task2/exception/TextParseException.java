package com.artem.task2.exception;

public class TextParseException extends Exception {
    public TextParseException() {
        super();
    }

    public TextParseException(String message) {
        super(message);
    }

    public TextParseException(Throwable cause) {
        super(cause);
    }

    public TextParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
