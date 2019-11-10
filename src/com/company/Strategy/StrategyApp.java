package com.company.Strategy;

public class StrategyApp {
    public static void main(String[] args){
        StrategyClient strategy = new StrategyClient();
        strategy.setStrategy(new BubbleSort());
        strategy.executeStrategy(new int [] {12,4,15,213});
    }
}
//Context
class StrategyClient{
    private Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int [] arr) {
        strategy.sort(arr);
    }
}
//Strategy
interface Sorting{
    void sort(int [] arr);
}

class BubbleSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("BubbleSort");
    }
}

class ShellSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("ShellSort");
    }
}

