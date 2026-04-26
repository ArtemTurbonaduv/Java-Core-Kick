package com.artem.task1.factory.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.observer.impl.ArrayObserverImpl;
import com.artem.task1.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactoryImpl implements ArrayFactory {
    private static final Logger logger = LogManager.getLogger(ArrayFactoryImpl.class);

    @Override
    public ArrayEntity create(int[] data) {
        logger.info("Creating new array with data: {}", data != null ? data.length : 0);
        final long newId = IdGenerator.generateNextId();
        final ArrayEntity array = new ArrayEntity(newId, data);

        array.attach(new ArrayObserverImpl());
        array.notifyObservers();

        logger.info("Array created with id: {}", newId);
        return array;
    }
}