package se.su.dsv.inte;

public class PlayerCharacter extends Character {
    private int currentXP;



    private Item[] inventory;


    public PlayerCharacter(Race race, String playerName) {
        super(race, 1, playerName);
        switch (race.getName()){
            case "Dwarf":
                inventory = new Item[30];
                break;
            case "Hobbit":
                inventory = new Item[20];
                break;
        }
    }


    public Item[] getInventory() {
        return inventory;
    }




    public void addXP(int xpToAdd) {
        currentXP += xpToAdd;
        int required = getRequiredXP();

        while (currentXP >= required) {
            level++;
            currentXP -= required;
            required = getRequiredXP();
        }
    }

    public int getXP() {
        return currentXP;
    }

    private int getRequiredXP() {
        return (int) Math.pow(level * 10, 2);
    }

}
