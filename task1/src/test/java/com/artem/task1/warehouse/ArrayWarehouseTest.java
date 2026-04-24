package com.artem.task1.warehouse;

import com.artem.task1.entity.ArrayStatistics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayWarehouseTest {

    private ArrayWarehouse warehouse;
    private ArrayStatistics testStats;
    private final long TEST_ID = 1L;

    @BeforeEach
    void setUp() {
        warehouse = ArrayWarehouse.getInstance();
        testStats = new ArrayStatistics(100, 50, 10, 25.0);
        warehouse.put(TEST_ID, testStats);
    }

    @Test
    void putGetPositive() {
        ArrayStatistics retrieved = warehouse.get(TEST_ID);

        assertAll(
                () -> assertNotNull(retrieved),
                () -> assertEquals(testStats.getSum(), retrieved.getSum()),
                () -> assertEquals(testStats.getMax(), retrieved.getMax()),
                () -> assertEquals(testStats.getMin(), retrieved.getMin()),
                () -> assertEquals(testStats.getAverage(), retrieved.getAverage())
        );
    }

    @Test
    void getNonExistPositive() {
        ArrayStatistics retrieved = warehouse.get(999L);

        assertNull(retrieved);
    }

    @Test
    void testPutOverwrites() {
        ArrayStatistics newStats = new ArrayStatistics(100, 50, 10, 25.0);

        warehouse.put(TEST_ID, newStats);

        ArrayStatistics retrieved = warehouse.get(TEST_ID);
        assertAll(
                () -> assertEquals(100, retrieved.getSum()),
                () -> assertNotEquals(10, retrieved.getSum())
        );

    }
}