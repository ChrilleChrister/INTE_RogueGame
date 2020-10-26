package se.su.dsv.inte.combatTest;

import org.junit.Test;

import se.su.dsv.inte.character.EnemyCharacter;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.combat.Engagement;

import static org.junit.Assert.*;

public class EngagementTest {

    private final PlayerCharacter DEFAULT_PLAYER = new PlayerCharacter(Race.HOBBIT, "DefaultPlayer");
    private final EnemyCharacter DEFAULT_ENEMY = new EnemyCharacter(Race.DWARF, 1, 3);
    private final Engagement DEFAULT_ENGAGEMENT = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY);
    private final double MAX_HIT_CHANCE = 1;
    private final double MIN_HIT_CHANCE = 0;

    @Test
    //TileType ska tas in, ej implementerat i denna branch ännu
    public void testCtrSetsAttributes(){
        Engagement engagement = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY); //Ambush, borde first turn avgöras i konstruktor?
        assertEquals(DEFAULT_PLAYER, engagement.getPlayer());
        assertEquals(DEFAULT_ENEMY, engagement.getEnemy());
    }

    @Test
    public void testStartEngagementGivesFirstStrikeToCorrectCharacter(){
        DEFAULT_ENGAGEMENT.startEngagement(DEFAULT_ENEMY, DEFAULT_PLAYER, DEFAULT_ENEMY); // (enemy, player, firstStriker)
        assertEquals(DEFAULT_ENEMY, DEFAULT_ENGAGEMENT.getTurnHolder());
        assertEquals(DEFAULT_PLAYER, DEFAULT_ENGAGEMENT.getTurnSitter());
    }

    @Test
    public void testNormalAttackDamagesEnemy(){
        DEFAULT_ENGAGEMENT.attack(DEFAULT_ENEMY.getStats(), DEFAULT_PLAYER, MAX_HIT_CHANCE);
        assertNotEquals(DEFAULT_PLAYER.getStats().getBaseHitPoints(), DEFAULT_PLAYER.getCurrentHitpoints());
    }

    @Test
    public void testNormalAttackWithZeroHitChanceMiss(){
        DEFAULT_ENGAGEMENT.attack(DEFAULT_ENEMY.getStats(), DEFAULT_PLAYER, MIN_HIT_CHANCE);
        assertEquals(DEFAULT_PLAYER.getStats().getBaseHitPoints(), DEFAULT_PLAYER.getCurrentHitpoints());
    }

    @Test
    public void testNormalAttackChangesTurnholderAndTurnSitter(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.setTurnSitter(DEFAULT_PLAYER);
        DEFAULT_ENGAGEMENT.attack(DEFAULT_ENEMY.getStats(), DEFAULT_PLAYER, MIN_HIT_CHANCE);
        assertEquals(DEFAULT_PLAYER, DEFAULT_ENGAGEMENT.getTurnHolder());
        assertEquals(DEFAULT_ENEMY, DEFAULT_ENGAGEMENT.getTurnSitter());
    }

    @Test
    public void testSwapTurnHolderAndTurnSitter(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.setTurnSitter(DEFAULT_PLAYER);
        DEFAULT_ENGAGEMENT.swapTurns();
        assertEquals(DEFAULT_PLAYER, DEFAULT_ENGAGEMENT.getTurnHolder());
        assertEquals(DEFAULT_ENEMY, DEFAULT_ENGAGEMENT.getTurnSitter());
    }
}
