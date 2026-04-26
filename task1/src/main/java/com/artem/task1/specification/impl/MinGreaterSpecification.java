package com.artem.task1.specification.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.specification.ArraySpecification;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinGreaterSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger(MinGreaterSpecification.class);
    private final int threshold;

    public MinGreaterSpecification(int threshold) {
        this.threshold = threshold;
        logger.info("Created MinGreaterSpecification with threshold: {}", threshold);
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        logger.info("Checking if min > {} for array id: {}", threshold, arrayEntity.getId());

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        int currentMin = warehouse.get(arrayEntity.getId()).getMin();

        boolean result = currentMin > threshold;
        logger.info("Array {} min: {}, threshold: {}, result: {}",
                arrayEntity.getId(), currentMin, threshold, result);

        return result;
    }
}