package com.artem.task1.repository.specification;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.warehouse.ArrayWarehouse;
import java.util.function.Predicate;

public class AverageLessSpecification implements Predicate<ArrayEntity> {
    private final double threshold;

    public AverageLessSpecification(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean test(ArrayEntity arrayEntity) {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        double currentAverage = warehouse.get(arrayEntity.getId()).getAverage();
        return currentAverage < threshold;
    }
}