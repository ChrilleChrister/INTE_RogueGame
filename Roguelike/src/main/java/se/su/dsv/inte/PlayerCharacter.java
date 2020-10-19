package se.su.dsv.inte;

public class PlayerCharacter extends Character {
    private int xp;

    public PlayerCharacter(Race race, String playerName) {
        super(race, 1, playerName);
    }

    public void addXP(int xpToAdd) {
        xp += xpToAdd;
    }

    public int getXP() {
        return xp;
    }


}
