package com.company.Facade;

public class FacadeApp {
    public static void main(String[] args){

        new Computer().copy();

    }
}

class Power{
    void on(){
        System.out.println("power on");
    }
    void off(){
        System.out.println("power off");
    }
}
class DVDRom{
    private boolean data = false;
    public boolean hasData(){
        return data;
    }
    void load(){
        data = true;
    }
    void unload(){
        data = false;
    }
}

class HDD{
    void copyFromDVD(DVDRom dvd){
        if(dvd.hasData()){
            System.out.println("data is copied");
        }
        else{
            System.out.println("place CD Rom");
        }
    }
}

class Computer{
    private Power power = new Power();
    private DVDRom dvd = new DVDRom();
    private HDD hdd = new HDD();
    void copy(){
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

