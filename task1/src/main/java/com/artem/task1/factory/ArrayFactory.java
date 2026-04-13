package com.artem.task1.factory;

import com.artem.task1.entity.ArrayEntity;

public class ArrayFactory {

    public ArrayEntity create(int[] data) {
        return new ArrayEntity(data);
    }
}