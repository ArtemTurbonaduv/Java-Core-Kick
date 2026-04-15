package com.artem.task1.entity;

import java.util.Arrays;

public class ArrayEntity {
    private int[] data;

    public ArrayEntity(int[] data) {
        this.data = data;
    }

    public int[] getData() {
        return data.clone();
    }

    public void setData(int[] data) {
        this.data = data != null ? data.clone() : new int[0];
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
                "data=" + Arrays.toString(data) +
                ']';
    }
}