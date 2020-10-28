package se.su.dsv.inte.character;


import se.su.dsv.inte.item.Item;
import se.su.dsv.inte.item.Outfit;
import se.su.dsv.inte.item.Weapon;

public class PlayerCharacter extends Character {
    private int currentXP;
    private Item[] inventory;
    private Item weapon;
    private Item outfit;
    private final int INVENTORY_SIZE_DWARF = 30;
    private final int INVENTORY_SIZE_HOBBIT = 20;


    public PlayerCharacter(Race race, String playerName) {
        super(race, 1, playerName);
        switch (race.getName()) {
            case "Dwarf":
                inventory = new Item[INVENTORY_SIZE_DWARF];
                break;
            case "Hobbit":
                inventory = new Item[INVENTORY_SIZE_HOBBIT];
                break;
        }
    }

    public Item[] getInventory() {
        return inventory;
    }

    public int getXP() {
        return currentXP;
    }

    private int getRequiredXP() {
        return (int) Math.pow(level * 10, 2);
    }

    public Item getWeapon() {
        return weapon;
    }

    public Item getOutfit() {
        return outfit;
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
        return spaceCounter == inventory.length;
    }


    public void removeItemFromInventory(Item item) {
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i] == null) {
                continue;
            }
            if(inventory[i].getName().equals(item.getName())){
                inventory[i] = null;
            }
        }
    }



    public void equipItem(Item item) {
        for (Item items : inventory) {
            if(items == null){
                continue;
            }
            if (items.getName().equals(item.getName())) {
                if (item instanceof Weapon) {
                    if(weapon != null){
                        putItemInInventory(weapon);
                        stats.unEquipChangeBaseAttackPoints((Weapon) weapon);
                    }
                    weapon = items;
                    stats.equipChangeBaseAttackPoints((Weapon) weapon);
                    removeItemFromInventory(weapon);
                    break;
                } else if (item instanceof Outfit) {
                    if(outfit != null){
                        putItemInInventory(outfit);
                        stats.unEquipChangeBaseDefensePoints((Outfit) outfit);
                    }
                    outfit = items;
                    stats.equipChangeBaseDefensePoints((Outfit) outfit);
                    removeItemFromInventory(outfit);
                    break;
                } else {
                    System.out.println("Item is not in your inventory");
                }
            }
        }
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


}
