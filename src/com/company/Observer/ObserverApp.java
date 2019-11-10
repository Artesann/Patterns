package com.company.Observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args){
        MeteoStation m = new MeteoStation();
        m.addObserver(new ConsoleObserver());
        m.addObserver(new ConsoleObserver());
        m.setMeasurements(10, 756);
        m.setMeasurements(11, 758);
    }
}

interface Observable{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

class MeteoStation implements Observable {
    private int temp;
    private int presser;
    private List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int temp, int presser) {
        this.temp = temp;
        this.presser = presser;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.handleEvent(temp, presser);
        }
    }
}

interface Observer{
    void handleEvent(int temp, int presser);
}

class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temp, int presser) {
        System.out.println("t = " + temp + " pr = " + presser);
    }
}