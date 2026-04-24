package com.artem.task1.repository.specification;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.warehouse.ArrayWarehouse;

import java.util.function.Predicate;

public class MaxLessSpecification implements Predicate<ArrayEntity> {
    private final int threshold;

    public MaxLessSpecification(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(ArrayEntity arrayEntity) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        int currentMax = warehouse.get(arrayEntity.getId()).getMax();
        return currentMax < threshold;
    }
}