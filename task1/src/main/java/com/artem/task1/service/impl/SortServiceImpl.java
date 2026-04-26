package com.artem.task1.service.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortServiceImpl implements SortService {
    private static final Logger logger = LogManager.getLogger(SortServiceImpl.class);

    @Override
    public void bubbleSort(ArrayEntity array) {
        logger.info("Starting bubble sort for array id: {}", array != null ? array.getId() : "null");

        if (array == null || array.getData() == null || array.getData().length < 2) {
            logger.warn("Cannot sort - array is null or has less than 2 elements");
            return;
        }

        int[] data = array.getData();
        logger.info("Original array: {}", data);

        for (int i = 0; i < data.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < data.length - i - 1; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    swapped = true;
                    logger.trace("Swapped elements at positions {} and {}", j, j + 1);
                }
            }

            if (!swapped) {
                logger.info("Array already sorted, breaking early at pass {}", i + 1);
                break;
            }
        }
        array.setData(data);
        logger.info("Bubble sort completed. Sorted array: {}", data);
    }

    @Override
    public void insertionSort(ArrayEntity array) {
        logger.info("Starting insertion sort for array id: {}", array != null ? array.getId() : "null");

        if (array == null || array.getData() == null || array.getData().length < 2) {
            logger.warn("Cannot sort - array is null or has less than 2 elements");
            return;
        }

        int[] data = array.getData();
        logger.info("Original array: {}", data);

        int n = data.length;
        for (int i = 1; i < n; i++) {
            int key = data[i];
            int j = i - 1;

            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
                logger.trace("Shifting element at index {}", j + 1);
            }
            data[j + 1] = key;
            logger.trace("Placed key {} at position {}", key, j + 1);
        }
        array.setData(data);
        logger.info("Insertion sort completed. Sorted array: {}", data);
    }
}