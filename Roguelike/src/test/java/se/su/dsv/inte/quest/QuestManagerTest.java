package se.su.dsv.inte.quest;

import org.junit.Before;
import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.item.Consumable;
import se.su.dsv.inte.item.Item;

import static org.junit.Assert.*;

public class QuestManagerTest {
    private PlayerCharacter player;
    private Quest levelOneMonsterSlayingQuest;
    private Quest levelOneItemDeliveryQuest;
    private Quest levelTwoQuest;

    @Before
    public void createNewCharacterAndQuests() {
        player = new PlayerCharacter(Race.HOBBIT, "Player One");

        levelOneMonsterSlayingQuest =
                new Quest("Level one monster slaying quest", "Description for level one quest", 1,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));

        levelOneItemDeliveryQuest =
                new Quest("Level one item delivery quest", "Description for level one quest", 1,
                new QuestReward(300),
                new ItemDeliveryObjective(false, new Consumable("Potion"), "Gandalf"));

        levelTwoQuest = new Quest("Level two quest", "Description for level two quest", 2,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));
    }

    @Test (expected = NullPointerException.class)
    public void testPlayerCharacterCanNotStartNullQuest() {
        player.getQuestManager().startQuest(null);
    }

    @Test
    public void testPlayerCharacterCanNotStartAnActiveQuestAgain() {
        // Add quest first time
        assertTrue(player.getQuestManager().startQuest(levelOneItemDeliveryQuest));
        // Add quest second time, quest should not be added
        assertFalse(player.getQuestManager().startQuest(levelOneItemDeliveryQuest));
        assertEquals(1, player.getQuestManager().getNumberOfActiveQuests());
    }

    @Test
    public void testQuestCanNotBeStartedIfPlayerIsNotRequiredLevel() {
        assertFalse(player.getQuestManager().startQuest(levelTwoQuest));
    }

    @Test
    public void testNewPlayerCharacterHasEmptyQuestManager() {
        assertNotNull(player.getQuestManager());
        assertEquals(0, player.getQuestManager().getNumberOfActiveQuests());
    }

    @Test
    public void testStartingNewQuestAddsQuestToBeTracked() {
        assertTrue(player.getQuestManager().startQuest(levelOneMonsterSlayingQuest));
        assertTrue(player.getQuestManager().getActiveQuests().contains(levelOneMonsterSlayingQuest));
    }

    @Test
    public void testQuestManagerRecordsEnemySlainAndUpdatesObjective() {
        player.getQuestManager().startQuest(levelOneMonsterSlayingQuest);
        assertFalse(levelOneMonsterSlayingQuest.isComplete());
        player.getQuestManager().recordEnemySlain("Dragon");
        assertTrue(levelOneMonsterSlayingQuest.isComplete());
    }

    @Test
    public void testRecordUntrackedEnemySlainDoesNotUpdateOtherObjective() {
        player.getQuestManager().startQuest(levelOneMonsterSlayingQuest);
        player.getQuestManager().recordEnemySlain("Goat");
        assertFalse(levelOneMonsterSlayingQuest.isComplete());
    }

    @Test
    public void testRecordEnemySlainCanUpdateMoreThanOneObjectiveAtATime() {
        player.getQuestManager().startQuest(levelOneMonsterSlayingQuest);
        Quest anotherMonsterSlayingQuest = new Quest(
                "Another monster slaying quest", "Description", 1,
                new QuestReward(300),
                new MonsterSlayingObjective(false, "Dragon", 1));
        player.getQuestManager().startQuest(anotherMonsterSlayingQuest);

        assertFalse(levelOneMonsterSlayingQuest.isComplete());
        assertFalse(anotherMonsterSlayingQuest.isComplete());
        player.getQuestManager().recordEnemySlain("Dragon");
        assertTrue(levelOneMonsterSlayingQuest.isComplete());
        assertTrue(anotherMonsterSlayingQuest.isComplete());
    }

    @Test
    public void testStartingItemDeliveryQuestScansPlayerInventoryAndUpdatesObjectiveIfItemIsAcquired() {
        player.putItemInInventory(new Consumable("Potion"));
        player.getQuestManager().startQuest(levelOneItemDeliveryQuest);
        ItemDeliveryObjective objective = (ItemDeliveryObjective) levelOneItemDeliveryQuest.getObjectives()[0];
        assertTrue(objective.itemIsAcquired());
        assertFalse(objective.isComplete());
    }

    @Test
    public void testItemDeliveryObjectiveIsUpdatedWhenPlayerInventoryRecievesNewItem() {
        player.getQuestManager().startQuest(levelOneItemDeliveryQuest);
        ItemDeliveryObjective objective = (ItemDeliveryObjective) levelOneItemDeliveryQuest.getObjectives()[0];
        assertFalse(objective.itemIsAcquired());
        player.putItemInInventory(new Consumable("Potion"));
        assertTrue(objective.itemIsAcquired());
    }

    @Test
    public void testItemDeliveryObjectiveIsUpdatedWhenItemIsRemovedFromPlayerInventory() {
        Item item = new Consumable("Potion");
        player.putItemInInventory(item);
        player.getQuestManager().startQuest(levelOneItemDeliveryQuest);
        ItemDeliveryObjective objective = (ItemDeliveryObjective) levelOneItemDeliveryQuest.getObjectives()[0];
        assertTrue(objective.itemIsAcquired());
        player.removeItemFromInventory(item);
        assertFalse(objective.itemIsAcquired());
    }
}