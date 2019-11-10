package com.company.TemplateMethod;

public class TemplateMethodApp {
    public static void main(String [] args){

    }
}

abstract class C{
    void templateMethod(){
        System.out.print(1);
        differ();
        System.out.print(3);
    }
    abstract void differ();
}

class A extends C{
    @Override
    void differ() {
        System.out.print(2);
    }
}

class B extends C{
    @Override
    void differ() {
        System.out.print(5);
    }
}