package com.epam.task.third.observer;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.PyramidWithID;

import java.util.ArrayList;
import java.util.List;

public class PyramidObservable extends PyramidWithID implements Observable{

    private final List<Observer> observers;

    public PyramidObservable(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint) {
        super(firstPoint, secondPoint, thirdPoint, fourthPoint);
        this.observers = new ArrayList<>();
    }

    public PyramidObservable(List<Integer> coordinates) {
        super(coordinates);
        this.observers = new ArrayList<>();
    }

    public void setPoints(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint){
        super.setPoints(firstPoint, secondPoint, thirdPoint, fourthPoint);
        notifyObservers();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(){
        for(Observer observer : observers){
            observer.update(this);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}
