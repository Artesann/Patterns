package com.company.Decorator;

public class DecoratorApp {
    public static void main(String[] args){
        //new QuotesDecorator(new Printer()).print();
        new QuotesDecorator(new LeftBracketsDecorator(new RightBracketsDecorator(new Printer()))).print();
    }
}

interface PrinterInterface{
    void print();
}

class Printer implements PrinterInterface{
    @Override
    public void print() {
        System.out.print("print kek");
    }
}

abstract class AbstractDecorator implements PrinterInterface{
    protected PrinterInterface component;

    AbstractDecorator(PrinterInterface component){
        this.component = component;
    }
}

class QuotesDecorator extends AbstractDecorator{

    QuotesDecorator(PrinterInterface comp){super(comp);}

    @Override
    public void print() {
        System.out.print("\"");
        component.print();
        System.out.print("\"\n");

    }
}

class LeftBracketsDecorator extends AbstractDecorator{

    LeftBracketsDecorator(PrinterInterface comp){super(comp);}

    @Override
    public void print() {
        System.out.print("[");
        component.print();
    }
}

class RightBracketsDecorator extends AbstractDecorator{

    RightBracketsDecorator(PrinterInterface comp){super(comp);}

    @Override
    public void print() {
        component.print();
        System.out.print("]");
    }
}