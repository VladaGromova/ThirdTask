package com.epam.task.third.observer;

import com.epam.task.third.logic.PyramidLogic;

import java.util.HashMap;
import java.util.Map;

public class PyramidObserver implements Observer {

    private final PyramidLogic logic;
    private final Map<Integer, Parameters> parameters;
    private static PyramidObserver INSTANCE;

    private PyramidObserver(){
        logic = new PyramidLogic();
        parameters = new HashMap<>();
    }

    public static PyramidObserver getInstance(){
        if (INSTANCE==null){
            INSTANCE = new PyramidObserver();
        }
        return INSTANCE;
    }

    @Override
    public void update(PyramidObservable pyramid) {
        Parameters params = calculateParameters(pyramid);
        parameters.put(pyramid.getId(), params);
    }

    private Parameters calculateParameters(PyramidObservable pyramid){
        double area = logic.countPyramidSurfaceArea(pyramid);
        double volume = logic.countPyramidVolume(pyramid);
        return new Parameters(area,volume);
    }

    public double getPyramidVolume(Integer id){
        Parameters params = parameters.get(id);
        return params.getVolume();
    }

    public double getPyramidSurfaceArea(Integer id){
        Parameters params = parameters.get(id);
        return params.getSurfaceArea();
    }
}
