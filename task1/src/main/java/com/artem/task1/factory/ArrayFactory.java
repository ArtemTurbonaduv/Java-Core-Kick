package com.artem.task1.factory;

import com.artem.task1.entity.ArrayEntity;

public interface ArrayFactory {
    ArrayEntity create(int[] data);
}
