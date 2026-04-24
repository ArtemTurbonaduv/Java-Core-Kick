package com.artem.task1.service;

import com.artem.task1.entity.ArrayEntity;

import java.util.OptionalInt;
import java.util.OptionalDouble;

public interface SumAverageService {

    OptionalInt findSum(ArrayEntity array);

    OptionalDouble findAverage(ArrayEntity array);
}
