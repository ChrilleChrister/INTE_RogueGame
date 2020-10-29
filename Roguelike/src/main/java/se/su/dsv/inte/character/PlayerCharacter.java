package se.su.dsv.inte.character;


import se.su.dsv.inte.item.Consumable;
import se.su.dsv.inte.item.Item;
import se.su.dsv.inte.item.Outfit;
import se.su.dsv.inte.item.Weapon;
import se.su.dsv.inte.quest.QuestManager;

import java.util.NoSuchElementException;

public class PlayerCharacter extends Character {
    private int currentXP;
    private Item[] inventory;
    private Item weapon;
    private Item outfit;
    private final int INVENTORY_SIZE_DWARF = 30;
    private final int INVENTORY_SIZE_HOBBIT = 20;

    private final QuestManager questManager;
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
                inventory = new Item[INVENTORY_SIZE_DWARF];
                break;
            case "Hobbit":
                inventory = new Item[INVENTORY_SIZE_HOBBIT];
                break;
        }
        tauntTime = 0;
        questManager = new QuestManager(this);

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





    

    public QuestManager getQuestManager() {
        return questManager;
    }

    public boolean inventoryContains(Item item) {
        for (Item i : inventory) {
            if (i != null && i.getName().equals(item.getName())) { //TODO: fix equals for item
                return true;
            }
        }
        return false;

    }

    public void putItemInInventory(Item item) {
        if (checkInventoryIsFull()) {
            throw new ArrayIndexOutOfBoundsException("Inventory is Full");
        } else {
            for (int i = 0; i < inventory.length; i++) {
                if (inventory[i] == null) {
                    inventory[i] = item;
                    break;
                }
            }

            questManager.updateItemAcquisitionStatus(item);

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
            if (inventory[i].getName().equals(item.getName())) {
                inventory[i] = null;
                questManager.updateItemAcquisitionStatus(item);
            }
        }
    }



    public void equipItem(Item item) {
        for (Item items : inventory) {
            if (items == null) {
                continue;
            }
            if (item.getName().equals(items.getName())) {

                if (item instanceof Weapon) {
                    if (weapon != null) {
                        putItemInInventory(weapon);
                        stats.unEquipChangeBaseAttackPoints((Weapon) weapon);
                    }
                    weapon = items;
                    stats.equipChangeBaseAttackPoints((Weapon) weapon);
                    removeItemFromInventory(weapon);
                    break;
                } else if (item instanceof Outfit) {
                    if (outfit != null) {
                        putItemInInventory(outfit);
                        stats.unEquipChangeBaseDefensePoints((Outfit) outfit);
                    }
                    outfit = items;
                    stats.equipChangeBaseDefensePoints((Outfit) outfit);
                    removeItemFromInventory(outfit);
                    break;
                }
            }else {
                throw new NoSuchElementException("Item is not in inventory");
            }
        }
    }


    public void useComsumableItem(Consumable potion) {
        for (Item items : inventory) {
            if (items == null) {
                continue;
            }
            if (items.getName().equals(potion.getName())) {
                potion.removeOneItemFromStack();
                heal(potion.getRestorePoints());
                if (potion.getStackCounter() == 0) {
                    removeItemFromInventory(potion);
                }
            }
        }
    }

    public void addXP(int xpToAdd) {
        if(level == 100){return;}
        currentXP += xpToAdd;
        int required = getRequiredXP();

        while (currentXP >= required) {
            if(level == 100){return;}
            required = levelUp(required);
        }
    }


    //controll this is covered
    public int levelUp(int required){
        level++;
        stats.updateStats(this.getRace(), this.level);
        currentXP -= required;
        return required = getRequiredXP();
    }

    public int getXP() {
        return currentXP;
    }

    private int getRequiredXP() {
        return (int) Math.pow(level * 10, 2);
    }


}
