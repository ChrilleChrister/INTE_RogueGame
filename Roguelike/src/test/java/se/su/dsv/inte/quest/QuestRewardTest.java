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

    // test quest reward scaling to optional objectives

    // test quest reward can have item

}