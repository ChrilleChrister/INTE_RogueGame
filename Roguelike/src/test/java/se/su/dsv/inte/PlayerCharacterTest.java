package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCharacterTest {

    @Test // döp om mig
    public void testAddFiftyXPToPlayerLevelOne(){
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
    public void testInventorySizeForDwarf(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.DWARF, "Player 1");
        assertEquals(playerCharacter.getInventory().length, 30);
    }

    @Test
    public void testInventorySizeForHobbit(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        assertEquals(playerCharacter.getInventory().length, 20);
    }

    @Test
    public void putAnITemInPlayerCharacterInventoryArrayIndexZero(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        playerCharacter.putItemInInventory(weapon);
        assertEquals(playerCharacter.getInventory()[0].getName(),"Sting");
    }

    @Test
    public void removeAnItemInPlayerCharacterInventoryArrayIndexZero(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", "Sword", 25);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.removeItemFromInventory(weapon);
        assertEquals(playerCharacter.getInventory()[0], null);
    }

}