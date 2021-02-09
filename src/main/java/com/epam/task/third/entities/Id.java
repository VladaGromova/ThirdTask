package com.epam.task.third.entities;

public class Id {

    private static int count = 0;
    private int id;

    public Id(){
        id = (count++);
    }

    public int getId() {
        return id;
    }
}
