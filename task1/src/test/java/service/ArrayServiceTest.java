package service;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.service.impl.ArrayServiceImpl;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceTest {

    private static final int[] DATA = {3, 1, 5};

    private final ArrayServiceImpl service = new ArrayServiceImpl();

    @Test
    void testMin() {
        ArrayEntity array = new ArrayEntity(DATA);

        int result = service.findMin(array).get();

        assertEquals(1, result);
    }

    @Test
    void testAverage() {
        ArrayEntity array = new ArrayEntity(DATA);

        double result = service.average(array).get();

        assertEquals(3.0, result);
    }
}