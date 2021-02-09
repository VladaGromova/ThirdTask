package com.epam.task.third.observer;

import com.epam.task.third.entities.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PyramidObservableTest {

    private final static List<Integer> TEST_LIST = Arrays.asList(2, 7, 4, 5, 1, 3, 9, 5, 7, 3, 6, 3);
    private final PyramidObservable pyramid = new PyramidObservable(TEST_LIST);
    private final static Point FIRST_POINT = new Point(1, 2, 3);
    private final static Point SECOND_POINT = new Point(2, 4, 6);
    private final static Point THIRD_POINT = new Point(-1, 0, 0);
    private final static Point FOURTH_POINT = new Point(12, 16, 10);

    private final static PyramidObserver observer = PyramidObserver.getInstance();

    @Test
    public void testSetPointsShouldSetPyramidPoints(){
        pyramid.setPoints(FIRST_POINT, SECOND_POINT, THIRD_POINT, FOURTH_POINT);
        PyramidObservable expected = new PyramidObservable(FIRST_POINT, SECOND_POINT, THIRD_POINT, FOURTH_POINT);
        Assert.assertEquals(pyramid, expected);
    }

    @Test
    public void testAttachShouldAttachObserver(){
        pyramid.attach(observer);
        List<Observer> expected = Arrays.asList(observer);
        List<Observer> actual = pyramid.getObservers();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetachShouldDetachObserver(){
        pyramid.detach(observer);
        List<Observer> expected = Collections.emptyList();
        List<Observer> actual = pyramid.getObservers();
        Assert.assertEquals(expected, actual);
    }
}
