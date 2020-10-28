package se.su.dsv.inte.quest;

import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.item.Item;

import java.util.*;

public class QuestManager {
    private final PlayerCharacter player;
    private final List<Quest> activeQuests = new ArrayList<>();
    private HashMap<String, List<MonsterSlayingObjective>> enemyNamesToTrack = new HashMap<>();
    private HashMap<Item, List<ItemDeliveryObjective>> itemsToTrack = new HashMap<>();

    public QuestManager(PlayerCharacter player) {
        this.player = player;
    }

    public int getNumberOfActiveQuests() {
        return activeQuests.size();
    }

    public boolean startQuest(Quest quest) {
        if (player.getLevel() < quest.getRequiredLevel())
            return false;

        prepareQuestForTracking(quest);

        activeQuests.add(quest);
        return true;
    }

    public List<Quest> getActiveQuests() {
        return new ArrayList<>(activeQuests);
    }

    public void recordEnemySlain(String enemyName) {
        for (MonsterSlayingObjective o : enemyNamesToTrack.get(enemyName))
            o.incrementNumberSlain();
    }

    private void prepareQuestForTracking(Quest quest) {
        for (QuestObjective o : quest.getObjectives()) {
            if (o instanceof MonsterSlayingObjective) {
                MonsterSlayingObjective mso = (MonsterSlayingObjective) o;
                String monsterName = mso.getMonsterName();

                if (enemyNamesToTrack.get(monsterName) == null)
                    enemyNamesToTrack.put(monsterName, new ArrayList<MonsterSlayingObjective>());

                enemyNamesToTrack.get(monsterName).add(mso);
            } else if (o instanceof ItemDeliveryObjective) {
                ItemDeliveryObjective ido = (ItemDeliveryObjective) o;
                Item item = ido.getDeliveryItem();

                if (itemsToTrack.get(item) == null)
                    itemsToTrack.put(ido.getDeliveryItem(), new ArrayList<ItemDeliveryObjective>());

                itemsToTrack.get(item).add(ido);

                scanInventoryAndUpdateItemDeliveryObjective(ido.getDeliveryItem());
            }

        }
    }

    private void scanInventoryAndUpdateItemDeliveryObjective(Item item) {
        boolean itemAcquired = player.inventoryContains(item);

        for (ItemDeliveryObjective o : itemsToTrack.get(item))
            o.setItemAcquired(itemAcquired);
    }
}
