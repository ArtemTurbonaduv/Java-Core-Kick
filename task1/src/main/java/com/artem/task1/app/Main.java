package com.artem.task1.app;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.exception.ArrayException;
import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.factory.impl.ArrayFactoryImpl;
import com.artem.task1.parser.ArrayParser;
import com.artem.task1.parser.impl.ArrayParserImpl;
import com.artem.task1.reader.ArrayReader;
import com.artem.task1.reader.impl.ArrayReaderImpl;
import com.artem.task1.service.MinMaxService;
import com.artem.task1.service.SortService;
import com.artem.task1.service.SumAverageService;
import com.artem.task1.service.impl.MinMaxServiceImpl;
import com.artem.task1.service.impl.SortServiceImpl;
import com.artem.task1.service.impl.SumAverageServiceImpl;
import com.artem.task1.validator.ArrayValidator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidator();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        MinMaxService minMax = new MinMaxServiceImpl();
        SumAverageService sumAver = new SumAverageServiceImpl();
        SortService sort = new SortServiceImpl();

        String filePath = "data/Input.txt";
        try {
            List<String> lines = reader.readLines(filePath);
            for (String line : lines) {
                if (validator.isValid(line)) {
                    int[] numbers = parser.parse(line);
                    ArrayEntity customArray = factory.create(numbers);
                    OptionalDouble avg = sumAver.findAverage(customArray);
                    OptionalInt min = minMax.findMin(customArray);
                    OptionalInt max = minMax.findMax(customArray);
                    if (avg.isPresent()) {
                        double average = avg.getAsDouble();
                    }
                    if (max.isPresent()) {
                        int maximum = max.getAsInt();
                    }
                    if (min.isPresent()) {
                        int minimum = min.getAsInt();
                    }

                    sort.bubbleSort(customArray);
                } else {
                }
            }
        } catch (ArrayException e) {
        }
    }
}