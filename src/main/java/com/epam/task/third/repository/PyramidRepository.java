package com.epam.task.third.repository;

import com.epam.task.third.entities.PyramidWithID;

import java.util.List;

public interface PyramidRepository {

    void addPyramid(PyramidWithID pyramid);
    void removePyramid(PyramidWithID pyramid) throws RepositoryException;
    void updatePyramid(PyramidWithID pyramid);
    List query(PyramidSpecification specification);
}
