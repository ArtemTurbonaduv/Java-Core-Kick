package com.artem.task1.entity;

import com.artem.task1.observer.ArrayEvent;
import com.artem.task1.observer.ArrayObservable;
import com.artem.task1.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEntity implements ArrayObservable {
    private static final Logger logger = LogManager.getLogger(ArrayEntity.class);
    private final long id;
    private int[] data;
    private final List<ArrayObserver> observers = new ArrayList<>();

    public ArrayEntity(long id, int[] data) {
        this.id = id;
        this.data = data;
        logger.info("Created ArrayEntity with id: {}, size: {}", id, data != null ? data.length : 0);
    }

    public int[] getData() {
        logger.info("Getting data from array id: {}", id);
        return data.clone();
    }

    public void setData(int[] data) {
        this.data = data != null ? data.clone() : new int[0];
        logger.info("Setting data for array id: {}, new size: {}", id, this.data.length);
        notifyObservers();
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < data.length) {
            logger.info("Setting element at index {} to value {} in array id: {}", index, value, id);
            data[index] = value;
            notifyObservers();
        } else {
            logger.warn("Attempt to set element at invalid index {} in array id: {}", index, id);
        }
    }

    public long getId() {
        logger.info("Getting id: {}", id);
        return id;
    }

    public int getSize() {
        int size = data == null ? 0 : data.length;
        logger.info("Getting size: {} for array id: {}", size, id);
        return size;
    }

    @Override
    public void attach(ArrayObserver observer) {
        if (observer != null) {
            observers.add(observer);
            logger.info("Attached observer to array id: {}, total observers: {}", id, observers.size());
        }
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.remove(observer);
        logger.info("Detached observer from array id: {}, remaining observers: {}", id, observers.size());
    }

    @Override
    public void notifyObservers() {
        logger.info("Notifying {} observers for array id: {}", observers.size(), id);
        ArrayEvent event = new ArrayEvent(this);
        for (ArrayObserver observer : observers) {
            observer.update(event);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        ArrayEntity that = (ArrayEntity) obj;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(data);
    }

    @Override
    public String toString() {
        return "ArrayEntity [" +
                "id=" + id +
                "data=" + Arrays.toString(data) +
                ']';
    }
}