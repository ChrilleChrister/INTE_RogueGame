package se.su.dsv.inte.quest;

import se.su.dsv.inte.character.PlayerCharacter;
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
        // Could possibly check that the character exists at all(?) with static list, add each new character created
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

    public void setItemAcquired(boolean itemAcquired) {
        if (!itemAcquired && delivered)
            throw new IllegalStateException("Item can not be marked un-acquired " +
                    "after it has been delivered");
        this.itemAcquired = itemAcquired;
    }

    public void setDelivered(boolean delivered) {
        if (!itemAcquired)
            throw new IllegalStateException("Item not yet acquired");
        this.delivered = delivered;
    }

    @Override
    protected String getStatus() {
        String msg;

        if (!itemAcquired && !delivered)
            msg = "Find " + item.getName() + " for " + recipientName;
        else if (itemAcquired && !delivered)
            msg = "Bring " + item.getName() + " to " + recipientName;
        else
            msg = item.getName() + " was delivered to " + recipientName;

        return msg;
    }

    @Override
    public boolean isComplete() {
        return delivered;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof ItemDeliveryObjective) {
            ItemDeliveryObjective other = (ItemDeliveryObjective) object;
            return other.item.equals(item) && other.recipientName.equals(recipientName) &&
                    other.itemAcquired == itemAcquired && other.delivered == delivered;
        }

        return false;
    }
}
