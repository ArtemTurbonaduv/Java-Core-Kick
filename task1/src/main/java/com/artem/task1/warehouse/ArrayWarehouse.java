package com.artem.task1.warehouse;

import com.artem.task1.entity.ArrayStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    private static final Logger logger = LogManager.getLogger(ArrayWarehouse.class);
    private static ArrayWarehouse instance;
    private final Map<String, ArrayStatistics> map;

    private ArrayWarehouse() {
        map = new HashMap<>();
        logger.info("ArrayWarehouse created");
    }

    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
            logger.info("ArrayWarehouse instance created");
        }
        return instance;
    }

    public void put(long id, ArrayStatistics arrayStatistics) {
        if (arrayStatistics != null) {
            map.put(String.valueOf(id), arrayStatistics);
            logger.info("Added statistics for id: {} - sum: {}, min: {}, max: {}, avg: {}",
                    id, arrayStatistics.getSum(), arrayStatistics.getMin(),
                    arrayStatistics.getMax(), String.format("%.2f", arrayStatistics.getAverage()));
        } else {
            logger.warn("Attempted to put null statistics for id: {}", id);
        }
    }

    public ArrayStatistics get(long id) {
        ArrayStatistics stats = map.get(String.valueOf(id));
        logger.info("Retrieved statistics for id: {}, found: {}", id, stats != null);
        return stats;
    }
}