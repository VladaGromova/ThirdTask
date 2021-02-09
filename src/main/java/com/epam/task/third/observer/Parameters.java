package com.epam.task.third.observer;

public class Parameters {

    private final double surfaceArea;
    private final double volume;

    public Parameters(double surfaceArea, double volume) {
        this.surfaceArea = surfaceArea;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return surfaceArea;
    }

    public double getVolume() {
        return volume;
    }
}
