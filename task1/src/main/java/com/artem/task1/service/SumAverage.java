package com.artem.task1.service;

import com.artem.task1.entity.ArrayEntity;

import java.util.OptionalInt;
import java.util.OptionalDouble;

public interface SumAverage {

    OptionalInt sum(ArrayEntity array);

    OptionalDouble average(ArrayEntity array);
}
