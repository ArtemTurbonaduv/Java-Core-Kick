package com.artem.task1.observer.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.entity.ArrayStatistics;
import com.artem.task1.observer.ArrayEvent;
import com.artem.task1.observer.ArrayObserver;
import com.artem.task1.service.MinMaxService;
import com.artem.task1.service.SumAverageService;
import com.artem.task1.service.impl.MinMaxServiceImpl;
import com.artem.task1.service.impl.SumAverageServiceImpl;
import com.artem.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger(ArrayObserverImpl.class);
    private final MinMaxService minMaxService = new MinMaxServiceImpl();
    private final SumAverageService sumAverageService = new SumAverageServiceImpl();
    private final ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

    @Override
    public void update(ArrayEvent event) {
        logger.info("Updating statistics for array");

        ArrayEntity source = event.getSource();
        long id = source.getId();

        logger.info("Processing array id: {}", id);

        int sum = sumAverageService.findSum(source).orElse(0);
        int min = minMaxService.findMin(source).orElse(0);
        int max = minMaxService.findMax(source).orElse(0);
        double avg = sumAverageService.findAverage(source).orElse(0.0);

        ArrayStatistics stats = new ArrayStatistics(sum, max, min, avg);

        warehouse.put(id, stats);

        logger.info("Statistics updated for array id: {} - sum: {}, min: {}, max: {}, avg: {}",
                id, sum, min, max, String.format("%.2f", avg));
    }
}