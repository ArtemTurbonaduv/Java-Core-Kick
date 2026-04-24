package com.artem.task1.entity;

public record ArrayStatistics(int sum, int max, int min, double average) {
    public int getSum(){
        return sum;
    }

    public int getMax(){
        return max;
    }

    public int getMin(){
        return min;
    }

    public double getAverage(){
        return average;
    }

}
