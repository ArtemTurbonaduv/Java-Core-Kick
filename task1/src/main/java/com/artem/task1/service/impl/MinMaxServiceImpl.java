package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.MinMaxService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;

public class MinMaxServiceImpl implements MinMaxService {
    private static final Logger logger = LogManager.getLogger(MinMaxServiceImpl.class);

    @Override
    public OptionalInt findMin(ArrayEntity array) {
        logger.info("Finding minimum in array id: {}", array.getId());
        OptionalInt result = findMinMax(array, false);
        result.ifPresent(value -> logger.info("Minimum found: {}", value));
        if (result.isEmpty()) {
            logger.warn("No minimum found - array is empty or null");
        }
        return result;
    }

    @Override
    public OptionalInt findMax(ArrayEntity array) {
        logger.info("Finding maximum in array id: {}", array.getId());
        OptionalInt result = findMinMax(array, true);
        result.ifPresent(value -> logger.info("Maximum found: {}", value));
        if (result.isEmpty()) {
            logger.warn("No maximum found - array is empty or null");
        }
        return result;
    }

    private OptionalInt findMinMax(ArrayEntity array, boolean isMax) {
        int[] elements = array.getData();

        if (elements == null || elements.length == 0) {
            logger.warn("Array is empty or null, returning empty");
            return OptionalInt.empty();
        }

        int result = elements[0];
        for (int element : elements) {
            boolean condition = isMax ? (element > result) : (element < result);
            if (condition) {
                result = element;
                logger.trace("New {}: {}", isMax ? "max" : "min", result);
            }
        }
        return OptionalInt.of(result);
    }
}