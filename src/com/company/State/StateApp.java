package com.company.State;

public class StateApp {
    public static void main(String args){

    }

}

//State
interface Station{
    void play();
}
class Radio7 implements Station{
    @Override
    public void play() {
        System.out.println("Игрет Радио7!");
    }
}
class RadioDFM implements Station{
    @Override
    public void play() {
        System.out.println("Игрет Радио DFM!");
    }
}
class VestiFM implements Station{
    @Override
    public void play() {
        System.out.println("Игрет Вести FM!");
    }
}
//Context
class Radio{
    private Station station;
    void setStation(Station station){ this.station = station; }
    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDFM());
        }
        else if(station instanceof RadioDFM){
            setStation(new VestiFM());
        }
        else if(station instanceof VestiFM){
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}