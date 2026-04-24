package com.artem.task1.repository.specification;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.warehouse.ArrayWarehouse;

import java.util.function.Predicate;

public class MinGreaterSpecification implements Predicate<ArrayEntity> {
    private final int threshold;

    public MinGreaterSpecification(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(ArrayEntity arrayEntity) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        int currentMin = warehouse.get(arrayEntity.getId()).getMin();
        return currentMin > threshold;
    }
}