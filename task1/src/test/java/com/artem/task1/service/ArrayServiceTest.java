package com.artem.task1.service;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.impl.*;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {
    private static final int[] inputData = {3, 1, 6, 10, -5, 15};
    private static final int[] expextedSortedArray = {-5, 1, 3, 6, 10, 15};
    private static final int EXPECTED_MIN = -5;
    private static final int EXPECTED_MAX = 15;
    private static final int EXPECTED_SUM = 30;
    private static final double EXPECTED_AVG = 5;

    private final MinMaxService minMax = new MinMaxServiceImpl();
    private final SortService sort = new SortServiceImpl();
    private final SumAverageService sumAverage = new SumAverageServiceImpl();

    @Test
    void findMinPositive() {
        ArrayEntity array = new ArrayEntity(inputData);

        OptionalInt result = minMax.findMin(array);

        assertAll(
                ()->assertTrue(result.isPresent()),
                ()->assertEquals(EXPECTED_MIN, result.getAsInt())
        );
    }

    @Test
    void findMaxPositive() {
        ArrayEntity array = new ArrayEntity(inputData);

        OptionalInt result = minMax.findMax(array);

        assertAll(
                ()->assertTrue(result.isPresent()),
                ()->assertEquals(EXPECTED_MAX, result.getAsInt())
        );
    }

    @Test
    void findSumPositive() {
        ArrayEntity array = new ArrayEntity(inputData);

        OptionalInt result = sumAverage.sum(array);

        assertAll(
                ()->assertTrue(result.isPresent()),
                ()->assertEquals(EXPECTED_SUM, result.getAsInt())
        );
    }

    @Test
    void findAveragePositive() {
        ArrayEntity array = new ArrayEntity(inputData);

        OptionalDouble result = sumAverage.average(array);

        assertAll(
                ()->assertTrue(result.isPresent()),
                ()->assertEquals(EXPECTED_AVG, result.getAsDouble())
        );
    }

    @Test
    void bubbleSortPositive() {
        ArrayEntity array = new ArrayEntity(inputData);

        sort.bubbleSort(array);

        assertArrayEquals(expextedSortedArray, array.getData());
    }

    @Test
    void insertionSortPositive() {
        ArrayEntity array = new ArrayEntity(inputData);

        sort.insertionSort(array);

        assertArrayEquals(expextedSortedArray, array.getData());
    }
}