package com.artem.task1.repository;

import com.artem.task1.entity.ArrayEntity;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public interface ArrayRepository {
    void addArray(ArrayEntity arrayEntity);

    void removeArray(ArrayEntity arrayEntity);

    List<ArrayEntity> sortArrays(Comparator<ArrayEntity> comparator);

    List<ArrayEntity> queryArray(Predicate<ArrayEntity> predicate);
}
