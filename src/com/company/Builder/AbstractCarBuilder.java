package com.company.Builder;

abstract class AbstractCarBuilder {
    Car car;
    public void createCar(){ car = new Car(); }

    abstract AbstractCarBuilder builMake();
    abstract AbstractCarBuilder buildTransmition();
    abstract AbstractCarBuilder buildMaxSpeed();

    Car getCar() { return car;}
}

class Director{
    AbstractCarBuilder builder;
    void setBuilder(AbstractCarBuilder builder){this.builder = builder;}
    Car buildCar(){
        builder.buildMaxSpeed()
                .buildTransmition()
                .builMake();

        return builder.getCar();
    }
}

class SubaruBuider extends AbstractCarBuilder{
    @Override
    AbstractCarBuilder builMake() {
        car.setMake("Subaru");
        return this;
    }

    @Override
    AbstractCarBuilder buildTransmition() {
        car.setTransmission(Transmission.MANUAL);
        return this;
    }

    @Override
    AbstractCarBuilder buildMaxSpeed() {
        car.setMaxSpeed(200);
        return this;
    }
}

class FordMondeoBuider extends AbstractCarBuilder{
    @Override
    AbstractCarBuilder builMake() {
        car.setMake("Ford Mondeo");
        return this;
    }

    @Override
    AbstractCarBuilder buildTransmition() {
        car.setTransmission(Transmission.AUTO);
        return this;
    }

    @Override
    AbstractCarBuilder buildMaxSpeed() {
        car.setMaxSpeed(250);
        return this;
    }
}
