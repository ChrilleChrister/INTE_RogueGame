package se.su.dsv.inte.quest;

public class ItemDeliveryObjective extends QuestObjective {
    private final String itemName;
    private final String recipientName;

    public ItemDeliveryObjective(boolean optional, String itemName, String recipientName) {
        super(optional);
        this.itemName = itemName;
        this.recipientName = recipientName;
    }

    public String getDeliveryItemName() {
        return itemName;
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
        return false;
    }
}
