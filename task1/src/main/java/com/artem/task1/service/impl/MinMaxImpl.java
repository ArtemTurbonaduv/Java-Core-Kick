package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.MinMax;

import java.util.OptionalInt;

public class MinMaxImpl implements MinMax {

    @Override
    public OptionalInt findMin(ArrayEntity array) {
        return findMinMax(array, false);
    }

    @Override
    public OptionalInt findMax(ArrayEntity array) {
        return findMinMax(array, true);
    }

    private OptionalInt findMinMax(ArrayEntity array, boolean isMax) {
        int[] elements = array.getData();

        if (elements == null || elements.length == 0) {
            return OptionalInt.empty();
        }

        int result = elements[0];
        for (int element : elements) {
            boolean condition = isMax ? (element > result) : (element < result);
            if (condition) {
                result = element;
            }
        }
        return OptionalInt.of(result);
    }
}