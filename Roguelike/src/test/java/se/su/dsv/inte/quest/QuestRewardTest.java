package se.su.dsv.inte.quest;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuestRewardTest {
    private static final int DEFAULT_QUEST_XP = 300;

    @Test
    public void testCreationOfQuestRewardThatOnlyGivesXP() {
        QuestReward reward = new QuestReward(DEFAULT_QUEST_XP);
        assertEquals(DEFAULT_QUEST_XP, reward.getCompletionXP());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testQuestRewardCanNotHaveNegativeXP() {
        new QuestReward(-1);
    }

    @Test
    public void testQuestRewardsWithSameXPAreEqual() {
        assertEquals(new QuestReward(DEFAULT_QUEST_XP), new QuestReward(DEFAULT_QUEST_XP));
    }

    @Test
    public void testQuestRewardsWithDifferentXPIsNotEqual() {
        assertNotEquals(new QuestReward(100), (new QuestReward(200)));
    }

    @Test
    public void testQuestRewardIsNotEqualToOtherClass() {
        assertNotEquals(new QuestReward(DEFAULT_QUEST_XP), new Object());
    }
    // test quest reward scaling to optional objectives

    // test quest reward can have item

}