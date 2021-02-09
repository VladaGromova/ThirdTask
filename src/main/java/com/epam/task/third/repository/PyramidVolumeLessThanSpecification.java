package com.epam.task.third.repository;

import com.epam.task.third.entities.PyramidWithID;
import com.epam.task.third.logic.PyramidLogic;

public class PyramidVolumeLessThanSpecification implements PyramidSpecification{

    private final PyramidLogic logic = new PyramidLogic();
    private final double volume;

    public PyramidVolumeLessThanSpecification(double volume) {
        super();
        this.volume = volume;
    }

    @Override
    public boolean specified(PyramidWithID pyramid) {
        double actual = logic.countPyramidVolume(pyramid);
        return actual<volume;
    }

}
