package com.company.Builder;

public class BuilderApp {
    public static void main(String[] args) {
        Car car = new CarBuilder()
                .buildMake("Honda")
                 .buildMaxSpeed(250)
                .buildTransmission(Transmission.AUTO)
                .build();

        System.out.println(car);
    }
}

enum Transmission{
    MANUAL, AUTO
}

class Car{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return make + " " + transmission + " Max speed: " + maxSpeed;
    }
}

class CarBuilder{
    String m = "Default";
    Transmission t = Transmission.MANUAL;
    int s;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }

    CarBuilder buildTransmission(Transmission t){
        this.t = t;
        return this;
    }

    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setMaxSpeed(s);
        car.setTransmission(t);
        return car;
    }
}