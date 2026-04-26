package com.artem.task1.comparator;

import com.artem.task1.entity.ArrayEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Comparator;

public class ArrayIdComparator implements Comparator<ArrayEntity> {
    private static final Logger logger = LogManager.getLogger(ArrayIdComparator.class);

    @Override
    public int compare(ArrayEntity array1, ArrayEntity array2) {
        logger.info("Comparing arrays with ids: {} and {}", array1.getId(), array2.getId());
        return Long.compare(array1.getId(), array2.getId());
    }
}