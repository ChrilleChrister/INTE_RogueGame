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

    @Test
    //TileType ska tas in, ej implementerat i denna branch ännu
    public void testCtrSetsAttributes(){
        Engagement engagement = new Engagement(DEFAULT_PLAYER, DEFAULT_ENEMY); //Ambush, borde first turn avgöras i konstruktor?
        assertEquals(DEFAULT_PLAYER, engagement.getPlayer());
        assertEquals(DEFAULT_ENEMY, engagement.getEnemy());
    }

    @Test
    public void startEngagemet(){
        
    }
}
