package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class RaceTest {

    @Test
    public void testHobbitRace() {
        assertEquals("Hobbit", Race.HOBBIT.getName());
        assertEquals(5, Race.HOBBIT.getBaseMovementSpeed());
    }

    @Test
    public void testDwarfRace() {
        assertEquals("Dwarf", Race.DWARF.getName());
        assertEquals(3, Race.DWARF.getBaseMovementSpeed());
    }
}