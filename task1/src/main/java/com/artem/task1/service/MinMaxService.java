package com.artem.task1.service;

import com.artem.task1.entity.ArrayEntity;

import java.util.OptionalInt;

public interface MinMaxService {

    OptionalInt findMin(ArrayEntity array);

    OptionalInt findMax(ArrayEntity array);
}