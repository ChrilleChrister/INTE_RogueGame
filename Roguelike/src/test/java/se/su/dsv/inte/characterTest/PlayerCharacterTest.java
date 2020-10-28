package se.su.dsv.inte.characterTest;

import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.item.*;

import static org.junit.Assert.*;

public class PlayerCharacterTest {

    @Test
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
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        playerCharacter.putItemInInventory(weapon);
        assertEquals(playerCharacter.getInventory()[0].getName(), "Sting");
    }

    @Test
    public void removeAnItemInPlayerCharacterInventoryArrayIndexZero() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.removeItemFromInventory(weapon);
        assertEquals(playerCharacter.getInventory()[0], null);
    }

    @Test
    public void putThreeItemsInPlayerCharacterInventoryArray() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        Item outfit = new Outfit("Bilbos Armor", OutfitType.MITHRIL, 55);
        Item potion = new Consumable("Health Potion");
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.putItemInInventory(potion);
        assertEquals(playerCharacter.getInventory()[0].getName(), "Sting");
        assertEquals(playerCharacter.getInventory()[1].getName(), "Bilbos Armor");
        assertEquals(playerCharacter.getInventory()[2].getName(), "Health Potion");
    }



    @Test
    public void putSeveralItemsInPlayerCharacterInventoryArrayAndRemoveItemsFromInventoryArrayAndCheckForEmptyIndexAndAddItemAgain() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        Item weapon2 = new Weapon("Andüril", WeaponType.SWORD, 100);
        Item outfit = new Outfit("Bilbos Armor", OutfitType.MITHRIL, 55);
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
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        Item weapon2 = new Weapon("Andüril", WeaponType.SWORD, 100);
        Item outfit = new Outfit("Bilbos Armor", OutfitType.MITHRIL, 55);
        Item potion = new Consumable("Health Potion");
        Item outfit2 = new Outfit("Gimlis Helm", OutfitType.PLATE, 255);
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
            playerCharacter.putItemInInventory(new Weapon("Sting", WeaponType.SWORD, 25));
        }
        assertTrue(playerCharacter.checkInventoryIsFull());
    }

    @Test
    public void tryToAddItemWhenInventoryIsFull(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.DWARF, "Player 1");

        for(int i = 0; i<playerCharacter.getInventory().length; i++){
            playerCharacter.putItemInInventory(new Weapon("...and My Axe", WeaponType.AXE, 10));
        }
        assertEquals(playerCharacter.putItemInInventory(new Outfit("Gandalf's Robe", OutfitType.CLOTH, 555)), "Inventory is full");
    }

    @Test
    public void testEquipWeaponAndOutfit(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");

        Item weapon = new Weapon("Andüril", WeaponType.SWORD, 100);
        Item outfit = new Outfit("Bilbos Armor", OutfitType.MITHRIL, 55);
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
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        playerCharacter.equipItem(weapon);
        assertEquals(playerCharacter.getWeapon(), null);
    }

    @Test
    public void testEquipWeaponAndOutfitAndCheckStats(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        Item outfit = new Outfit("Bilbos Armor", OutfitType.MITHRIL, 55);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.putItemInInventory(outfit);
        playerCharacter.equipItem(weapon);
        playerCharacter.equipItem(outfit);
        assertEquals(playerCharacter.getStats().getBaseAttackPoints(),27);
        assertEquals(playerCharacter.getStats().getBaseDefensePoints(), 59);
    }

    @Test
    public void testEquipWeaponAndWeaponRemovedFromInventory(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.equipItem(weapon);
        assertEquals(playerCharacter.getInventory()[0], null);
    }

    @Test
    public void testEquipWeaponTwiceToSeeIfEquippedWeaponsSwapsAndTheOtherGoesBackToInventoryAndStatsUpdated(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Item weapon = new Weapon("Sting", WeaponType.SWORD, 25);
        Item weapon2 = new Weapon("Andüril", WeaponType.SWORD, 55);
        playerCharacter.putItemInInventory(weapon2);
        playerCharacter.putItemInInventory(weapon);
        playerCharacter.equipItem(weapon);
        assertEquals(playerCharacter.getStats().getBaseAttackPoints(), 27 );
        playerCharacter.equipItem(weapon2);
        assertEquals(playerCharacter.getWeapon().getName(), "Andüril");
        assertEquals(playerCharacter.getInventory()[1].getName(), "Sting");
        assertEquals(playerCharacter.getStats().getBaseAttackPoints(), 57);
    }

    @Test
    public void useComsumableItemAndRestoreHPCurrentHPIsFullAndCheckComsumableStack(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Consumable potion = new Consumable("Health Potion");
        playerCharacter.putItemInInventory(potion);
        potion.addOneItemToStack();
        potion.addOneItemToStack();
        playerCharacter.useComsumableItem(potion);
        assertEquals(potion.getStackCounter(), 2);
        assertEquals(playerCharacter.getCurrentHitpoints(), 20);
    }

    @Test
    public void useAllComsumablesAndCheckIfItemRemovesFromInventory(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        Consumable potion = new Consumable("Health Potion");
        playerCharacter.putItemInInventory(potion);
        potion.addOneItemToStack();
        potion.addOneItemToStack();
        playerCharacter.useComsumableItem(potion);
        playerCharacter.useComsumableItem(potion);
        playerCharacter.useComsumableItem(potion);
        assertEquals(playerCharacter.getInventory()[0], null);
    }

    @Test
    public void useComsumableToHealPartOfCurrentHealth(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.DWARF, "Player 1");
        Consumable potion = new Consumable("Health Potion");
        playerCharacter.putItemInInventory(potion);
        playerCharacter.receiveDamage(29);
        playerCharacter.useComsumableItem(potion);
        assertEquals(playerCharacter.getCurrentHitpoints(), 21);

    }


}