package com.artem.task1.observer;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.entity.ArrayStatistics;
import com.artem.task1.observer.impl.ArrayObserverImpl;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverTest {
    private ArrayObserverImpl observer;
    private ArrayWarehouse warehouse;

    @BeforeEach
    void setUp() {
        observer = new ArrayObserverImpl();
        warehouse = ArrayWarehouse.getInstance();
    }

    @Test
    void updateCalculatesCorrectStatistics() {
        ArrayEntity array = new ArrayEntity(1L, new int[]{1, 2, 3, 4, 5});
        ArrayEvent event = new ArrayEvent(array);

        observer.update(event);

        ArrayStatistics stats = warehouse.get(1L);

        assertAll(
                () -> assertNotNull(stats),
                () -> assertEquals(15, stats.getSum()),
                () -> assertEquals(5, stats.getMax()),
                () -> assertEquals(1, stats.getMin()),
                () -> assertEquals(3.0, stats.getAverage())
        );
    }

    @Test
    void updateWithEmptyArray() {
        ArrayEntity array = new ArrayEntity(1L, new int[0]);
        ArrayEvent event = new ArrayEvent(array);

        observer.update(event);

        ArrayStatistics stats = warehouse.get(1L);
        assertAll(
                () -> assertNotNull(stats),
                () -> assertEquals(0, stats.getSum()),
                () -> assertEquals(0, stats.getMax()),
                () -> assertEquals(0, stats.getMin()),
                () -> assertEquals(0.0, stats.getAverage())
        );
    }

    @Test
    void updateWithSingleElement() {
        ArrayEntity array = new ArrayEntity(1L, new int[]{42});
        ArrayEvent event = new ArrayEvent(array);

        observer.update(event);

        ArrayStatistics stats = warehouse.get(1L);
        assertAll(
                () -> assertNotNull(stats),
                () -> assertEquals(42, stats.getSum()),
                () -> assertEquals(42, stats.getMax()),
                () -> assertEquals(42, stats.getMin()),
                () -> assertEquals(42.0, stats.getAverage())
        );
    }

    @Test
    void updateWithNegativeNumbers() {
        ArrayEntity array = new ArrayEntity(1L, new int[]{-5, -1, -3});
        ArrayEvent event = new ArrayEvent(array);

        observer.update(event);

        ArrayStatistics stats = warehouse.get(1L);
        assertAll(
                () -> assertNotNull(stats),
                () -> assertEquals(-9, stats.getSum()),
                () -> assertEquals(-1, stats.getMax()),
                () -> assertEquals(-5, stats.getMin()),
                () -> assertEquals(-3.0, stats.getAverage())
        );
    }
}