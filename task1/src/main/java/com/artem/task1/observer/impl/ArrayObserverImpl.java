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

public class ArrayObserverImpl implements ArrayObserver {

    private final MinMaxService minMaxService;
    private final SumAverageService sumAverageService;
    private final ArrayWarehouse warehouse;

    public ArrayObserverImpl() {
        this.minMaxService = new MinMaxServiceImpl();
        this.sumAverageService = new SumAverageServiceImpl();
        this.warehouse = ArrayWarehouse.getInstance();
    }

    @Override
    public void update(ArrayEvent event) {
        ArrayEntity source = event.getSource();
        long id = source.getId();

        int sum = sumAverageService.findSum(source).orElse(0);
        int min = minMaxService.findMin(source).orElse(0);
        int max = minMaxService.findMax(source).orElse(0);
        double avg = sumAverageService.findAverage(source).orElse(0.0);

        ArrayStatistics stats = new ArrayStatistics(sum, max, min, avg);

        warehouse.put(id, stats);
    }
}