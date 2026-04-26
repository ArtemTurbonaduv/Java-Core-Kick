package com.artem.task1.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public record ArrayStatistics(int sum, int max, int min, double average) {
    private static final Logger logger = LogManager.getLogger(ArrayStatistics.class);

    public int getSum(){
        logger.info("Getting sum: {}", sum);
        return sum;
    }

    public int getMax(){
        logger.info("Getting max: {}", max);
        return max;
    }

    public int getMin(){
        logger.info("Getting min: {}", min);
        return min;
    }

    public double getAverage(){
        logger.info("Getting average: {}", average);
        return average;
    }
}