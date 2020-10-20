package se.su.dsv.inte.quest;

import org.junit.Test;
import se.su.dsv.inte.quest.MonsterSlayingObjective;
import se.su.dsv.inte.quest.QuestObjective;

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
    public void testStatusMessageIsEmptyForNewQuest() {
        QuestObjective objective = new MonsterSlayingObjective(DEFAULT_MONSTER_TYPE, DEFAULT_NUMBER_TO_SLAY);
        assertEquals("0/5 Wolf slain", objective.getStatusMessage());
    }

    @Test
    public void testIncrementNumberSlainUpdatedNumberSlainByOne() {
        // should ideally be tested in combat context; testMonsterSlayedIncrementsNumberSlain
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_MONSTER_TYPE, DEFAULT_NUMBER_TO_SLAY);
        objective.incrementNumberSlain();
        assertEquals(1, objective.getNumberSlain());
    }

    @Test
    public void testNumberSlainStopsCountingAfterNumberToSlayIsReached() {
        MonsterSlayingObjective objective = new MonsterSlayingObjective(DEFAULT_MONSTER_TYPE, DEFAULT_NUMBER_TO_SLAY);
        for (int i = 0; i < DEFAULT_NUMBER_TO_SLAY + 1; i++)
            objective.incrementNumberSlain();
        assertEquals(DEFAULT_NUMBER_TO_SLAY, objective.getNumberSlain());
    }
//
//    @Test
//    public void testMonsterTypeCanNotBeNull() {
//        // Maybe?
//    }
//
//    @Test
//    public void testIncrementNumberSlain() {
//        // abstrakt metod i questobjective? objective.progress()?
//    }

}