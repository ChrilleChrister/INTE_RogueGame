package se.su.dsv.inte;

public class Character {
    private String race;
    private int level;

    // Declare throws?
    public Character(String race, int level) {
        if (level < 1)
            throw new IllegalArgumentException("Level can not be less than 1");
        this.race = race;
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public int getLevel() {
        return level;
    }
}
