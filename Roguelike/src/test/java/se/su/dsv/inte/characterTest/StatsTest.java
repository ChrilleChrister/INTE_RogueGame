package se.su.dsv.inte.characterTest;

import org.junit.Test;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.character.Stats;

import static org.junit.Assert.*;

public class StatsTest {

    @Test
    public void testStatsCtrSetsAttributesToBaseValuesForLevelOne() {
        Stats stats = new Stats(Race.HOBBIT, 1);
        assertEquals(stats.getBaseHitPoints(), Race.HOBBIT.getBaseHitPoints());
        assertEquals(stats.getBaseDefensePoints(), Race.HOBBIT.getBaseDefensePoints());
        assertEquals(stats.getBaseAttackPoints(), Race.HOBBIT.getBaseAttackPoints());
    }

    @Test
    public void testStatsCtrScalesAttributesToLevel() {
        Stats stats = new Stats(Race.HOBBIT, 5);
        assertEquals(40, stats.getBaseHitPoints());
        assertEquals(10, stats.getBaseAttackPoints());
        assertEquals(12, stats.getBaseDefensePoints());
    }
}
