package com.artem.task1.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayException extends Exception {
    private static final Logger logger = LogManager.getLogger(ArrayException.class);

    public ArrayException() {
        super();
        logger.error("ArrayException created");
    }

    public ArrayException(String message) {
        super(message);
        logger.error("ArrayException created: {}", message);
    }

    public ArrayException(Throwable cause) {
        super(cause);
        logger.error("ArrayException created with cause", cause);
    }

    public ArrayException(String message, Throwable cause) {
        super(message, cause);
        logger.error("ArrayException created: {}", message, cause);
    }
}