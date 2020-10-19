package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCharacterTest {

    @Test
    public void testAddOneHundredXPToPlayer(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        assertEquals(0, playerCharacter.getXP());
        playerCharacter.addXP(100);
        assertEquals(100, playerCharacter.getXP());
    }


}