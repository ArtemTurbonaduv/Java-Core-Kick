package com.artem.task1.comparator;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.factory.impl.ArrayFactoryImpl;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayIdComparatorTest {
    private final ArrayFactory factory = new ArrayFactoryImpl();
    private final ArrayIdComparator comparator = new ArrayIdComparator();
    private final int[] TEST_DATA = {1, 2, 3, 4, 5};
    private final ArrayEntity entity1 = factory.create(TEST_DATA);
    private final ArrayEntity entity2 = factory.create(TEST_DATA);

    @Test
    void compareFirstLessThanSecond() {
        int result = comparator.compare(entity1, entity2);

        assertTrue(result < 0);
    }

    @Test
    void compareFirstGreaterThanSecond() {
        int result = comparator.compare(entity2, entity1);

        assertTrue(result > 0);
    }

    @Test
    void compareEqualIds() {
        ArrayEntity entity1Copy = entity1;

        int result = comparator.compare(entity1, entity1Copy);

        assertEquals(0, result, "Объекты с одинаковым ID должны считаться равными");
    }
}