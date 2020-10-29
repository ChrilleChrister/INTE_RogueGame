package se.su.dsv.inte.combatTest;

import org.junit.Test;

import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.EnemyCharacter;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.combat.Engagement;
import se.su.dsv.inte.item.Weapon;
import se.su.dsv.inte.item.WeaponType;

import static org.junit.Assert.*;

import org.junit.Before;

public class EngagementTest {

    private static final PlayerCharacter DEFAULT_PLAYER = new PlayerCharacter(Race.HOBBIT, "DefaultPlayer");
    private static final EnemyCharacter DEFAULT_ENEMY = new EnemyCharacter(Race.DWARF, 1, 3);
    private static final Engagement DEFAULT_ENGAGEMENT = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY, DEFAULT_ENEMY);
    private static final double MAX_HIT_CHANCE = 1;
    private static final double MIN_HIT_CHANCE = 0;
    private static final int DEFAULT_DAMAGE_AMOUNT = 5;
    private static final int ZERO_HEALTH = 0;
    private static final int DECREASED_STUN_TIME = 1;
    private static final double MAX_ESCAPE_CHANCE = 1;
    private static final double ZERO_ESCAPE_CHANCE = 0;
    private static final int NOT_TAUNTED = 0;
    private static final int MAX_TAUNT_TIME = 2;
    private static final int DECREASED_TAUNT_TIME = 1;

    private PlayerCharacter freshPlayer;
    private Engagement freshEngagement;

    @Before public void initialize(){
        freshPlayer = new PlayerCharacter(Race.HOBBIT, "DefaultPlayer");
        freshEngagement = new Engagement(freshPlayer, DEFAULT_ENEMY, DEFAULT_ENEMY);
    }

    @Test
    //Implement tiletype
    public void testCtrSetsAttributesWhenEnemyIsFirstStriker(){
        Engagement engagement = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY, DEFAULT_ENEMY);
        assertEquals(DEFAULT_PLAYER, engagement.getPlayer());
        assertEquals(DEFAULT_ENEMY, engagement.getEnemy());
        assertEquals(true, engagement.isActive());
        assertEquals(DEFAULT_ENEMY, engagement.getTurnHolder());
        assertEquals(DEFAULT_PLAYER, engagement.getTurnSitter());
    }

    @Test
    public void testCtrSetsAttributesWhenPlayerIsFirstStriker(){
        Engagement engagement = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY, DEFAULT_PLAYER);
        assertEquals(DEFAULT_PLAYER, engagement.getPlayer());
        assertEquals(DEFAULT_ENEMY, engagement.getEnemy());
        assertEquals(true, engagement.isActive());
        assertEquals(DEFAULT_PLAYER, engagement.getTurnHolder());
        assertEquals(DEFAULT_ENEMY, engagement.getTurnSitter());
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
        assertEquals(MAX_TAUNT_TIME, freshPlayer.getTauntTime());
    }

    @Test
    public void testTauntSwapsTurnHolder(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.setTurnSitter(freshPlayer);
        DEFAULT_ENGAGEMENT.taunt(freshPlayer);
        assertEquals(freshPlayer, DEFAULT_ENGAGEMENT.getTurnHolder());
    }

    @Test
    public void testPlayerCanEscape(){
        DEFAULT_ENGAGEMENT.escape(DEFAULT_PLAYER, MAX_ESCAPE_CHANCE);
        assertEquals(false, DEFAULT_ENGAGEMENT.isActive());
    }

    @Test
    public void testPlayerCantEscapeWhenTaunted(){
        freshPlayer.setTaunted();
        freshEngagement.escape(freshPlayer, MAX_ESCAPE_CHANCE);
        assertEquals(true, freshEngagement.isActive());
    }

    @Test
    public void testFailedEscapeSwapsTurnholder(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_PLAYER);
        DEFAULT_ENGAGEMENT.setTurnSitter(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.escape(DEFAULT_PLAYER, ZERO_ESCAPE_CHANCE);
        assertEquals(DEFAULT_ENEMY, DEFAULT_ENGAGEMENT.getTurnHolder());
    }

    @Test
    public void testPlayerIsOnlyTauntedOneTurn(){
        freshEngagement.taunt(DEFAULT_PLAYER);
        freshEngagement.attack(DEFAULT_PLAYER.getStats(), DEFAULT_ENEMY, MAX_HIT_CHANCE);
        assertEquals(NOT_TAUNTED, freshPlayer.getTauntTime());
    }

    @Test
    public void testTauntCanOnlyBeCastWhenEnemyTurn(){
        freshEngagement.setTurnHolder(freshPlayer);
        freshEngagement.taunt(freshPlayer);
        assertEquals(NOT_TAUNTED, freshPlayer.getTauntTime());
    }

    @Test
    public void testPlayerTauntTimeIsOneAfterTaunted(){
        freshEngagement.taunt(freshPlayer);
        assertEquals(DECREASED_TAUNT_TIME, freshPlayer.getTauntTime());
    }

    @Test
    public void testMissedStunSwapTurns(){
        DEFAULT_ENGAGEMENT.setTurnHolder(DEFAULT_ENEMY);
        DEFAULT_ENGAGEMENT.setTurnSitter(freshPlayer);
        DEFAULT_ENGAGEMENT.stun(freshPlayer, MIN_HIT_CHANCE);

        assertEquals(freshPlayer, DEFAULT_ENGAGEMENT.getTurnHolder());
    }

    //From state machine
    @Test
    public void testPlayerGetsFirstStrikeAndKillsEnemyInOneTurn(){
        int levelOne = 1;
        int agrFive = 5;
        int highAttackPoints = 100;
        PlayerCharacter player = new PlayerCharacter(Race.HOBBIT, "Player");
        Weapon oneHitWeapon = new Weapon("Axe", WeaponType.AXE, highAttackPoints);
        player.putItemInInventory(oneHitWeapon);
        player.equipItem(oneHitWeapon);
        EnemyCharacter enemy = new EnemyCharacter(Race.HOBBIT, levelOne, agrFive);
        Character firstStriker = player;
        Engagement engagement = new Engagement(player, enemy, firstStriker);
        engagement.attack(player.getStats(), enemy, MAX_HIT_CHANCE);

        assertFalse(enemy.isAlive());
    }
}