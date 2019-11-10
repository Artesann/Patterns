package com.company.AbstractFactory;

class EnMouse implements Mouse{
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

class EnKeyboard implements Keyboard{
    @Override
    public void print() {
    }

    @Override
    public void println() {
    }
}

class EnTouchpad implements Touchpad{
    @Override
    public void track(int delX, int delY) {

    }
}