package com.artem.task1.factory.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.factory.ArrayFactory;

public class ArrayFactoryImpl implements ArrayFactory {

    @Override
    public ArrayEntity create(int[] data) {
        return new ArrayEntity(data);
    }
}