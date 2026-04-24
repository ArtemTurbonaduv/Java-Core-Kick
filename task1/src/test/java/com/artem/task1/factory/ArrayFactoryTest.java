package com.artem.task1.factory;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.factory.impl.ArrayFactoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryTest {
    private ArrayFactory factory;
    private final int[] testData = {1, 2, 3, 4, 5};
    private final int[] emptyTestData = {};

    @BeforeEach
    void setUp() {
        factory = new ArrayFactoryImpl();
    }

    @Test
    void createArrayPositive() {
        ArrayEntity array = factory.create(testData);

        assertArrayEquals(testData, array.getData());
    }

    @Test
    void createEmptyArrayPositive() {
        ArrayEntity array = factory.create(emptyTestData);

        assertAll(
                () -> assertEquals(0, array.getSize()),
                () -> assertArrayEquals(new int[0], array.getData())
        );
    }

    @Test
    void generateUniqueIdsPositive() {
        ArrayEntity array1 = factory.create(new int[]{1});
        ArrayEntity array2 = factory.create(new int[]{2});
        ArrayEntity array3 = factory.create(new int[]{3});

        assertAll(
                () -> assertNotEquals(array1.getId(), array2.getId()),
                () -> assertNotEquals(array2.getId(), array3.getId()),
                () -> assertNotEquals(array1.getId(), array3.getId())
        );
    }

    @Test
    void idIncrementPositive() {
        long firstId = factory.create(new int[]{1}).getId();
        long secondId = factory.create(new int[]{2}).getId();

        assertEquals(1, secondId -  firstId);
    }
}