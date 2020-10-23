package se.su.dsv.inte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnemyCharacterTest {

    private final Race DEFAULT_RACE = Race.HOBBIT;
    private final int DEFAULT_LEVEL = 1;
    private final int DEFAULT_AGGRESSIVE_RANGE = 5;
    private final int NEGATIVE_AGGRESSIVE_RANGE = -1;
    private final int ABOVE_MAX_AGGRESSIVE_RANGE = 50;
    private final int LOWER_BOUNDARY_VALUE_AGGRESSIVE_RANGE = 0;
    private final int HIGHER_BOUNDARY_VALUE_AGGRESSIVE_RANGE = 40;
    private final String DEFAULT_NAME = "Angry Hobbit";

    @Test
    public void testCtrSetsAttributes(){
        EnemyCharacter enemyCharacter = new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, DEFAULT_AGGRESSIVE_RANGE);
        assertEquals(Race.HOBBIT, enemyCharacter.getRace());
        assertEquals(DEFAULT_LEVEL, enemyCharacter.getLevel());
        assertEquals(DEFAULT_AGGRESSIVE_RANGE, enemyCharacter.getAggressiveRange());
        assertEquals(DEFAULT_NAME, enemyCharacter.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAggressiveRangeBelowZeroThrowsIAE(){
        new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, NEGATIVE_AGGRESSIVE_RANGE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAggressiveRangeAbove40(){
        new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, ABOVE_MAX_AGGRESSIVE_RANGE);
    }

    @Test
    public void testAggressiveRangeLowerBoundaryIsIncluded(){
        EnemyCharacter enemyCharacter = new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, LOWER_BOUNDARY_VALUE_AGGRESSIVE_RANGE);
        assertEquals(LOWER_BOUNDARY_VALUE_AGGRESSIVE_RANGE, enemyCharacter.getAggressiveRange());
    }

    @Test
    public void testAggressiveRangeHigherBoundaryIsIncluded(){
        EnemyCharacter enemyCharacter = new EnemyCharacter(DEFAULT_RACE, DEFAULT_LEVEL, HIGHER_BOUNDARY_VALUE_AGGRESSIVE_RANGE);
        assertEquals(HIGHER_BOUNDARY_VALUE_AGGRESSIVE_RANGE, enemyCharacter.getAggressiveRange());
    }
    
}
