package se.su.dsv.inte;

public class PlayerCharacter extends Character {
    private int xpUntilNextLevel;

    public PlayerCharacter(Race race, String playerName) {
        super(race, 1, playerName);
    }

    public void addXP(int xpToAdd) {
        int required = getRequiredXP();

        if (xpUntilNextLevel + xpToAdd >= required) {
            level++;
            xpUntilNextLevel = xpUntilNextLevel + xpToAdd - required;
        } else {
            xpUntilNextLevel += xpToAdd;
        }
    }

    public int getXP() {
        return xpUntilNextLevel;
    }

    private int getRequiredXP() {
        return (int) Math.pow(level * 10, 2);
    }

}
