package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.SortService;

public class SortServiceImpl implements SortService {

    @Override
    public void bubbleSort(ArrayEntity array) {
        if (array == null || array.getData() == null || array.getData().length < 2) {
            return;
        }

        int[] data = array.getData();
        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
        array.setData(data);
    }

    @Override
    public void insertionSort(ArrayEntity array) {
        if (array == null || array.getData() == null || array.getData().length < 2) {
            return;
        }

        int[] data = array.getData();
        int n = data.length;
        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
        array.setData(data);
    }
}