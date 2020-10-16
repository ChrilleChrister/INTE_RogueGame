package se.su.dsv.inte;

public class Character {
    private String race;
    private int level;

    public Character(String race, int level) {
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
