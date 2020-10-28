package se.su.dsv.inte.character;


import se.su.dsv.inte.item.Item;
import se.su.dsv.inte.item.Outfit;
import se.su.dsv.inte.item.Weapon;

public class PlayerCharacter extends Character {
    private int currentXP;
    private Item[] inventory;
    private Item weapon;
    private Item outfit;
    private int tauntTime;

    public int getTauntTime(){
        return tauntTime;
    }

    public void setTaunted(){
        tauntTime = 2;
    }

    public void decreaseTauntTime(){
        tauntTime = Math.max(tauntTime - 1, 0);
    }

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
        tauntTime = 0;
    }

    public String putItemInInventory(Item item) {
        if (checkInventoryIsFull()) {
            return "Inventory is full";
        } else {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    break;
                }
            }
            return item.getName() + " Added to Inventory";
        }
    }

    public boolean checkInventoryIsFull() {
        int spaceCounter = 0;
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] != null) {
                spaceCounter++;
            }
        }
        if (spaceCounter == inventory.length) {
            return true;
        } else {
            return false;
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

    //gör om och kolla om ett item redan finns equipat. och eventuellt byt plats på dem och skicka tillbaka det gamla item till inventory
    public void equipItem(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null || inventory[i].getName().equals(item.getName())) {
                if (item instanceof Weapon) {
                    weapon = inventory[i];
                    stats.changeBaseAttackPoints((Weapon) weapon);
                    break;
                } else if (item instanceof Outfit) {
                    outfit = inventory[i];
                    stats.changeBaseDefensePoints((Outfit) outfit);
                    break;
                } else {
                    System.out.println("Item is not in your inventory");
                }
            }
        }
    }

    public Item getWeapon() {
        return weapon;
    }

    public Item getOutfit() {
        return outfit;
    }

    // denna metod används inte just nu
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
            stats = new Stats(getRace(), level);
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
