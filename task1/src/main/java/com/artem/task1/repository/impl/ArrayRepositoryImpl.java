package com.artem.task1.repository.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.repository.ArrayRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static ArrayRepositoryImpl instance;
    private final List<ArrayEntity> arrays = new ArrayList<>();

    private ArrayRepositoryImpl() {}

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void addArray(ArrayEntity arrayEntity){
        arrays.add(arrayEntity);
    }

    @Override
    public void removeArray(ArrayEntity arrayEntity) {
        arrays.remove(arrayEntity);
    }

    @Override
    public void sortArrays(Comparator<ArrayEntity> comparator) {
        arrays.sort(comparator);
    }

    @Override
    public List<ArrayEntity> queryArray(Predicate<ArrayEntity> predicate) {
        List<ArrayEntity> result = arrays.stream().filter(predicate).toList();
        return result;
    }

}
