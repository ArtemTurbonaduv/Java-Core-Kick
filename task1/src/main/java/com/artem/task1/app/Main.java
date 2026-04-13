package com.artem.task1.app;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.parser.ArrayParser;
import com.artem.task1.reader.ArrayReader;
import com.artem.task1.service.ArrayService;
import com.artem.task1.service.impl.ArrayServiceImpl;
import com.artem.task1.validator.ArrayValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        ArrayReader reader = new ArrayReader();
        ArrayValidator validator = new ArrayValidator();
        ArrayParser parser = new ArrayParser();
        ArrayFactory factory = new ArrayFactory();
        ArrayService service = new ArrayServiceImpl();

        List<String> lines = reader.readLines("data/input.txt");
        List<ArrayEntity> arrays = new ArrayList<>();

        for (String line : lines) {
            if (validator.isValid(line)) {
                int[] parsed = parser.parse(line);
                ArrayEntity entity = factory.create(parsed);
                arrays.add(entity);
            }
        }

        for (ArrayEntity array : arrays) {
            service.bubbleSort(array);
        }
    }
}