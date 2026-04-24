package com.artem.task1.warehouse;

import com.artem.task1.entity.ArrayStatistics;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    public static ArrayWarehouse instance;
    private final Map<String, ArrayStatistics> map = new HashMap<>();

    private ArrayWarehouse() {}

    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
        }
        return instance;
    }

    public void put(long id, ArrayStatistics arrayStatistics) {
        map.put(String.valueOf(id), arrayStatistics);
    }

    public ArrayStatistics get(long id) {
        return map.get(String.valueOf(id));
    }
}
