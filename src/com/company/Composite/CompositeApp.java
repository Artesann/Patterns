package com.company.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args){

    }
}

interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Square");
    }
}

class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Triangle");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();

    void add(Shape s){
        components.add(s);
    }

    void remove(Shape s){
        components.remove(s);
    }

    @Override
    public void draw() {
        for (Shape comp: components){
            comp.draw();
        }
    }
}