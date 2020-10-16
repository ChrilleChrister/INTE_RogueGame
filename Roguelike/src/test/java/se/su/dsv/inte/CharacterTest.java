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
        Character character = new Character(DEFAULT_RACE, DEFAULT_LEVEL);
        assertEquals(DEFAULT_RACE, character.getRace());
        assertEquals(DEFAULT_LEVEL, character.getLevel());
    }

    @Test
    public void tests() {
        // Test character level scaling to player level
    }

}