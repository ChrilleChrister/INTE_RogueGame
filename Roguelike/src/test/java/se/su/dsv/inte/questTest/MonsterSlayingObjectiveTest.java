package se.su.dsv.inte.questTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonsterSlayingObjectiveTest {
    private static final String DEFAULT_MONSTER_NAME = "Wolf";
    private static final int DEFAULT_NUMBER_TO_SLAY = 5;
    private static final boolean DEFAULT_OPTIONAL = false;

    @Test
    public void testMonsterSlayingObjectiveCtrSetsAttributes() {
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_OPTIONAL,
                DEFAULT_MONSTER_NAME, DEFAULT_NUMBER_TO_SLAY);
        assertEquals(DEFAULT_MONSTER_NAME, objective.getMonsterName());
        assertEquals(DEFAULT_NUMBER_TO_SLAY, objective.getNumberToSlay());
        assertEquals(0, objective.getNumberSlain());
        assertEquals(DEFAULT_OPTIONAL, objective.isOptional());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMonsterSlayingObjectiveCtrThrowsIAEIfNumberToSlayIsLessThanOne() {
        new MonsterSlayingObjective(DEFAULT_OPTIONAL, DEFAULT_MONSTER_NAME, -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testMonsterTypeCanNotBeNull() {
        new MonsterSlayingObjective(DEFAULT_OPTIONAL, null, DEFAULT_NUMBER_TO_SLAY);
    }

    @Test
    public void testStatusMessageFormatForNewObjective() {
        QuestObjective objective = new MonsterSlayingObjective(DEFAULT_OPTIONAL,
                DEFAULT_MONSTER_NAME, DEFAULT_NUMBER_TO_SLAY);
        assertEquals("0/5 Wolf slain", objective.getStatusMessage());
    }

    @Test
    public void testStatusMessageIncludesPrefixForOptionalObjective() {
        QuestObjective objective = new MonsterSlayingObjective(true,
                DEFAULT_MONSTER_NAME, DEFAULT_NUMBER_TO_SLAY);
        assertEquals("(Optional) 0/5 Wolf slain", objective.getStatusMessage());
    }

    @Test
    public void testIncrementNumberSlainUpdatedNumberSlainByOne() {
        // should ideally be tested in combat context; testMonsterSlayedIncrementsNumberSlain
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_OPTIONAL,
                DEFAULT_MONSTER_NAME, DEFAULT_NUMBER_TO_SLAY);
        objective.incrementNumberSlain();
        assertEquals(1, objective.getNumberSlain());
    }

    @Test
    public void testNumberSlainStopsCountingAfterNumberToSlayIsReached() {
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_OPTIONAL,
                DEFAULT_MONSTER_NAME, DEFAULT_NUMBER_TO_SLAY);
        for (int i = 0; i < DEFAULT_NUMBER_TO_SLAY + 1; i++)
            objective.incrementNumberSlain();
        assertEquals(DEFAULT_NUMBER_TO_SLAY, objective.getNumberSlain());
    }

    @Test
    public void testObjectiveIsCompleteAfterNumberToSlayIsReached() {
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_OPTIONAL,
                DEFAULT_MONSTER_NAME, DEFAULT_NUMBER_TO_SLAY);
        assertFalse(objective.isComplete());
        for (int i = 0; i < DEFAULT_NUMBER_TO_SLAY; i++)
            objective.incrementNumberSlain();
        assertTrue(objective.isComplete());
    }
}