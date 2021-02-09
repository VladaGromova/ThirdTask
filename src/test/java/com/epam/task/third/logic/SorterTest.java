package com.epam.task.third.logic;

import com.epam.task.third.comparators.ComparatorByFirstXCoordinate;
import com.epam.task.third.comparators.ComparatorByFirstYCoordinate;
import com.epam.task.third.comparators.ComparatorByFirstZCoordinate;
import com.epam.task.third.comparators.ComparatorByID;
import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.PyramidWithID;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SorterTest {

    private final static Point firstPoint = new Point(2, -1, 1);
    private final static Point secondPoint = new Point(5, 5, 4);
    private final static Point thirdPoint = new Point(3, 2, -1);
    private final static Point fourthPoint = new Point(4, 1, 3);
    private final static  PyramidWithID firstPyramid = new PyramidWithID(firstPoint, secondPoint, thirdPoint, fourthPoint);
    private final static PyramidWithID secondPyramid = new PyramidWithID(secondPoint, thirdPoint, fourthPoint, firstPoint);
    private final static PyramidWithID thirdPyramid = new PyramidWithID(thirdPoint, fourthPoint, firstPoint, secondPoint);

    @Test
    public void testComparatorByIdShouldSortById(){
        ComparatorByID comparator = new ComparatorByID();
        List<PyramidWithID> actual = Arrays.asList(thirdPyramid, secondPyramid, firstPyramid);
        actual.sort(comparator);
        Assert.assertEquals(Arrays.asList(firstPyramid, secondPyramid, thirdPyramid), actual);
    }

    @Test
    public void testComparatorByXShouldSortByXCoordinate(){
        ComparatorByFirstXCoordinate comparator = new ComparatorByFirstXCoordinate();
        List<PyramidWithID> actual = Arrays.asList(firstPyramid, secondPyramid, thirdPyramid);
        actual.sort(comparator);
        Assert.assertEquals(Arrays.asList(firstPyramid,  thirdPyramid, secondPyramid), actual);
    }

    @Test
    public void testComparatorByYShouldSortByYCoordinate(){
        ComparatorByFirstYCoordinate comparator = new ComparatorByFirstYCoordinate();
        List<PyramidWithID> actual = Arrays.asList(firstPyramid, secondPyramid, thirdPyramid);
        actual.sort(comparator);
        Assert.assertEquals(Arrays.asList(firstPyramid,  thirdPyramid, secondPyramid), actual);
    }

    @Test
    public void testComparatorByZShouldSortByZCoordinate(){
        ComparatorByFirstZCoordinate comparator = new ComparatorByFirstZCoordinate();
        List<PyramidWithID> actual = Arrays.asList(firstPyramid, secondPyramid, thirdPyramid);
        actual.sort(comparator);
        Assert.assertEquals(Arrays.asList(thirdPyramid, firstPyramid,secondPyramid), actual);
    }
}
