package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class RaceTest {

    @Test
    public void testHobbitRace() {
        assertEquals("Hobbit", Race.HOBBIT.getName());
        assertEquals(5, Race.HOBBIT.getBaseMovementSpeed());
        assertEquals(20, Race.HOBBIT.getDefaultStats().getHitPoints());
        assertEquals(2, Race.HOBBIT.getDefaultStats().getAttackPoints());
        assertEquals(4, Race.HOBBIT.getDefaultStats().getDefensePoints());
    }

    @Test
    public void testDwarfRace() {
        assertEquals("Dwarf", Race.DWARF.getName());
        assertEquals(3, Race.DWARF.getBaseMovementSpeed());
        assertEquals(30, Race.DWARF.getDefaultStats().getHitPoints());
        assertEquals(5, Race.DWARF.getDefaultStats().getAttackPoints());
        assertEquals(3, Race.DWARF.getDefaultStats().getDefensePoints());
    }
}