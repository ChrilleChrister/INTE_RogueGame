package se.su.dsv.inte.quest;

import org.junit.Before;
import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;

import static org.junit.Assert.*;

public class QuestManagerTest {
    private PlayerCharacter player;
    private Quest levelOneQuest;
    private Quest levelTwoQuest;

    @Before
    public void createNewCharacterAndQuests() {
        player = new PlayerCharacter(Race.HOBBIT, "Player One");

        levelOneQuest = new Quest("Level one quest", "Description for level one quest", 1,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));

        levelTwoQuest = new Quest("Level two quest", "Description for level two quest", 2,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));
    }

    @Test
    public void testNewPlayerCharacterHasEmptyQuestManager() {
        assertNotNull(player.getQuestManager());
        assertEquals(0, player.getQuestManager().getNumberOfActiveQuests());
    }

    @Test
    public void testStartingNewQuestAddsQuestToBeTracked() {
        assertTrue(player.getQuestManager().startQuest(levelOneQuest));
        assertTrue(player.getQuestManager().getActiveQuests().contains(levelOneQuest));
    }

    @Test
    public void testQuestCanNotBeStartedIfPlayerIsNotRequiredLevel() {
        assertFalse(player.getQuestManager().startQuest(levelTwoQuest));
    }

    @Test
    public void testQuestManagerRecordsEnemySlainAndUpdatesObjective() {
        player.getQuestManager().startQuest(levelOneQuest);
        assertFalse(levelOneQuest.isComplete());
        player.getQuestManager().recordEnemySlain("Dragon");
        assertTrue(levelOneQuest.isComplete());
    }


}