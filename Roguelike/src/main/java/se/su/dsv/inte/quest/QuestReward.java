package se.su.dsv.inte.quest;

public class QuestReward {
    private int completionXP;

    public QuestReward(int completionXP) {
        if (completionXP < 0)
            throw new IllegalArgumentException("Reward can not be negative experience points");
        this.completionXP = completionXP;
    }

    public int getCompletionXP() {
        return completionXP;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof QuestReward) {
            QuestReward other = (QuestReward) object;
            return other.completionXP == completionXP;
        }

        return false;
    }
}
