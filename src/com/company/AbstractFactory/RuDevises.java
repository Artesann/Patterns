package com.company.AbstractFactory;

class RuMouse implements Mouse{
    @Override
    public void click() {
    }

    @Override
    public void dblclick() {
    }

    @Override
    public void scroll() {
    }
}

class RuKeyboard implements Keyboard{
    @Override
    public void print() {
    }

    @Override
    public void println() {
    }
}

class RuTouchpad implements Touchpad{
    @Override
    public void track(int delX, int delY) {

    }
}
