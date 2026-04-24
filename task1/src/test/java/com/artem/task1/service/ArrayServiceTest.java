package com.artem.task1.service;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.impl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {
    private static final int[] inputData = {3, 1, 6, 10, -5, 15};
    private static final int[] expectedSortedData = {-5, 1, 3, 6, 10, 15};
    private static final long TEST_ID = 1L;

    private ArrayEntity array;

    @BeforeEach
    void setUp() {
        array = new ArrayEntity(TEST_ID, inputData);
    }

    @Test
    void findMinPositive() {
        MinMaxService minMax = new MinMaxServiceImpl();
        OptionalInt result = minMax.findMin(array);

        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(-5, result.getAsInt())
        );
    }

    @Test
    void findMaxPositive() {
        MinMaxService minMax = new MinMaxServiceImpl();
        OptionalInt result = minMax.findMax(array);

        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(15, result.getAsInt())
        );
    }

    @Test
    void findSumPositive() {
        SumAverageService sumAverage = new SumAverageServiceImpl();
        OptionalInt result = sumAverage.findSum(array);

        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(30, result.getAsInt())
        );
    }

    @Test
    void findAveragePositive() {
        SumAverageService sumAverage = new SumAverageServiceImpl();
        OptionalDouble result = sumAverage.findAverage(array);

        assertAll(
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(5.0, result.getAsDouble(), 0.001)
        );
    }

    @Test
    void bubbleSortPositive() {
        SortService sort = new SortServiceImpl();
        sort.bubbleSort(array);
        assertArrayEquals(expectedSortedData, array.getData());
    }

    @Test
    void insertionSortPositive() {
        SortService sort = new SortServiceImpl();
        sort.insertionSort(array);
        assertArrayEquals(expectedSortedData, array.getData());
    }
}