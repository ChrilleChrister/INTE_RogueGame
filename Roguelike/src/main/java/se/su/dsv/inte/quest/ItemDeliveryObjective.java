package se.su.dsv.inte.quest;

import se.su.dsv.inte.item.Item;

public class ItemDeliveryObjective extends QuestObjective {
    private final Item item;
    private final String recipientName;
    private boolean delivered;
    private boolean itemAcquired;

    public ItemDeliveryObjective(boolean optional, Item item, String recipientName) {
        super(optional);
        if (item == null)
            throw new IllegalArgumentException("Item to deliver can not be null");
        // Could possinly check that the character exists at all(?) with static list, add each new character created
        if (recipientName == null)
            throw new IllegalArgumentException("Recipient name can not be null");
        this.item = item;
        this.recipientName = recipientName;
    }

    public Item getDeliveryItem() {
        return item;
    }

    public String getRecipientName() {
        return recipientName;
    }

    @Override
    protected String getStatus() {
        return null;
    }

    @Override
    public boolean isComplete() {
        return delivered;
    }
}
