package com.artem.task1.entity;

import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.factory.impl.ArrayFactoryImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayEntityTest {
    private final ArrayFactory factory = new ArrayFactoryImpl();
    private ArrayEntity arrayEntity;
    private final int[] testData = {1, 2, 3, 4, 5};
    private final int[] otherTestData = {5, 4, 3, 2, 1};

    @BeforeEach
    void setUp() {
        arrayEntity = factory.create(testData);
    }

    @Test
    void getDataReturnsCopyPositive() {
        int[] originalData = arrayEntity.getData();
        int[] secondCall = arrayEntity.getData();

        assertAll(
                () -> assertNotSame(originalData, secondCall),
                () -> assertArrayEquals(originalData, secondCall)
        );
    }

    @Test
    void getDataImmutabilityPositive() {
        int[] receivedData = arrayEntity.getData();
        receivedData[0] = 999;

        assertAll(
                () -> assertNotEquals(999, arrayEntity.getData()[0]),
                () -> assertEquals(testData[0], arrayEntity.getData()[0])
        );
    }

    @Test
    void idPositive() {
        assertTrue(arrayEntity.getId() > 0);
    }

    @Test
    void getSizePositive() {
        assertEquals(5, arrayEntity.getSize());

        arrayEntity.setData(new int[]{1, 2});
        assertEquals(2, arrayEntity.getSize());

        arrayEntity.setData(null);
        assertEquals(0, arrayEntity.getSize());
    }

    @Test
    void setDataPositive() {
        int[] newData = {10, 20, 30};
        arrayEntity.setData(newData);

        assertAll(
                () -> assertArrayEquals(newData, arrayEntity.getData()),
                () -> assertEquals(3, arrayEntity.getSize())
        );
    }

    @Test
    void setDataWithNullPositive() {
        arrayEntity.setData(null);

        assertAll(
                () -> assertArrayEquals(new int[0], arrayEntity.getData()),
                () -> assertEquals(0, arrayEntity.getSize())
        );
    }

    @Test
    void equalsSameDataPositive() {
        ArrayEntity arrayEntity2 = factory.create(testData);

        assertEquals(arrayEntity, arrayEntity2, "Должны быть равны, так как данные одинаковые");
    }

    @Test
    void equalsDifferentDataPositive() {
        ArrayEntity arrayEntity2 = factory.create(otherTestData);

        assertNotEquals(arrayEntity, arrayEntity2);
    }

    @Test
    void equalsNullNegative() {
        assertNotEquals(null, arrayEntity);
    }

    @Test
    void hashCodeChangesWithDataPositive() {
        int originalHash = arrayEntity.hashCode();
        arrayEntity.setData(new int[]{9, 9, 9});
        int newHash = arrayEntity.hashCode();

        assertNotEquals(originalHash, newHash);
    }

    @Test
    void toStringNotNullPositive() {
        assertNotNull(arrayEntity.toString());
    }

    @Test
    void toStringContainsDataPositive() {
        String str = arrayEntity.toString();
        assertTrue(str.contains("1, 2, 3, 4, 5") || str.contains("data="));
    }
}
