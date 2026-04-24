package com.artem.task1.factory.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.observer.impl.ArrayObserverImpl;

public class ArrayFactoryImpl implements ArrayFactory {
    private static long idCount = 1;

    @Override
    public ArrayEntity create(int[] data) {
        ArrayEntity array = new ArrayEntity(idCount++, data);

        array.attach(new ArrayObserverImpl());
        array.notifyObservers();

        return array;
    }
}