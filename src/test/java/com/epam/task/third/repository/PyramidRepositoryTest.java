package com.epam.task.third.repository;

import com.epam.task.third.entities.PyramidWithID;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PyramidRepositoryTest {

    private final static PyramidWithID FIRST_PYRAMID = new PyramidWithID(Arrays.asList(2, 7, 4, 5, 1, 3, 9, 5, 7, 3, 6, 3));    // 6,2/3
    private final static PyramidWithID SECOND_PYRAMID = new PyramidWithID(Arrays.asList(2, 7, 4, 1, 1, 1, 9, 5, 7, 3, 6, 3));   // 8, 1/3
    private final static PyramidWithID THIRD_PYRAMID = new PyramidWithID(Arrays.asList(20, 20, 20, 1, 1, 1, 9, 5, 7, 3, 6, 3)); // 19
    private static PyramidVolumeLessThanSpecification specification;

    @Test
    public void testAddPyramidShouldAddPyramidToRepo(){
        PyramidRepositoryImpl repository = new PyramidRepositoryImpl();
        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);
        Map<Integer,PyramidWithID> actual = repository.getPyramids();
        Map<Integer, PyramidWithID> expected = new HashMap<Integer, PyramidWithID>(){{
            put(FIRST_PYRAMID.getId(), FIRST_PYRAMID);
            put(SECOND_PYRAMID.getId(), SECOND_PYRAMID);
        }};
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemovePyramidShouldRemovePyramidFromRepo() throws RepositoryException {
        PyramidRepositoryImpl repository = new PyramidRepositoryImpl();
        repository.addPyramid(SECOND_PYRAMID);
        repository.removePyramid(SECOND_PYRAMID);
        Map<Integer, PyramidWithID> expected = new HashMap<>();
        Map<Integer,PyramidWithID> actual = repository.getPyramids();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = RepositoryException.class)
    public void testRemovePyramidShouldThrowExceptionWhenThereIsNoSuchPyramidInRepo() throws RepositoryException {
        PyramidRepositoryImpl repository = new PyramidRepositoryImpl();
        repository.removePyramid(SECOND_PYRAMID);
    }

    @Test
    public void testQueryShouldReturnListOfAllPyramidsGivenSpecification(){
        PyramidRepositoryImpl repository = new PyramidRepositoryImpl();
        repository.addPyramid(FIRST_PYRAMID);
        repository.addPyramid(SECOND_PYRAMID);
        repository.addPyramid(THIRD_PYRAMID);
        specification = new PyramidVolumeLessThanSpecification(10);
        List<PyramidWithID> expected = new ArrayList<>(Arrays.asList(FIRST_PYRAMID, SECOND_PYRAMID));
        List actual = repository.query(specification);
        Assert.assertEquals(expected, actual);
    }

}
