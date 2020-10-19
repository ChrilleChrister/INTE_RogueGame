package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterSlayingObjectiveTest {
    private static final String DEFAULT_MONSTER_TYPE = "Wolf"; // Refactor to Race instead, include level range(?)
    private static final int DEFAULT_NUMBER_TO_SLAY = 5;

    @Test
    public void testMonsterSlayingObjectiveCtrSetsAttributes() {
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_MONSTER_TYPE, DEFAULT_NUMBER_TO_SLAY);
        assertEquals(DEFAULT_MONSTER_TYPE, objective.getMonsterType());
        assertEquals(DEFAULT_NUMBER_TO_SLAY, objective.getNumberToSlay());
        assertEquals(0, objective.getNumberSlain());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMonsterSlayingObjectiveCtrThrowsIAEIfNumberToSlayIsLessThanOne() {
        new MonsterSlayingObjective(DEFAULT_MONSTER_TYPE, -1);
    }

    @Test
    public void testMonsterTypeCanNotBeNull() {
        // Maybe?
    }

    @Test
    public void testIncrementNumberSlain() {
        // abstrakt metod i questobjective? objective.progress()?
    }

}