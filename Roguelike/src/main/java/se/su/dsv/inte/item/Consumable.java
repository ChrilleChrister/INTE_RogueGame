package se.su.dsv.inte.item;

public class Consumable extends Item {

    private int restorePoints;
    private int stackCounter = 1;


    public Consumable(String name, int restore){
        super(name);
        this.restorePoints = restore;
    }

    public Consumable(String name) {
        super(name);
    }

    public int getStackCounter(){
        return stackCounter;
    }

    public int getRestorePoints(){
        return restorePoints;
    }

    public void addOneItemToStack(){
        stackCounter++;
    }

    public void removeOneItemFromStack(){
        stackCounter--;
    }




}
