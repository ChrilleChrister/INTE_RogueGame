package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {
    private final String DEFAULT_RACE = "Hobbit";
    private final int DEFAULT_LEVEL = 1;

    @Test
    public void testDefaultCharacterCtr() {
        // No default constructor currently (level has to be specified)
        // Do we need unique id for each Character?
        // Test character level scaling to player level
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL);
        assertEquals(DEFAULT_RACE, character.getRace());
        assertEquals(DEFAULT_LEVEL, character.getLevel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testLevelBelowOneThrowsIAE() {
        new Character(DEFAULT_RACE, -1);
    }

}