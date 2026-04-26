package com.artem.task1.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdGenerator {
    private static final Logger logger = LogManager.getLogger(IdGenerator.class);
    private static long currentId = 0;

    public static long generateNextId() {
        long nextId = ++currentId;
        logger.info("Generated new id: {}", nextId);
        return nextId;
    }
}