package com.company.Memento;

public class MementoApp {
    public static void main(String[] args){
        Game game = new Game();
        game.set("first", 1000);

        Save save1 = game.save();
        File file  = new File();
        file.setSave(save1);

        game.set("second", 12309);
        Save save2 = game.save();
        game.load(file.getSave());
        file.setSave(save2);
        System.out.println(game);
        game.load(file.getSave());
        System.out.println(game);

    }
}

class Game{
    private String level;
    private int ms;
    public void set(String level, int ms){
        this.level = level;
        this.ms = ms;
    }
    public void load(Save save){
        level = save.getLevel();
        ms = save.getMs();
    }
    public Save save(){
        return new Save(level, ms);
    }

    @Override
    public String toString() {
        return "Game [" + level + ", " + ms + "]";
    }
}
//Memento
class Save{
    private final String level;
    private final int ms;
    public Save(String level, int ms){
        super();
        this.level = level;
        this.ms = ms;
    }

    public String getLevel() {
        return level;
    }

    public int getMs() {
        return ms;
    }
}
//Caretaker
class File{
    Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}
