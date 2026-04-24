package com.artem.task1.repository.specification;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.entity.ArrayStatistics;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpecificationsTest {

    private final int[] testData = {10, 20, 30, 40, 50};
    private static final long TEST_ID = 1L;
    private ArrayEntity array;

    @BeforeEach
    void setUp() {
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

        array = new ArrayEntity(TEST_ID, testData);

        ArrayStatistics stats = new ArrayStatistics(150, 50, 10, 30.0);
        warehouse.put(TEST_ID, stats);
    }

    @Test
    void sumGreaterPositive() {
        SumGreaterSpecification spec = new SumGreaterSpecification(100);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void sumLessPositive() {
        SumLessSpecification spec = new SumLessSpecification(200);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void maxGreaterPositive() {
        MaxGreaterSpecification spec = new MaxGreaterSpecification(40);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void maxLessPositive() {
        MaxLessSpecification spec = new MaxLessSpecification(55);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void minLessPositive() {
        MinLessSpecification spec = new MinLessSpecification(20);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void minGreaterPositive() {
        MinGreaterSpecification spec = new MinGreaterSpecification(9);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void averageGreaterPositive() {
        AverageGreaterSpecification spec = new AverageGreaterSpecification(25.0);

        boolean result = spec.test(array);

        assertTrue(result);
    }

    @Test
    void averageLessPositive() {
        AverageLessSpecification spec = new AverageLessSpecification(30.1);

        boolean result = spec.test(array);

        assertTrue(result);
    }
}