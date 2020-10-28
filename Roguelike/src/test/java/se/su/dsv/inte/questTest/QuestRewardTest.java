package se.su.dsv.inte.questTest;

import org.junit.Test;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Race;
import se.su.dsv.inte.quest.QuestReward;

import static org.junit.Assert.*;

public class QuestRewardTest {
    private static final int DEFAULT_QUEST_XP = 300;

    @Test
    public void testCreationOfQuestRewardThatOnlyGivesXP() {
        QuestReward reward = new QuestReward(DEFAULT_QUEST_XP);
        assertEquals(DEFAULT_QUEST_XP, reward.getCompletionXP());
    }

    // test quest reward scaling to optional objectives

    // test quest reward can have item

}