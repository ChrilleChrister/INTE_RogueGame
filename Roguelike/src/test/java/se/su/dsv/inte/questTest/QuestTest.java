package se.su.dsv.inte.questTest;

import org.junit.Test;
import se.su.dsv.inte.item.Consumable;
import se.su.dsv.inte.item.Weapon;
import se.su.dsv.inte.quest.*;

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
}