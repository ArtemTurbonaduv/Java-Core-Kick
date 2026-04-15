package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.SumAverage;

import java.util.OptionalInt;
import java.util.OptionalDouble;

public class SumAverageImpl implements SumAverage {

    @Override
    public OptionalInt sum(ArrayEntity array) {
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
    public OptionalDouble average(ArrayEntity array) {
        OptionalInt sumOpt = sum(array);

        if (sumOpt.isEmpty()) {
            return OptionalDouble.empty();
        }

        double avg = (double) sumOpt.getAsInt() / array.getData().length;
        return OptionalDouble.of(avg);
    }

}
