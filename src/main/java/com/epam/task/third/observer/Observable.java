package com.epam.task.third.observer;

public interface Observable {

    void attach(Observer observer);
    void detach(Observer observer);
}
