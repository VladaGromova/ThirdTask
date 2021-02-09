package com.epam.task.third.comparators;

import com.epam.task.third.entities.PyramidWithID;

import java.util.Comparator;

public class ComparatorByFirstXCoordinate implements Comparator<PyramidWithID> {
    @Override
    public int compare(PyramidWithID firstPyramid, PyramidWithID secondPyramid) {
        int firstCoordinate = firstPyramid.getFirstPoint().getX();
        int secondCoordinate = secondPyramid.getFirstPoint().getX();
        return Integer.compare(firstCoordinate, secondCoordinate);
    }
}
