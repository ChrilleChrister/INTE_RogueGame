package se.su.dsv.inte.item;


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