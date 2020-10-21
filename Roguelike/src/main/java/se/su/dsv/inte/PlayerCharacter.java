package se.su.dsv.inte;


public class PlayerCharacter extends Character {
    private int currentXP;
    private Item[] inventory;


    public PlayerCharacter(Race race, String playerName) {
        super(race, 1, playerName);
        switch (race.getName()) {
            case "Dwarf":
                inventory = new Item[30];
                break;
            case "Hobbit":
                inventory = new Item[20];
                break;
        }
    }

    public void putItemInInventory(Item item) {
        for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    break;
                }

        }
    }



    //problem med denna metod är att varje gång man vill ta bort nåt kommer den även sätta om alla null till null igen...
    public void removeItemFromInventory(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null || inventory[i].getName().equals(item.getName())) {
                inventory[i] = null;
            }
        }
    }

    public void openInventory(Item[] inventory) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                System.out.println("Spot " + (i + 1) + " contains Item: " + inventory[i].toString());
            } else {
                System.out.println("Spot " + (i + 1) + " is empty");
            }
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
