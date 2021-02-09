package com.epam.task.third.entities;

import java.util.List;

public class PyramidWithID extends Pyramid {

    private final Id id;

    public PyramidWithID(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);
        this.id = new Id();
    }

    public PyramidWithID(List<Integer> coordinates) {
        super(coordinates);
        this.id = new Id();
    }

    public int getId(){
        return this.id.getId();
    }
}
