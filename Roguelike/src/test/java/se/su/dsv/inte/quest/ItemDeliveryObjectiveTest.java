package se.su.dsv.inte.quest;

import org.junit.Test;
import se.su.dsv.inte.item.Consumable;
import se.su.dsv.inte.item.Item;

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
        objective.setItemAcquired(true);
        objective.setDelivered(true);
        assertEquals(DEFAULT_ITEM.getName() + " was delivered to "
                + DEFAULT_RECIPIENT_NAME, objective.getStatusMessage());
    }

    @Test
    public void testObjectiveIsCompleteAfterItemIsDelivered() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        assertFalse(objective.isComplete());
        objective.setItemAcquired(true);
        objective.setDelivered(true);
        assertTrue(objective.isComplete());
    }

    @Test (expected = IllegalStateException.class)
    public void testItemCanNotBeDeliveredIfItemIsNotAcquired() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        objective.setDelivered(true);
    }

    @Test (expected = IllegalStateException.class)
    public void testItemAcquiredCanNotBeSetToFalseIfItemHasAlreadyBeenDelivered() {
        ItemDeliveryObjective objective = new ItemDeliveryObjective(DEFAULT_OPTIONAL,
                DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME);
        objective.setItemAcquired(true);
        objective.setDelivered(true);
        objective.setItemAcquired(false);
    }

    @Test
    public void testObjectiveWithIdenticalAttributesAreEqual() {
        assertEquals(new ItemDeliveryObjective(DEFAULT_OPTIONAL, DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME),
                new ItemDeliveryObjective(DEFAULT_OPTIONAL, DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME));
    }

    @Test
    public void testObjectivesAreNotEqualIfAttributesDiffer() {
        ItemDeliveryObjective o1 = new ItemDeliveryObjective(DEFAULT_OPTIONAL, DEFAULT_ITEM, "Alice");
        ItemDeliveryObjective o2 = new ItemDeliveryObjective(DEFAULT_OPTIONAL, DEFAULT_ITEM, "Bob");
        assertNotEquals(o1, o2);
    }

    @Test
    public void testItemDeliveryObjectiveIsNotEqualToOtherClass() {
        assertNotEquals(new ItemDeliveryObjective(DEFAULT_OPTIONAL, DEFAULT_ITEM, DEFAULT_RECIPIENT_NAME),
                new Object());
    }
}
