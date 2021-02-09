package com.epam.task.third.comparators;

import com.epam.task.third.entities.PyramidWithID;

import java.util.Comparator;

public class ComparatorByFirstZCoordinate  implements Comparator<PyramidWithID> {
    @Override
    public int compare(PyramidWithID firstPyramid, PyramidWithID secondPyramid) {
        int firstCoordinate = firstPyramid.getFirstPoint().getZ();
        int secondCoordinate = secondPyramid.getFirstPoint().getZ();
        return Integer.compare(firstCoordinate, secondCoordinate);
    }
}
