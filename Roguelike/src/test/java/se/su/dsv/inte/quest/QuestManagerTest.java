package se.su.dsv.inte.quest;

import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;

import static org.junit.Assert.*;

public class QuestManagerTest {

    @Test
    public void testNewPlayerCharacterHasEmptyQuestManager() {
        PlayerCharacter player = new PlayerCharacter(Race.HOBBIT, "Player");
        assertNotNull(player.getQuestManager());
    }

}