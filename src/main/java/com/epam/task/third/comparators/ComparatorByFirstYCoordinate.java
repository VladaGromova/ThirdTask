package com.epam.task.third.comparators;

import com.epam.task.third.entities.PyramidWithID;

import java.util.Comparator;

public class ComparatorByFirstYCoordinate implements Comparator<PyramidWithID> {
    @Override
    public int compare(PyramidWithID firstPyramid, PyramidWithID secondPyramid) {
        int firstCoordinate = firstPyramid.getFirstPoint().getY();
        int secondCoordinate = secondPyramid.getFirstPoint().getY();
        return Integer.compare(firstCoordinate, secondCoordinate);
    }
}
