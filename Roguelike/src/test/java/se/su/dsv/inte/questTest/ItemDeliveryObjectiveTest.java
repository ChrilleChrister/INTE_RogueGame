package se.su.dsv.inte.questTest;

import org.junit.Test;
import se.su.dsv.inte.quest.ItemDeliveryObjective;

import static org.junit.Assert.*;

public class ItemDeliveryObjectiveTest {
    private static final String DEFAULT_ITEM_NAME = "Wizard Potion";
    private static final String DEFAULT_RECIPIENT_NAME = "Gandalf";
    private static final boolean DEFAULT_OPTIONAL = false;

    @Test
    public void testGatherObjectiveCtrSetsAttributes() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM_NAME, DEFAULT_RECIPIENT_NAME);
        assertEquals(DEFAULT_ITEM_NAME, objective.getDeliveryItemName());
        assertEquals(DEFAULT_RECIPIENT_NAME, objective.getRecipientName());
        assertEquals(DEFAULT_OPTIONAL, objective.isOptional());
    }



    // isComplete could consist of two parts: itemAcquired && isDelivered - the quest giver/turn in could be
    // someone other than the recipient (when isDelivered is set true, entire objective is marked complete. status
    // message should then change)

    // test ctr throws iae if duplicate items is passed

    // test give only one item if item can stack (e.g. consumable)

    // test creating a new objective when player already has the item to be gathered
    // check that itemAcquired is immediately marked as true
}
