package com.company.Delegate;

public class DelegateApp {

    public static void main(String[] args){
        B b = new B();
        b.f();

        Painter painter = new Painter();
        painter.setGraphics(new Circle());
        painter.draw();
    }
}
//////////////////////////////////////////////
class A{
    void f(){
        System.out.println("f();");
    }
}
// Класс В деллигирует свои полномочия классу А
class B{
    A a = new A();
    void f(){
        a.f();
    }
}
/////////////////////////////////////////////
interface Graphics {
    void draw();
}

class Triangle implements Graphics{
    @Override
    public void draw() {
        System.out.println("tiangle");
    }
}

class Square implements Graphics{
    @Override
    public void draw() {
        System.out.println("square");
    }
}

class Circle implements Graphics{
    @Override
    public void draw() {
        System.out.println("circle");
    }
}

class Painter{
    Graphics graphics;
    void setGraphics(Graphics graphics){
        this.graphics = graphics;
    }

    void draw(){
        graphics.draw();
    }
}