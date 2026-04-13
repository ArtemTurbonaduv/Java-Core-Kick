package com.artem.task1.service;

import com.artem.task1.entity.ArrayEntity;

import java.util.Optional;

public interface ArrayService {

    Optional<Integer> findMin(ArrayEntity array);

    Optional<Integer> findMax(ArrayEntity array);

    Optional<Integer> sum(ArrayEntity array);

    Optional<Double> average(ArrayEntity array);

    void bubbleSort(ArrayEntity array);

    void insertionSort(ArrayEntity array);
}