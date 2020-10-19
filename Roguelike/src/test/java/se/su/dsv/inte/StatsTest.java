package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatsTest {

    @Test
    public void testStatsCtrSetsAttributes() {
        Stats stats = new Stats(30, 5, 5);
        assertEquals(30, stats.getHitPoints());
        assertEquals(5, stats.getAttackPoints());
        assertEquals(5, stats.getDefensePoints());
    }

//    @Test
//    public void testNewHobbitCharacterHasRaceDefaultStats() {
//        Character character = new Character(Race.HOBBIT, 1);
//        assertEquals(Race.HOBBIT.getDefaultStats(), character.getStats());
//    }

}
