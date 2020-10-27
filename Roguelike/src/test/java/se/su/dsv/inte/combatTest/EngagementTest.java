package se.su.dsv.inte.combatTest;

import org.junit.Test;

import se.su.dsv.inte.character.EnemyCharacter;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.combat.Engagement;

import static org.junit.Assert.*;

import org.junit.Before;

public class EngagementTest {

    private static final PlayerCharacter DEFAULT_PLAYER = new PlayerCharacter(Race.HOBBIT, "DefaultPlayer");
    private static final EnemyCharacter DEFAULT_ENEMY = new EnemyCharacter(Race.DWARF, 1, 3);
    private static final Engagement DEFAULT_ENGAGEMENT = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY);
    private static final double MAX_HIT_CHANCE = 1;
    private static final double MIN_HIT_CHANCE = 0;
    private static final int DEFAULT_DAMAGE_AMOUNT = 5;
    private static final int ZERO_HEALTH = 0;
    private PlayerCharacter freshPlayer;
    private static final int MAX_STUN_TIME = 2;
    private static final int DECREASED_STUN_TIME = 1;
    private static final boolean TAUNTED = true;
    private static final boolean NOT_TAUNTED = false;

    @Before public void initialize(){
        freshPlayer = new PlayerCharacter(Race.HOBBIT, "DefaultPlayer");
    }

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
        DEFAULT_ENGAGEMENT.attack(DEFAULT_ENEMY.getStats(), freshPlayer, MAX_HIT_CHANCE);
        assertNotEquals(freshPlayer.getStats().getBaseHitPoints(), freshPlayer.getCurrentHitpoints());
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

    @Test
    public void testApplyDamageDealsDamage(){
        DEFAULT_ENGAGEMENT.applyDamage(freshPlayer, DEFAULT_DAMAGE_AMOUNT);
        assertEquals(freshPlayer.getStats().getBaseHitPoints() - DEFAULT_DAMAGE_AMOUNT, freshPlayer.getCurrentHitpoints());
    }

    //This test succeeds because this is implemented in character
    @Test
    public void testApplyDamageSetsCurrentHitpointsToZeroIfDamageIsMoreThanCurrentHitpoints(){
        DEFAULT_ENGAGEMENT.applyDamage(freshPlayer, freshPlayer.getCurrentHitpoints()+1);
        assertEquals(ZERO_HEALTH, freshPlayer.getCurrentHitpoints());
    }

    @Test
    public void testKillingBlowKillsTarget(){
        DEFAULT_ENGAGEMENT.applyDamage(freshPlayer, freshPlayer.getCurrentHitpoints()+1);
        assertEquals(false, freshPlayer.isAlive());
    }

    @Test
    public void testStunGivesTurnHolderTwoMoreTurns(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_PLAYER);
        DEFAULT_ENGAGEMENT.stun(DEFAULT_ENEMY, MAX_HIT_CHANCE);
        DEFAULT_ENGAGEMENT.swapTurns();
        assertEquals(DEFAULT_PLAYER, DEFAULT_ENGAGEMENT.getTurnHolder());
    }

    @Test
    public void testSwapTurnsDoesntSwapStunnedCharacter(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.setTurnSitter(DEFAULT_PLAYER);
        DEFAULT_ENGAGEMENT.stun(DEFAULT_PLAYER, MAX_HIT_CHANCE);
        DEFAULT_ENGAGEMENT.swapTurns();
        assertEquals(DEFAULT_ENEMY, DEFAULT_ENGAGEMENT.getTurnHolder());
        assertEquals(DEFAULT_PLAYER, DEFAULT_ENGAGEMENT.getTurnSitter());
    }

    @Test
    public void testSwapTurnsDecreasesStunTimeForStunnerCharacter(){
        freshPlayer.setStunned();
        DEFAULT_ENGAGEMENT.setTurnSitter(freshPlayer);
        DEFAULT_ENGAGEMENT.swapTurns();
        assertEquals(DECREASED_STUN_TIME, freshPlayer.getStunTime());
    }

    @Test
    public void testTauntsetsCharacterToTaunted(){
        DEFAULT_ENGAGEMENT.taunt(freshPlayer);
        assertEquals(TAUNTED, freshPlayer.isTaunted());
    }

    @Test
    public void testPlayerCantEscapeWhenTaunted(){} //implement after escape is implemented

    @Test
    public void testTauntSwapsTurnHolder(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.setTurnSitter(freshPlayer);
        DEFAULT_ENGAGEMENT.taunt(freshPlayer);
        assertEquals(freshPlayer, DEFAULT_ENGAGEMENT.getTurnHolder());
    }

}
