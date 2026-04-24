package com.artem.task1.repository;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.comparator.ArrayIdComparator;
import com.artem.task1.repository.impl.ArrayRepositoryImpl;

import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayRepositoryTest {

    private final ArrayRepositoryImpl repository = ArrayRepositoryImpl.getInstance();
    private final ArrayEntity array1 = new ArrayEntity(1L, new int[]{1, 2, 3});
    private final ArrayEntity array2 = new ArrayEntity(2L, new int[]{4, 5, 6});
    private final ArrayEntity array3 = new ArrayEntity(3L, new int[]{7, 8, 9});

    @Test
    void addSortQueryRemoveArrayPositive() {
        repository.addArray(array3);
        repository.addArray(array1);
        repository.addArray(array2);

        repository.sortArrays(new ArrayIdComparator());

        List<ArrayEntity> all = repository.queryArray(array -> true);
        List<ArrayEntity> query = repository.queryArray(a -> a.getId() % 2 == 0);

        assertAll(
                () -> assertEquals(3, all.size()),
                () -> assertTrue(all.containsAll(List.of(array1, array2, array3))),
                () -> assertEquals(1L, all.get(0).getId()),
                () -> assertEquals(2L, all.get(1).getId()),
                () -> assertEquals(3L, all.get(2).getId()),
                () -> assertEquals(1, query.size()),
                () -> assertTrue(query.contains(array2))
        );

        repository.removeArray(array1);

        List<ArrayEntity> result = repository.queryArray(array -> true);
        assertAll(
                () -> assertEquals(2, result.size()),
                () -> assertFalse(result.contains(array1)),
                () -> assertTrue(result.contains(array2))
        );
    }
}