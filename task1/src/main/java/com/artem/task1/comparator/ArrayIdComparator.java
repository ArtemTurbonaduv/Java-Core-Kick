package com.artem.task1.comparator;

import com.artem.task1.entity.ArrayEntity;
import java.util.Comparator;

public class ArrayIdComparator implements Comparator<ArrayEntity> {
    @Override
    public int compare(ArrayEntity array1, ArrayEntity array2) {
        return Long.compare(array1.getId(), array2.getId());
    }
}