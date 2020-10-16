package se.su.dsv.inte;

public enum Race {
    HOBBIT ("Hobbit", 5),
    DWARF ("Dwarf", 3);

    Race(String name, int baseMovementSpeed) {
        this.name = name;
        this.baseMovementSpeed = baseMovementSpeed;
    }

    private String name;
    private int baseMovementSpeed;

    public String getName() {
        return name;
    }

    public int getBaseMovementSpeed() {
        return baseMovementSpeed;
    }
}
