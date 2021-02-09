package com.epam.task.third.repository;

import com.epam.task.third.entities.PyramidWithID;
import com.epam.task.third.entities.Pyramid;

import java.util.*;

public class PyramidRepositoryImpl implements PyramidRepository {

    private final Map<Integer, PyramidWithID> pyramids;

    public PyramidRepositoryImpl() {
        pyramids = new HashMap<>();
    }

    @Override
    public void addPyramid(PyramidWithID pyramid) {
        pyramids.put(pyramid.getId(), pyramid);
    }

    @Override
    public void removePyramid(PyramidWithID pyramid) throws RepositoryException {
        if(!pyramids.containsKey(pyramid.getId())){
            throw new RepositoryException("There is no such Pyramid " + pyramid.toString() + " in Repository");
        }
        int key = pyramid.getId();
        pyramids.remove(key);
    }

    @Override
    public void updatePyramid(PyramidWithID pyramid) {
        int key = pyramid.getId();
        pyramids.replace(key, pyramid);
    }

    @Override
    public List query(PyramidSpecification specification) {
        List<Pyramid> listOfPyramids = new ArrayList<>();
        for (PyramidWithID pyramid : pyramids.values()){
            if(specification.specified(pyramid)){
                listOfPyramids.add(pyramid);
            }
        }
        return listOfPyramids;
    }

    public Map<Integer, PyramidWithID> getPyramids() {
        return pyramids;
    }
}
