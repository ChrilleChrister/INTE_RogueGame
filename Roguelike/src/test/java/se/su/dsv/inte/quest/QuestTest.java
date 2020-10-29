package se.su.dsv.inte.quest;

import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.item.Consumable;

import static org.junit.Assert.*;

public class QuestTest {
    private static final String DEFAULT_TITLE = "Title";
    private static final String DEFAULT_DESCRIPTION = "Description";
    private static final int DEFAULT_REQUIRED_LEVEL = 1;

    private static final QuestObjective DEFAULT_OBJECTIVE =
            new MonsterSlayingObjective(false, "Wolf", 5);
    private static final QuestReward DEFAULT_REWARD = new QuestReward(300);

    @Test
    public void testCreateQuestWithSingleObjective() {
        Quest quest = new Quest(DEFAULT_TITLE, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL,
                DEFAULT_REWARD, DEFAULT_OBJECTIVE);
        assertEquals(DEFAULT_TITLE, quest.getTitle());
        assertEquals(DEFAULT_DESCRIPTION, quest.getDescription());
        assertEquals(DEFAULT_REQUIRED_LEVEL, quest.getRequiredLevel());
        assertEquals(DEFAULT_REWARD, quest.getReward());
        assertArrayEquals(new QuestObjective[] {DEFAULT_OBJECTIVE}, quest.getObjectives());
    }

    // Test checking that title, description and reward can not be null. Also check that required level is in range
    // 1 - 100.
    @Test (expected = IllegalArgumentException.class)
    public void testNullTitleThrowsIAE() {
        new Quest(null, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL, DEFAULT_REWARD, DEFAULT_OBJECTIVE);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testQuestCtrThrowsIAEIfNumberOfObjectivesIsZero() {
        QuestObjective[] objectives = {};
        new Quest(DEFAULT_TITLE, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL, DEFAULT_REWARD, objectives);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testQuestCtrThrowsIAEIfObjectivesContainNullValue() {
        QuestObjective[] objectives = {DEFAULT_OBJECTIVE, null};
        new Quest(DEFAULT_TITLE, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL, DEFAULT_REWARD, objectives);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testQuestCtrThrowsIAEIfNoMandatoryObjectiveExists() {
        ItemDeliveryObjective optionalObjective = new ItemDeliveryObjective(true,
                new Consumable("Potion"), "Gandalf");
        new Quest(DEFAULT_TITLE, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL, DEFAULT_REWARD, optionalObjective);
    }

    @Test
    public void testQuestIsCompleteIfAllMandatoryObjectivesAreComplete() {
        MonsterSlayingObjective o1 = new MonsterSlayingObjective(false, "Dragon", 1);
        ItemDeliveryObjective o2 = new ItemDeliveryObjective(false, new Consumable("Potion"), "Gandalf");
        QuestObjective[] mandatoryObjectives = {o1, o2};
        Quest quest = new Quest(DEFAULT_TITLE, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL, DEFAULT_REWARD, mandatoryObjectives);

        assertFalse(quest.isComplete());
        o1.incrementNumberSlain();
        o2.setItemAcquired(true);
        o2.setDelivered(true);
        assertTrue(quest.isComplete());
    }

    @Test
    public void testQuestsWithIdenticalAttributesAreEqual() {
        Quest q1 = new Quest("Title", "Description", 1,
                new QuestReward(100),
                new ItemDeliveryObjective(false, new Consumable("Potion"), "Gandalf"));

        Quest q2 = new Quest("Title", "Description", 1,
                new QuestReward(100),
                new ItemDeliveryObjective(false, new Consumable("Potion"), "Gandalf"));

        assertEquals(q1, q2);
    }

    @Test
    public void testQuestIsNotEqualToOtherClass() {
        assertNotEquals(new Quest(DEFAULT_TITLE, DEFAULT_DESCRIPTION, DEFAULT_REQUIRED_LEVEL, DEFAULT_REWARD, DEFAULT_OBJECTIVE),
                new Object());
    }
}