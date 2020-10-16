package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    private final String DEFAULT_RACE = "Hobbit";
    private final int DEFAULT_LEVEL = 1;
    private final String DEFAULT_NAME = "Frodo Baggins";

    // Test Enums? Character(RACES.dwarf, 1, Gimli)

    @Test
    public void testCtrSetsAttributes() {
        // No default constructor currently (level has to be specified)
        // Do we need unique id for each Character?
        // Test character level scaling to player level
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL, DEFAULT_NAME);
        assertEquals(DEFAULT_RACE, character.getRace());
        assertEquals(DEFAULT_LEVEL, character.getLevel());
        assertEquals(DEFAULT_NAME, character.getName());
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
        assertEquals(DEFAULT_RACE, character.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtrThrowsIAEIfRaceIsNullButNameIsNotNull() {
        new Character(null, DEFAULT_LEVEL, DEFAULT_NAME);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCtrThrowsIAEIfNameIsNull() {
        new Character(DEFAULT_RACE, DEFAULT_LEVEL, null);
    }


}