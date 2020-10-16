package se.su.dsv.inte;

public class Character {
    private String race;
    private int level;
    private String name;

    // Declare throws?
    public Character(String race, int level) {
        this(race, level, race);
    }

    public Character(String race, int level, String name) {
        if (level < 1 || level > 100)
            throw new IllegalArgumentException("Level not in allowed range (1-100)");
        this.race = race;
        this.level = level;
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}
