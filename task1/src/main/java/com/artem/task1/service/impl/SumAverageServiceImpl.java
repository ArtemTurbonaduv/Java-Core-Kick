package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.SumAverageService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;
import java.util.OptionalDouble;

public class SumAverageServiceImpl implements SumAverageService {
    private static final Logger logger = LogManager.getLogger(SumAverageServiceImpl.class);

    @Override
    public OptionalInt findSum(ArrayEntity array) {
        logger.info("Finding sum for array id: {}", array.getId());

        int[] data = array.getData();

        if (data == null || data.length == 0) {
            logger.warn("Array is empty or null, returning empty");
            return OptionalInt.empty();
        }

        int sum = 0;
        for (int value : data) {
            sum += value;
        }

        logger.info("Sum found: {}", sum);
        return OptionalInt.of(sum);
    }

    @Override
    public OptionalDouble findAverage(ArrayEntity array) {
        logger.info("Finding average for array id: {}", array.getId());

        OptionalInt sumOpt = findSum(array);

        if (sumOpt.isEmpty()) {
            logger.warn("Cannot calculate average - sum is empty");
            return OptionalDouble.empty();
        }

        double avg = (double) sumOpt.getAsInt() / array.getData().length;
        logger.info("Average found: {}", avg);
        return OptionalDouble.of(avg);
    }
}