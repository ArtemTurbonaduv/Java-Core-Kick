package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.SumAverageService;

import java.util.OptionalInt;
import java.util.OptionalDouble;

public class SumAverageServiceImpl implements SumAverageService {

    @Override
    public OptionalInt findSum(ArrayEntity array) {
        int[] data = array.getData();

        if (data == null || data.length == 0) {
            return OptionalInt.empty();
        }

        int sum = 0;

        for (int value : data) {
            sum += value;
        }

        return OptionalInt.of(sum);
    }

    @Override
    public OptionalDouble findAverage(ArrayEntity array) {
        OptionalInt sumOpt = findSum(array);

        if (sumOpt.isEmpty()) {
            return OptionalDouble.empty();
        }

        double avg = (double) sumOpt.getAsInt() / array.getData().length;
        return OptionalDouble.of(avg);
    }

}
