package com.company.Arek.Tools;

import javax.vecmath.Point3f;
import java.awt.*;
import java.util.ArrayList;

public class Triangle {

    private float color1;
    private float color2;
    private float color3;
    private float x1;
    private float x2;
    private float x3;
    private float y1;
    private float y2;
    private float y3;
    private float z1;
    private float z2;
    private float z3;
    private ArrayList<Triangle> p1Triangles;
    private ArrayList<Triangle> p2Triangles;
    private ArrayList<Triangle> p3Triangles;
    private Point3f normal;
    private Point3f normalP1;
    private Point3f normalP2;
    private Point3f normalP3;

    public Triangle(float color1,float color2,float color3,float x1,float y1,float z1,float x2,float y2,float z2,float x3,float y3,float z3){
        this.color1=color1;
        this.color2=color2;
        this.color3=color3;
        this.x1=x1;
        this.x2=x2;
        this.x3=x3;
        this.y1=y1;
        this.y2=y2;
        this.y3=y3;
        this.z1=z1;
        this.z2=z2;
        this.z3=z3;
        this.p1Triangles=new ArrayList<>();
        this.p2Triangles=new ArrayList<>();
        this.p3Triangles=new ArrayList<>();
        normalP1=null;
        normalP2=null;
        normalP3=null;
    }

    public float getColor1() {
        return color1;
    }

    public float getColor2() {
        return color2;
    }

    public float getColor3() {
        return color3;
    }

    public float getX1() {
        return x1;
    }

    public float getX2() {
        return x2;
    }

    public float getX3() {
        return x3;
    }

    public float getY1() {
        return y1;
    }

    public float getY2() {
        return y2;
    }

    public float getY3() {
        return y3;
    }

    public float getZ1() {
        return z1;
    }

    public float getZ2() {
        return z2;
    }

    public float getZ3() {
        return z3;
    }

    public Point3f getP1(){
        return new Point3f(x1,y1,z1);
    }

    public Point3f getP2(){
        return new Point3f(x2,y2,z2);
    }

    public Point3f getP3(){
        return new Point3f(x3,y3,z3);
    }

    public ArrayList<Triangle> getP1Triangles() {
        return p1Triangles;
    }

    public void setP1Triangles(ArrayList<Triangle> p1Triangles) {
        this.p1Triangles = p1Triangles;
    }

    public ArrayList<Triangle> getP3Triangles() {
        return p3Triangles;
    }

    public void setP3Triangles(ArrayList<Triangle> p3Triangles) {
        this.p3Triangles = p3Triangles;
    }

    public ArrayList<Triangle> getP2Triangles() {
        return p2Triangles;
    }

    public void setP2Triangles(ArrayList<Triangle> p2Triangles) {
        this.p2Triangles = p2Triangles;
    }

    public Point3f getNormal() {
        return normal;
    }

    public void setNormal(Point3f normal) {
        this.normal = normal;
    }

    public Point3f getNormalP3() {
        return normalP3;
    }

    public void setNormalP3(Point3f normalP3) {
        this.normalP3 = normalP3;
    }

    public Point3f getNormalP1() {
        return normalP1;
    }

    public void setNormalP1(Point3f normalP1) {
        this.normalP1 = normalP1;
    }

    public Point3f getNormalP2() {
        return normalP2;
    }

    public void setNormalP2(Point3f normalP2) {
        this.normalP2 = normalP2;
    }

    @Override
    public String toString() {
        return  color1 + System.lineSeparator() + color2 + System.lineSeparator() + color3 + System.lineSeparator() + x1 + System.lineSeparator() +
                y1 + System.lineSeparator() + z1 + System.lineSeparator() + x2 + System.lineSeparator() + y2 + System.lineSeparator() + z2 + System.lineSeparator() + x3 + System.lineSeparator() + y3 + System.lineSeparator() + z3;
    }
}
