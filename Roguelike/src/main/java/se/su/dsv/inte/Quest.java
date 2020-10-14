package se.su.dsv.inte;

public class Quest {
    String title;
    String questDescription;
    int requiredLevel;
    int maxLevel;
    // List<QuestObjective> objetives;
    QuestReward reward;


}

class QuestObjective {
    // Map<ObjectiveType, String> objectiveToDescription;

}

enum ObjectiveType {
    GATHER, KILL, EXPLORE
}

class QuestReward {
    int playerLevelOnCompletion;
    int experiencePoints;
    // List<Item> rewardItem;

    private void calculateExperiencePoints(int playerLevel) {}
}