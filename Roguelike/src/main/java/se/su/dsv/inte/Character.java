package se.su.dsv.inte;

public class Character {
    private Race race; // Race change? Modifies attributes!
    private int level;
    private String name;
    private int movementSpeedModifier;
    // private Item[] inventory = new Item[getInventorySize()]; // Inventory for player character (move to subclass later)

    // Declare throws?
    public Character(Race race, int level) {
        this(race, level, race.getName());
    }

    public Character(Race race, int level, String name) {
        if (level < 1 || level > 100)
            throw new IllegalArgumentException("Level not in allowed range (1-100)");
        if (name == null || race == null)
            throw new IllegalArgumentException("Name or race can not be null");
        this.race = race;
        this.level = level;
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getMovementSpeed() {
        return race.getBaseMovementSpeed() + movementSpeedModifier;
    }

//    public void setMovementSpeed(int newMovementSpeedModifier) {
//        this.movementSpeedModifier += newMovementSpeedModifier;
//    }
}
