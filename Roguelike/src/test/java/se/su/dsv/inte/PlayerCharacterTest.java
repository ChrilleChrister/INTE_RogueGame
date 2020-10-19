package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerCharacterTest {

    @Test // döp om mig
    public void testAddFiftyXPToPlayerLevelOne(){
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        assertEquals(0, playerCharacter.getXP());
        playerCharacter.addXP(50);
        assertEquals(1, playerCharacter.getLevel());
        assertEquals(50, playerCharacter.getXP());
    }

    @Test
    public void testAddExactAmountOfXPToLevelUp() {
        PlayerCharacter playerCharacter = new PlayerCharacter(Race.HOBBIT, "Player 1");
        playerCharacter.addXP(100);
        assertEquals(2, playerCharacter.getLevel());
        assertEquals(0, playerCharacter.getXP());
    }

    // level 2 levels at once

}