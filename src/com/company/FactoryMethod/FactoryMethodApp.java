package com.company.FactoryMethod;

import java.util.Date;

public class FactoryMethodApp {
    public static void main(String[] args){
        WatchMaker watchMaker = new DigitalWatchMaker();
        Watch watch = watchMaker.createWatch();
        watch.showTime();
    }
}

interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("XXX -- XL");
    }
}

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomeWatch();
    }
}