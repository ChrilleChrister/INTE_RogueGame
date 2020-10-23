package se.su.dsv.inte.item;

public class Consumable extends Item {

    private String type;
    private int stackCounter = 1;



    public Consumable(String name) {
        super(name);
    }

    public void addOneItemToStack(){
        stackCounter++;
    }

    public void removeOneItemFromStack(){
        stackCounter--;
    }

    public int getStackCounter(){
        return stackCounter;
    }




    @Override
    public String toString() {
        return null;
    }
}
