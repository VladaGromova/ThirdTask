package com.epam.task.third.logic;

import com.epam.task.third.entities.Point;
import com.epam.task.third.entities.Pyramid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.*;

public class PyramidLogic {

    private Point firstPoint, secondPoint, thirdPoint, fourthPoint;

    private void init(Pyramid pyramid){
        this.firstPoint = pyramid.getFirstPoint();
        this.secondPoint  = pyramid.getSecondPoint();
        this.thirdPoint = pyramid.getThirdPoint();
        this.fourthPoint = pyramid.getFourthPoint();
    }

    public double countPyramidSurfaceArea(Pyramid pyramid){
        init(pyramid);
        double S1 = getAreaOfTriangle(firstPoint,secondPoint,thirdPoint);
        double S2 = getAreaOfTriangle(firstPoint,secondPoint,fourthPoint);
        double S3 = getAreaOfTriangle(firstPoint,thirdPoint,fourthPoint);
        double S4 = getAreaOfTriangle(secondPoint,thirdPoint,fourthPoint);
        double S = S1+S2+S3+S4;
        return S;
    }

    public double countPyramidVolume(Pyramid pyramid){
        init(pyramid);
        int ax = secondPoint.getX() - firstPoint.getX();
        int ay = secondPoint.getY() - firstPoint.getY();
        int az = secondPoint.getZ() - firstPoint.getZ();
        int bx = thirdPoint.getX() - firstPoint.getX();
        int by = thirdPoint.getY() - firstPoint.getY();
        int bz = thirdPoint.getZ() - firstPoint.getZ();
        int cx = fourthPoint.getX() - firstPoint.getX();
        int cy = fourthPoint.getY() - firstPoint.getY();
        int cz = fourthPoint.getZ() - firstPoint.getZ();

        int determinant = (ax * by * cz - ax * cy * bz - ay * bx * cz + ay * cx * bz + az * bx * cy - az * cx * by);
        double volume = (double) determinant/6;
        return abs(volume);
    }

    private double findDistanceBetweenTwoPoints(Point firstPoint, Point secondPoint) {
        return sqrt(pow(firstPoint.getX() - secondPoint.getX(), 2) + pow(firstPoint.getY() - secondPoint.getY(), 2) + pow(firstPoint.getZ() - secondPoint.getZ(), 2));
    }

    private double getAreaOfTriangle (Point firstPoint, Point secondPoint, Point thirdPoint) {
        double a = findDistanceBetweenTwoPoints(firstPoint, secondPoint);
        double b = findDistanceBetweenTwoPoints(secondPoint, thirdPoint);
        double c = findDistanceBetweenTwoPoints(firstPoint, thirdPoint);
        double P = (a + b + c)/2;
        return sqrt(P * (P - a) * (P - b) * (P - c));
    }

    public boolean isBaseOnCoordinatePlane(Pyramid pyramid){
        init(pyramid);
        return isOnXPlane()||isOnYPlane()||isOnZPlane();
    }

    private boolean isOnXPlane(){
        boolean firstVariant = (firstPoint.getX()==0)&&(secondPoint.getX()==0)&&(thirdPoint.getX()==0);
        boolean secondVariant = (firstPoint.getX()==0)&&(secondPoint.getX()==0)&&(fourthPoint.getX()==0);
        boolean thirdVariant = (secondPoint.getX()==0)&&(thirdPoint.getX()==0)&&(fourthPoint.getX()==0);
        boolean fourthVariant = (firstPoint.getX()==0)&&(thirdPoint.getX()==0)&&(fourthPoint.getX()==0);
        return firstVariant||secondVariant||thirdVariant||fourthVariant;
    }
    private boolean isOnYPlane(){
        boolean firstVariant = (firstPoint.getY()==0)&&(secondPoint.getY()==0)&&(thirdPoint.getY()==0);
        boolean secondVariant = (firstPoint.getY()==0)&&(secondPoint.getY()==0)&&(fourthPoint.getY()==0);
        boolean thirdVariant = (secondPoint.getY()==0)&&(thirdPoint.getY()==0)&&(fourthPoint.getY()==0);
        boolean fourthVariant = (firstPoint.getY()==0)&&(thirdPoint.getY()==0)&&(fourthPoint.getY()==0);
        return firstVariant||secondVariant||thirdVariant||fourthVariant;
    }
    private boolean isOnZPlane(){
        boolean firstVariant = (firstPoint.getZ()==0)&&(secondPoint.getZ()==0)&&(thirdPoint.getZ()==0);
        boolean secondVariant = (firstPoint.getZ()==0)&&(secondPoint.getZ()==0)&&(fourthPoint.getZ()==0);
        boolean thirdVariant = (secondPoint.getZ()==0)&&(thirdPoint.getZ()==0)&&(fourthPoint.getZ()==0);
        boolean fourthVariant = (firstPoint.getZ()==0)&&(thirdPoint.getZ()==0)&&(fourthPoint.getZ()==0);
        return firstVariant||secondVariant||thirdVariant||fourthVariant;
    }

    public boolean isPyramid(Point firstPoint, Point secondPoint, Point thirdPoint, Point fourthPoint){
        Set<Point> hashSet = new HashSet<>(Arrays.asList(firstPoint, secondPoint, thirdPoint, fourthPoint));
        return hashSet.size()==4;
    }

}
