package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestObjectiveTest {
    @Test
    public void testCreateObjectiveToKillFiveWolves() {
        String enemyTypeName = "Wolf"; // Maybe split into race and level range
        int amountToKill = 5;
        KillTypeObjective objective = new KillTypeObjective(enemyTypeName, amountToKill);
        assertEquals(enemyTypeName, objective.getEnemyTypeName());
        assertEquals(amountToKill, objective.getAmountToKill());
    }

}