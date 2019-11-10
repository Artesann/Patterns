package com.company.Command;

interface Command {
    void execute();
}
//ConcreteCommand
class StartCommand implements Command{
    Comp comp;
    StartCommand(Comp comp){
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.start();
    }
}

class ResetCommand implements Command{
    Comp comp;
    ResetCommand(Comp comp){
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.reset();
    }
}

class StopCommand implements Command{
    Comp comp;
    StopCommand(Comp comp){
        this.comp = comp;
    }
    @Override
    public void execute() {
        comp.stop();
    }
}