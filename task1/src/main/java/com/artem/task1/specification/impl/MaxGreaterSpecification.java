package com.artem.task1.specification.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.specification.ArraySpecification;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxGreaterSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger(MaxGreaterSpecification.class);
    private final int threshold;

    public MaxGreaterSpecification(int threshold) {
        this.threshold = threshold;
        logger.info("Created MaxGreaterSpecification with threshold: {}", threshold);
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        logger.info("Checking if max > {} for array id: {}", threshold, arrayEntity.getId());

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        int currentMax = warehouse.get(arrayEntity.getId()).getMax();

        boolean result = currentMax > threshold;
        logger.info("Array {} max: {}, threshold: {}, result: {}",
                arrayEntity.getId(), currentMax, threshold, result);

        return result;
    }
}