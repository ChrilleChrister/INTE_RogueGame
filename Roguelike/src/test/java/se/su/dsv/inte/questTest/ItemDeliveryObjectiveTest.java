package se.su.dsv.inte.questTest;

import org.junit.Test;
import se.su.dsv.inte.item.Consumable;
import se.su.dsv.inte.item.Item;
import se.su.dsv.inte.quest.ItemDeliveryObjective;

import static org.junit.Assert.*;

public class ItemDeliveryObjectiveTest {
    private static final Item DEFAULT_ITEM = new Consumable("Wizard Potion");
    private static final String DEFAULT_RECIPIENT_NAME = "Gandalf";
    private static final boolean DEFAULT_OPTIONAL = false;

    @Test
    public void testGatherObjectiveCtrSetsAttributes() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        assertEquals(DEFAULT_ITEM, objective.getDeliveryItem());
        assertEquals(DEFAULT_RECIPIENT_NAME, objective.getRecipientName());
        assertEquals(DEFAULT_OPTIONAL, objective.isOptional());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testItemDeliveryObjectiveCtrThrowsIAEIfItemNameIsNull() {
        new ItemDeliveryObjective(DEFAULT_OPTIONAL, null, DEFAULT_RECIPIENT_NAME);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testItemDeliveryObjectiveCtrThrowsIAEIfRecipientNameIsNull() {
        new ItemDeliveryObjective(DEFAULT_OPTIONAL, DEFAULT_ITEM, null);
    }

    @Test
    public void testStatusMessageFormatWhenItemNotAcquiredAndNotDelivered() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        assertEquals("Find " + DEFAULT_ITEM.getName()
                + " for " + DEFAULT_RECIPIENT_NAME, objective.getStatusMessage());
    }

    @Test
    public void testStatusMessageFormatWhenItemAcquiredButNotDelivered() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        objective.setItemAcquired(true);
        assertEquals("Bring " + DEFAULT_ITEM.getName()
                + " to " + DEFAULT_RECIPIENT_NAME, objective.getStatusMessage());
    }

    @Test
    public void testStatusMessageFormatWhenItemHasBeenDelivered() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        objective.setDelivered(true);
        assertEquals(DEFAULT_ITEM.getName() + " was delivered to "
                + DEFAULT_RECIPIENT_NAME, objective.getStatusMessage());
    }


    // isComplete could consist of two parts: itemAcquired && isDelivered - the quest giver/turn in could be
    // someone other than the recipient (when isDelivered is set true, entire objective is marked complete. status
    // message should then change)

    // test give only one item if item can stack (e.g. consumable)
    // playerCharacter.giveItem(questItem, npc);
    /* giveItem(...) {
            for quest in quest log
                if objectives contain delivery quest with questItem and npc
                    mark complete;
                    removeItem(questItem);



        max num quests? abandon quests?
     */

    // test creating a new objective when player already has the item to be gathered
    // check that itemAcquired is immediately marked as true

    // maybe recipient could be changeable
}
