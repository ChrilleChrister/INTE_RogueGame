package se.su.dsv.inte;

/**
 * Git test class
 * Linnéa tests ti write someting
 * Jocke wrote something
 */
abstract public class Item {
    private String name;

    public Item(String name ){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract public String toString();
}
