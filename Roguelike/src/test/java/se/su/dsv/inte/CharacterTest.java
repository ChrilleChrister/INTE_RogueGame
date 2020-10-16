package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class CharacterTest {

    @Test
    public void testConstructor() {
        Character character = new Character("Hobbit");
        assertEquals("Hobbit", character.getRace());
    }

}