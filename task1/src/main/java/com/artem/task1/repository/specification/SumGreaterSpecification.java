package com.artem.task1.repository.specification;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.warehouse.ArrayWarehouse;
import java.util.function.Predicate;

public class SumGreaterSpecification implements Predicate<ArrayEntity> {
    private final int threshold;

    public SumGreaterSpecification(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(ArrayEntity arrayEntity) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        int currentSum = warehouse.get(arrayEntity.getId()).getSum();
        return currentSum > threshold;
    }
}