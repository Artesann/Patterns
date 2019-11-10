package com.company.AbstractFactory;

interface Mouse{
    void click();
    void dblclick();
    void scroll();
}

interface Keyboard{
    void print();
    void println();
}

interface Touchpad{
    void track(int delX, int delY);
}

