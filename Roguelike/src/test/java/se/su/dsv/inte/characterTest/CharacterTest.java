package se.su.dsv.inte.characterTest;

import org.junit.Test;
import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.Race;

import static org.junit.Assert.*;

import org.junit.Before;

public class CharacterTest {
    private final Race DEFAULT_RACE = Race.HOBBIT;
    private final int DEFAULT_LEVEL = 1;
    private final String DEFAULT_NAME = "Frodo Baggins";
    private final Character DEFAULT_CHARACTER = new Character(DEFAULT_RACE, DEFAULT_LEVEL);
    private final int DEFAULT_DAMAGE = 5;
    private Character freshCharacter;
    private static final int NOT_STUNNED = 0;
    private static final int MAX_STUN_TIME = 2;
    private static final int DECREASED_STUN_TIME = 1;


    // Movement speed
    // Equipment, stats
    // Inventory slots
    // Level (Language)

    @Before 
    public void initialize(){
        freshCharacter = new Character(DEFAULT_RACE, DEFAULT_LEVEL); //for testing damage
    }
    @Test
    public void testCtrSetsAttributes() {
        // No default constructor currently (level has to be specified)
        // Do we need unique id for each Character?
        // Test character level scaling to player level
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL, DEFAULT_NAME);
        assertEquals(DEFAULT_RACE, character.getRace());
        assertEquals(DEFAULT_LEVEL, character.getLevel());
        assertEquals(DEFAULT_NAME, character.getName());
        assertEquals(DEFAULT_RACE.getBaseMovementSpeed(), character.getMovementSpeed());
        assertEquals(character.getStats().getBaseHitPoints(), character.getCurrentHitpoints());
        assertEquals(true, character.isAlive());
        assertEquals(NOT_STUNNED, character.getStunTime());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLevelBelowOneThrowsIAE() {
        new Character(DEFAULT_RACE, -1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLevelAboveOneHundredThrowsIAE() {
        new Character(DEFAULT_RACE, 101);
    }

    @Test
    public void testCtrUsesRaceAsNameIfNameNotSpecified() {
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL);
        assertEquals(DEFAULT_RACE.getName(), character.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtrThrowsIAEIfRaceIsNullButNameIsNotNull() {
        new Character(null, DEFAULT_LEVEL, DEFAULT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtrThrowsIAEIfNameIsNull() {
        new Character(DEFAULT_RACE, DEFAULT_LEVEL, null);
    }

    @Test
    public void testChangeMovementSpeedModifier() {
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL, DEFAULT_NAME);
        character.changeMovementSpeedModifier(-1);
        assertEquals(DEFAULT_RACE.getBaseMovementSpeed() - 1, character.getMovementSpeed());
    }

    @Test
    public void testMovementSpeedCanNotGoBelowZero() {
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL, DEFAULT_NAME);
        character.changeMovementSpeedModifier(-6);
        assertEquals(0, character.getMovementSpeed());
    }

    @Test
    public void testCharacterTakesDamage(){
        freshCharacter.receiveDamage(DEFAULT_DAMAGE);
        assertEquals(freshCharacter.getStats().getBaseHitPoints()-DEFAULT_DAMAGE, freshCharacter.getCurrentHitpoints());
    }

    @Test
    public void healingMoreThanBaseHitpointsSetsCurrentHitpointsToMax(){
        DEFAULT_CHARACTER.heal(DEFAULT_CHARACTER.getStats().getBaseHitPoints()+1);
        assertEquals(DEFAULT_CHARACTER.getStats().getBaseHitPoints(), DEFAULT_CHARACTER.getCurrentHitpoints());
    }

    @Test
    public void testReceiveDamageReturnCurrentHitpointsAfterDamageIsApplied(){
        int hitpoints = freshCharacter.receiveDamage(DEFAULT_DAMAGE);
        assertEquals(freshCharacter.getCurrentHitpoints(), hitpoints);
    }

    @Test
    public void testCharacterCantTakeMoreDamageThanCurrentHitpoints(){
        freshCharacter.receiveDamage(freshCharacter.getCurrentHitpoints()+1);
        assertEquals(0, freshCharacter.getCurrentHitpoints());
    }

    @Test
    public void testCharacterDiesWhenHitpointsReachZero(){
        freshCharacter.receiveDamage(freshCharacter.getCurrentHitpoints()+1);
        assertEquals(false, freshCharacter.isAlive());
    }

    @Test
    public void testSetStunnedSetsStunTimeToTwo(){
        freshCharacter.setStunned();
        assertEquals(MAX_STUN_TIME, freshCharacter.getStunTime());
    }

    @Test
    public void testDecreaseStunTimeDecreasesStunTimeByOne(){
        freshCharacter.setStunned();
        freshCharacter.decreaseStunTime();
        assertEquals(DECREASED_STUN_TIME, freshCharacter.getStunTime());
    }

    @Test
    public void testDecreaseStunTimeCantDecreaseBelowZero(){
        freshCharacter.decreaseStunTime();
        assertEquals(NOT_STUNNED, freshCharacter.getStunTime());
    }

    @Test
    public void testSetStunnedDoesNothingToAlreadyStunnedCharacter(){
        freshCharacter.setStunned();
        freshCharacter.decreaseStunTime();
        freshCharacter.setStunned();
        assertEquals(DECREASED_STUN_TIME, freshCharacter.getStunTime());
    }
}