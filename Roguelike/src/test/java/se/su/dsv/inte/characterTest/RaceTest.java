package se.su.dsv.inte.characterTest;

import org.junit.Test;
import se.su.dsv.inte.character.Race;

import static org.junit.Assert.*;

public class RaceTest {

    @Test
    public void testHobbitRace() {
        assertEquals("Hobbit", Race.HOBBIT.getName());
        assertEquals(5, Race.HOBBIT.getBaseMovementSpeed());
        assertEquals(20, Race.HOBBIT.getBaseHitPoints());
        assertEquals(2, Race.HOBBIT.getBaseAttackPoints());
        assertEquals(4, Race.HOBBIT.getBaseDefensePoints());
    }

    @Test
    public void testDwarfRace() {
        assertEquals("Dwarf", Race.DWARF.getName());
        assertEquals(3, Race.DWARF.getBaseMovementSpeed());
        assertEquals(30, Race.DWARF.getBaseHitPoints());
        assertEquals(5, Race.DWARF.getBaseAttackPoints());
        assertEquals(3, Race.DWARF.getBaseDefensePoints());
    }
}