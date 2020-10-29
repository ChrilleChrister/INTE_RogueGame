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


    public void addOneItemToStack(){
        stackCounter++;
    }

    public void removeOneItemFromStack(){
        stackCounter--;
    }

    public int getStackCounter(){
        return stackCounter;
    }

    public int getRestorePoints(){
        return restorePoints;
    }


    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Consumable) {
            Consumable other = (Consumable) object;
            return other.getName().equals(getName()) && other.restorePoints == restorePoints &&
                    other.stackCounter == stackCounter;
        }

        return false;
    }
}
