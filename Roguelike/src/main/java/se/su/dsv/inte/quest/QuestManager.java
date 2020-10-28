package se.su.dsv.inte.quest;

import se.su.dsv.inte.character.PlayerCharacter;

import java.util.*;

public class QuestManager {
    private final PlayerCharacter player;
    private final List<Quest> activeQuests = new ArrayList<>();

    public QuestManager(PlayerCharacter player) {
        this.player = player;
    }

    public int getNumberOfActiveQuests() {
        return activeQuests.size();
    }

    public boolean startQuest(Quest quest) {
        if (player.getLevel() < quest.getRequiredLevel())
            return false;

        activeQuests.add(quest);
        return true;
    }

    public List<Quest> getActiveQuests() {
        return new ArrayList<>(activeQuests);
    }

    public void recordEnemySlain(String enemyName) {
        for (Quest quest : activeQuests) {
            for (QuestObjective objective : quest.getObjectives()) {
                if (objective instanceof MonsterSlayingObjective) {
                    MonsterSlayingObjective slayingObjective = (MonsterSlayingObjective) objective;
                    if (slayingObjective.getMonsterName().equals(enemyName))
                        slayingObjective.incrementNumberSlain();
                }
            }
        }
    }
}
