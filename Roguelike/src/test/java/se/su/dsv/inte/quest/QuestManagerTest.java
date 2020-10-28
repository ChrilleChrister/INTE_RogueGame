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
        assertEquals(0, player.getQuestManager().getNumberOfActiveQuests());
    }

    @Test
    public void testStartingNewQuestAddsQuestToBeTracked() {
        PlayerCharacter player = new PlayerCharacter(Race.HOBBIT, "Player");
        Quest quest = new Quest(
                "Title", "Description", 1,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));
        assertTrue(player.getQuestManager().startQuest(quest));
        assertTrue(player.getQuestManager().getActiveQuests().contains(quest));
    }

    @Test
    public void testQuestCanNotBeStartedIfPlayerIsNotRequiredLevel() {
        PlayerCharacter player = new PlayerCharacter(Race.HOBBIT, "Player");
        Quest quest = new Quest(
                "Title", "Description", 2,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));
        assertFalse(player.getQuestManager().startQuest(quest));
    }

}