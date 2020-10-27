package se.su.dsv.inte.characterTest;

import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.item.Consumable;
import se.su.dsv.inte.item.Item;
import se.su.dsv.inte.item.Outfit;
import se.su.dsv.inte.item.Weapon;

import static org.junit.Assert.*;

import org.junit.Before;

public class PlayerCharacterTest {

    private static final boolean TAUNTED = true;
    private static final boolean NOT_TAUNTED = false;
    private PlayerCharacter freshPlayerCharacter;

    @Before
    public void initialize(){
        freshPlayerCharacter = new PlayerCharacter(Race.HOBBIT, "freshPlayerCharacter");
    }

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
    public void getStats(){
        Character newCharacter = new Character(Race.DWARF, 5, "Player 1");
        System.out.println(newCharacter.getRace().getBaseHitPoints());
        System.out.println(newCharacter.getRace().getBaseAttackPoints());
        System.out.println(newCharacter.getRace().getBaseDefensePoints());


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
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        playerCharacter.equipItem(weapon);
        assertEquals(playerCharacter.getWeapon(), null);
    }

    @Test
    public void testEquipWeaponAndOutfitAndCheckStats(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        Item outfit = new Outfit("Bilbos Armor", "Mithril", 55);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.equipItem(weapon);
        playerCharacter.equipItem(outfit);
        assertEquals(playerCharacter.getStats().getBaseAttackPoints(),27);
        assertEquals(playerCharacter.getStats().getBaseDefensePoints(), 59);
    }

    @Test
    public void testsetTauntedsetsTaunted(){
        freshPlayerCharacter.setTaunted(true);
        assertEquals(TAUNTED, freshPlayerCharacter.isTaunted());
    }

    @Test
    public void testNewPlayerCharacterIsNotTaunted(){
        PlayerCharacter newCharacter = new PlayerCharacter(Race.HOBBIT, "name");
        assertEquals(NOT_TAUNTED, newCharacter.isTaunted());
    }


}