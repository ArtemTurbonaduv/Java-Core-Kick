package com.artem.task1.observer;

import com.artem.task1.entity.ArrayEntity;
import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(ArrayEntity source) {
        super(source);
    }

    @Override
    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }
}