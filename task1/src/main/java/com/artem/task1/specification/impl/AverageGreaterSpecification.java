package com.artem.task1.specification.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.specification.ArraySpecification;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageGreaterSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger(AverageGreaterSpecification.class);
    private final double threshold;

    public AverageGreaterSpecification(double threshold) {
        this.threshold = threshold;
        logger.info("Created AverageGreaterSpecification with threshold: {}", threshold);
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        logger.info("Checking if average > {} for array id: {}", threshold, arrayEntity.getId());

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        double currentAverage = warehouse.get(arrayEntity.getId()).getAverage();

        boolean result = currentAverage > threshold;
        logger.info("Array {} average: {}, threshold: {}, result: {}",
                arrayEntity.getId(), currentAverage, threshold, result);

        return result;
    }
}