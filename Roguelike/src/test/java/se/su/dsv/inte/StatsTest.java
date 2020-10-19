package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatsTest {

    @Test
    public void testStatsCtrSetsAttributesToBaseValuesForLevelOne() {
        Stats stats = new Stats(Race.HOBBIT, 1);
        assertEquals(stats.getHitPoints(), Race.HOBBIT.getBaseHitPoints());
        assertEquals(stats.getDefensePoints(), Race.HOBBIT.getBaseDefensePoints());
        assertEquals(stats.getAttackPoints(), Race.HOBBIT.getBaseAttackPoints());
    }

}
