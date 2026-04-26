package com.artem.task1.repository.impl;

import com.artem.task1.entity.ArrayEntity;
import com.artem.task1.repository.ArrayRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ArrayRepositoryImpl implements ArrayRepository {
    private static final Logger logger = LogManager.getLogger(ArrayRepositoryImpl.class);
    private static ArrayRepositoryImpl instance;
    private final List<ArrayEntity> arrays;

    private ArrayRepositoryImpl() {
        arrays = new ArrayList<>();
        logger.info("ArrayRepositoryImpl created");
    }

    public static ArrayRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ArrayRepositoryImpl();
            logger.info("ArrayRepositoryImpl instance created");
        }
        return instance;
    }

    @Override
    public void addArray(ArrayEntity arrayEntity){
        arrays.add(arrayEntity);
        logger.info("Added array with id: {}, total arrays: {}", arrayEntity.getId(), arrays.size());
    }

    @Override
    public void removeArray(ArrayEntity arrayEntity) {
        arrays.remove(arrayEntity);
        logger.info("Removed array with id: {}, remaining arrays: {}", arrayEntity.getId(), arrays.size());
    }

    @Override
    public List<ArrayEntity> sortArrays(Comparator<ArrayEntity> comparator) {
        logger.info("Sorting arrays using comparator: {}", comparator.getClass().getSimpleName());
        List<ArrayEntity> sortedList = new ArrayList<>(arrays);
        sortedList.sort(comparator);
        logger.info("Sorting completed, size: {}", sortedList.size());
        return sortedList;
    }

    @Override
    public List<ArrayEntity> queryArray(Predicate<ArrayEntity> predicate) {
        logger.info("Querying arrays with predicate");
        List<ArrayEntity> result = arrays.stream().filter(predicate).toList();
        logger.info("Query completed, found: {}", result.size());
        return result;
    }
}