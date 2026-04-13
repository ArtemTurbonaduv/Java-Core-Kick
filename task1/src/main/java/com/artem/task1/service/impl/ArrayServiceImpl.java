package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.ArrayService;

import java.util.Optional;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public Optional<Integer> findMin(ArrayEntity array) {
        int[] data = array.getData();

        if (data.length == 0) {
            return Optional.empty();
        }

        int min = data[0];

        for (int value : data) {
            if (value < min) {
                min = value;
            }
        }

        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(ArrayEntity array) {
        int[] data = array.getData();

        if (data.length == 0) {
            return Optional.empty();
        }

        int max = data[0];

        for (int value : data) {
            if (value > max) {
                max = value;
            }
        }

        return Optional.of(max);
    }

    @Override
    public Optional<Integer> sum(ArrayEntity array) {
        int[] data = array.getData();

        if (data.length == 0) {
            return Optional.empty();
        }

        int sum = 0;

        for (int value : data) {
            sum += value;
        }

        return Optional.of(sum);
    }

    @Override
    public Optional<Double> average(ArrayEntity array) {
        Optional<Integer> sumOpt = sum(array);

        if (sumOpt.isEmpty()) {
            return Optional.empty();
        }

        double avg = (double) sumOpt.get() / array.getData().length;
        return Optional.of(avg);
    }

    @Override
    public void bubbleSort(ArrayEntity array) {
        int[] data = array.getData();

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void insertionSort(ArrayEntity array) {
        int[] data = array.getData();

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = key;
        }
    }
}