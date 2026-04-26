package com.artem.task1.specification.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.specification.ArraySpecification;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumLessSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger(SumLessSpecification.class);
    private final int threshold;

    public SumLessSpecification(int threshold) {
        this.threshold = threshold;
        logger.info("Created SumLessSpecification with threshold: {}", threshold);
    }

    @Override
    public boolean specify(ArrayEntity arrayEntity) {
        logger.info("Checking if sum < {} for array id: {}", threshold, arrayEntity.getId());

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        int currentSum = warehouse.get(arrayEntity.getId()).getSum();

        boolean result = currentSum < threshold;
        logger.info("Array {} sum: {}, threshold: {}, result: {}",
                arrayEntity.getId(), currentSum, threshold, result);

        return result;
    }
}