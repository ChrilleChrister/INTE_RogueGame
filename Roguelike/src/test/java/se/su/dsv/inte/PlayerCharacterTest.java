package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCharacterTest {

    @Test // döp om mig
    public void testAddFiftyXPToPlayerLevelOne() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        assertEquals(0, playerCharacter.getXP());
        playerCharacter.addXP(50);
        assertEquals(1, playerCharacter.getLevel());
        assertEquals(50, playerCharacter.getXP());
    }

    @Test
    public void testAddExactAmountOfXPToLevelUp() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        playerCharacter.addXP(100);
        assertEquals(2, playerCharacter.getLevel());
        assertEquals(0, playerCharacter.getXP());
    }

    @Test
    public void testAddMoreThanRequiredXPToLevelUp() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        playerCharacter.addXP(120);
        assertEquals(2, playerCharacter.getLevel());
        assertEquals(20, playerCharacter.getXP());
    }

    @Test
    public void testAddXPToLevelUpTwice() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        playerCharacter.addXP(550);
        assertEquals(3, playerCharacter.getLevel());
        assertEquals(50, playerCharacter.getXP());
    }

    @Test
    public void testInventorySizeForDwarf() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.DWARF, "Player 1");
        assertEquals(playerCharacter.getInventory().length, 30);
    }

    @Test
    public void testInventorySizeForHobbit() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        assertEquals(playerCharacter.getInventory().length, 20);
    }

    @Test
    public void putAnITemInPlayerCharacterInventoryArrayIndexZero() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        playerCharacter.putItemInInventory(weapon);
        assertEquals(playerCharacter.getInventory()[0].getName(), "Sting");
    }

    @Test
    public void removeAnItemInPlayerCharacterInventoryArrayIndexZero() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.removeItemFromInventory(weapon);
        assertEquals(playerCharacter.getInventory()[0], null);
    }

    @Test
    public void putThreeItemsInPlayerCharacterInventoryArray() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        Item outfit = new Outfit("Bilbos Armor", "Mithril", 55);
        Item potion = new Consumable("Health Potion");
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.putItemInInventory(potion);
        assertEquals(playerCharacter.getInventory()[0].getName(), "Sting");
        assertEquals(playerCharacter.getInventory()[1].getName(), "Bilbos Armor");
        assertEquals(playerCharacter.getInventory()[2].getName(), "Health Potion");
    }


    //Jocke!!! Va tycker du om detta långa namn? :D:D:D
    @Test
    public void putSeveralItemsInPlayerCharacterInventoryArrayAndRemoveItemsFromInventoryArrayAndCheckForEmptyIndexAndAddItemAgain() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        Item weapon2 = new Weapon("Andüril", "Sword", 100);
        Item outfit = new Outfit("Bilbos Armor", "Mithril", 55);
        Item potion = new Consumable("Health Potion");
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(potion);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.removeItemFromInventory(outfit);
        assertEquals(playerCharacter.getInventory()[2], null);
        playerCharacter.putItemInInventory(weapon2);
        assertEquals(playerCharacter.getInventory()[2].getName(), "Andüril");
    }


    @Test
    public void putSeveralItemsInPlayerCharacterInventoryArrayAndRemoveSeveralItemsFromInventoryArrayAndCheckForEmptyIndex() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        Item weapon2 = new Weapon("Andüril", "Sword", 100);
        Item outfit = new Outfit("Bilbos Armor", "Mithril", 55);
        Item potion = new Consumable("Health Potion");
        Item outfit2 = new Outfit("Gimlis Helm", "Titan", 255);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(potion);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.putItemInInventory(weapon2);
        playerCharacter.putItemInInventory(outfit2);
        playerCharacter.removeItemFromInventory(potion);
        playerCharacter.removeItemFromInventory(weapon2);
        playerCharacter.removeItemFromInventory(outfit2);
        assertEquals(playerCharacter.getInventory()[1], null);
        assertEquals(playerCharacter.getInventory()[3], null);
        assertEquals(playerCharacter.getInventory()[4], null);
    }

    @Test
    public void checkIfInventoryIsFull(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        for(int i = 0; i<playerCharacter.getInventory().length; i++){
            playerCharacter.putItemInInventory(new Weapon("Sting", "Sword", 25));
        }
        assertTrue(playerCharacter.checkInventoryIsFull());
    }

    @Test
    public void tryToAddItemWhenInventoryIsFull(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.DWARF, "Player 1");

        for(int i = 0; i<playerCharacter.getInventory().length; i++){
            playerCharacter.putItemInInventory(new Weapon("...and My Axe", "Axe", 10));
        }
        assertEquals(playerCharacter.putItemInInventory(new Outfit("Gandalf's Robe", "Robe", 555)), "Inventory is full");
    }

    @Test
    public void testEquipWeaponAndOutfit(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Andüril", "Sword", 100);
        Item outfit = new Outfit("Bilbos Armor", "Mithril", 55);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.equipItem(weapon);
        playerCharacter.equipItem(outfit);
        assertEquals(playerCharacter.getWeapon().getName(), "Andüril");
        assertEquals(playerCharacter.getOutfit().getName(), "Bilbos Armor");
    }

    @Test
    public void testEquipItemNotInInventory(){



    }
}