package com.company.Prototype;

public class PrototypeApp {
    public static void main(String[] args){
        Human human = new Human(18, "kek");
        Human kek = human.copy();
    }
}

interface Copyable{
    Object copy();
}

class Human implements Copyable{
    int age;
    String name;

    public Human(int age, String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public Human copy() {
        return new Human(age, name);
    }
}