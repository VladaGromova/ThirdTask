package com.epam.task.third.comparators;

import com.epam.task.third.entities.PyramidWithID;

import java.util.Comparator;

public class ComparatorByID implements Comparator<PyramidWithID> {
    @Override
    public int compare(PyramidWithID firstPyramid, PyramidWithID secondPyramid) {
        return Integer.compare(firstPyramid.getId(), secondPyramid.getId());
    }
}
