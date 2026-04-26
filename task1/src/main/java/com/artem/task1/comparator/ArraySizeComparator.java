package com.artem.task1.comparator;

import com.artem.task1.entity.ArrayEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Comparator;

public class ArraySizeComparator implements Comparator<ArrayEntity> {
    private static final Logger logger = LogManager.getLogger(ArraySizeComparator.class);

    @Override
    public int compare(ArrayEntity array1, ArrayEntity array2) {
        logger.info("Comparing arrays sizes: {} and {}", array1.getSize(), array2.getSize());
        return Long.compare(array1.getSize(), array2.getSize());
    }
}