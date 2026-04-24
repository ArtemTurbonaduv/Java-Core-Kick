package com.artem.task1.entity;

import com.artem.task1.observer.ArrayEvent;
import com.artem.task1.observer.ArrayObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayEntity {
    private final long id;
    private final List<ArrayObserver> observers = new ArrayList<>();
    private int[] data;

    public ArrayEntity(long id, int[] data) {
        this.id = id;
        this.data = data;
    }

    public int[] getData() {
        return data.clone();
    }

    public void setData(int[] data) {
        this.data = data != null ? data.clone() : new int[0];
        notifyObservers();
    }

    public void setElement(int index, int value) {
        if (index >= 0 && index < data.length) {
            data[index] = value;
            notifyObservers();
        }
    }

    public long getId() {
        return id;
    }

    public int getSize() {
        return data ==  null ? 0 : data.length;
    }

    public void attach(ArrayObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
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