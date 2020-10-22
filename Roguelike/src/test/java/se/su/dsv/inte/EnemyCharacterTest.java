package se.su.dsv.inte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnemyCharacterTest {

    private final Race DEFAULT_RACE = Race.HOBBIT;
    private final int DEFAULT_LEVEL = 1;
    private final int DEFAULT_AGGRESSIVE_RANGE = 5;
    private final int NEGATIVE_AGGRESSIVE_RANGE = -1;
    private final int ILLEGAL_HIGH_AGGRESSIVE_RANGE = 50;


    @Test
    public void testCtrSetsAttributes(){
        EnemyCharacter enemyCharacter = new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, DEFAULT_AGGRESSIVE_RANGE);
        assertEquals(Race.HOBBIT, enemyCharacter.getRace());
        assertEquals(DEFAULT_LEVEL, enemyCharacter.getLevel());
        assertEquals(DEFAULT_AGGRESSIVE_RANGE, enemyCharacter.getAggressiveRange());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAggressiveRangeBelowZeroThrowsIAE(){
        EnemyCharacter enemyCharacter = new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, NEGATIVE_AGGRESSIVE_RANGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAggressiveRangeAbove40(){
        EnemyCharacter enemyCharacter = new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, ILLEGAL_HIGH_AGGRESSIVE_RANGE);
    }
    
}
