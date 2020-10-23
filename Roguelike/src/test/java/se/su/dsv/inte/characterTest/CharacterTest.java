package se.su.dsv.inte.characterTest;

import org.junit.Test;
import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.Race;

import static org.junit.Assert.*;

public class CharacterTest {
    private final Race DEFAULT_RACE = Race.HOBBIT;
    private final int DEFAULT_LEVEL = 1;
    private final String DEFAULT_NAME = "Frodo Baggins";

    // Movement speed
    // Equipment, stats
    // Inventory slots
    // Level (Language)

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



}