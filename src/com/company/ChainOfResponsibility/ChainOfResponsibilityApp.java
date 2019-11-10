package com.company.ChainOfResponsibility;

public class ChainOfResponsibilityApp {
    public static void main(String[] args){
        SMSLogger logger0 = new SMSLogger(Level1.DEBUG);
        logger0.setNext(new SMSLogger(Level1.ERROR));
        logger0.writeMessage("keks", Level1.DEBUG);
    }
}

class Level1{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

interface Logger{
    void writeMessage(String message, int level);
}

class SMSLogger implements Logger{
    int priority;
    Logger next;

    public SMSLogger(int priority) { this.priority = priority; }

    public void setNext(Logger next) { this.next = next; }

    @Override
    public void writeMessage(String message, int level) {
        if(level<=priority){
            System.out.println("CMC: " + message);
        }
        if(next!=null){
            next.writeMessage(message, level);
        }

    }
}