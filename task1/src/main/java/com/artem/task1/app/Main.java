package com.artem.task1.app;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.entity.ArrayStatistics;
import com.artem.task1.exception.ArrayException;
import com.artem.task1.factory.ArrayFactory;
import com.artem.task1.factory.impl.ArrayFactoryImpl;
import com.artem.task1.parser.ArrayParser;
import com.artem.task1.parser.impl.ArrayParserImpl;
import com.artem.task1.reader.ArrayReader;
import com.artem.task1.reader.impl.ArrayReaderImpl;
import com.artem.task1.specification.impl.*;
import com.artem.task1.validator.ArrayValidator;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        logger.info("=== Application started ===");

        ArrayReader reader = new ArrayReaderImpl();
        ArrayValidator validator = new ArrayValidator();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();

        String filePath = "data/Input.txt";

        try {
            List<String> lines = reader.readLines(filePath);
            logger.info("Loaded {} lines from file: {}", lines.size(), filePath);

            List<ArrayEntity> arrays = lines.stream()
                    .filter(validator::isValid)
                    .map(parser::parse)
                    .map(factory::create)
                    .toList();

            logger.info("Created {} valid arrays", arrays.size());

            logger.info("\n=== Arrays with average > 50 ===");
            AverageGreaterSpecification avgGreaterSpec = new AverageGreaterSpecification(50.0);
            arrays.stream()
                    .filter(avgGreaterSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: average={}", arr.getId(), String.format("%.2f", stats.getAverage()));
                    });

            logger.info("\n=== Arrays with average < 30 ===");
            AverageLessSpecification avgLessSpec = new AverageLessSpecification(30.0);
            arrays.stream()
                    .filter(avgLessSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: average={}", arr.getId(), String.format("%.2f", stats.getAverage()));
                    });

            logger.info("\n=== Arrays with max > 80 ===");
            MaxGreaterSpecification maxGreaterSpec = new MaxGreaterSpecification(80);
            arrays.stream()
                    .filter(maxGreaterSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: max={}", arr.getId(), stats.getMax());
                    });

            logger.info("\n=== Arrays with max < 50 ===");
            MaxLessSpecification maxLessSpec = new MaxLessSpecification(50);
            arrays.stream()
                    .filter(maxLessSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: max={}", arr.getId(), stats.getMax());
                    });

            logger.info("\n=== Arrays with min > 10 ===");
            MinGreaterSpecification minGreaterSpec = new MinGreaterSpecification(10);
            arrays.stream()
                    .filter(minGreaterSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: min={}", arr.getId(), stats.getMin());
                    });

            logger.info("\n=== Arrays with min < 5 ===");
            MinLessSpecification minLessSpec = new MinLessSpecification(5);
            arrays.stream()
                    .filter(minLessSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: min={}", arr.getId(), stats.getMin());
                    });

            logger.info("\n=== Arrays with sum > 150 ===");
            SumGreaterSpecification sumGreaterSpec = new SumGreaterSpecification(150);
            arrays.stream()
                    .filter(sumGreaterSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: sum={}", arr.getId(), stats.getSum());
                    });

            logger.info("\n=== Arrays with sum < 50 ===");
            SumLessSpecification sumLessSpec = new SumLessSpecification(50);
            arrays.stream()
                    .filter(sumLessSpec::specify)
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: sum={}", arr.getId(), stats.getSum());
                    });

            logger.info("\n=== Arrays with sum > 100 AND min > 5 ===");
            arrays.stream()
                    .filter(arr -> new SumGreaterSpecification(100).specify(arr))
                    .filter(arr -> new MinGreaterSpecification(5).specify(arr))
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: sum={}, min={}",
                                arr.getId(), stats.getSum(), stats.getMin());
                    });

            logger.info("\n=== Arrays with max > 90 OR average > 60 ===");
            arrays.stream()
                    .filter(arr -> new MaxGreaterSpecification(90).specify(arr)
                            || new AverageGreaterSpecification(60.0).specify(arr))
                    .forEach(arr -> {
                        ArrayStatistics stats = ArrayWarehouse.getInstance().get(arr.getId());
                        logger.info("Array {}: max={}, average={}",
                                arr.getId(), stats.getMax(), String.format("%.2f", stats.getAverage()));
                    });

            logger.info("\n=== Overall Statistics ===");
            long totalArrays = arrays.size();
            long longArrays = arrays.stream()
                    .filter(arr -> arr.getData().length > 10)
                    .count();

            logger.info("Total valid arrays: {}", totalArrays);
            logger.info("Arrays with length > 10: {}", longArrays);

            double overallAverage = arrays.stream()
                    .mapToDouble(arr -> ArrayWarehouse.getInstance().get(arr.getId()).getAverage())
                    .average()
                    .orElse(0);
            logger.info("Overall average across all arrays: {}", String.format("%.2f", overallAverage));

            int globalMax = arrays.stream()
                    .mapToInt(arr -> ArrayWarehouse.getInstance().get(arr.getId()).getMax())
                    .max()
                    .orElse(0);
            logger.info("Global maximum value across all arrays: {}", globalMax);

            int globalMin = arrays.stream()
                    .mapToInt(arr -> ArrayWarehouse.getInstance().get(arr.getId()).getMin())
                    .min()
                    .orElse(0);
            logger.info("Global minimum value across all arrays: {}", globalMin);

            logger.info("\n=== Processing completed. Total arrays processed: {} ===", totalArrays);

        } catch (ArrayException e) {
            logger.error("Error processing file: {}", filePath, e);
        }
    }
}