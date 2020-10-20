package se.su.dsv.inte.quest;

public abstract class QuestObjective {
    private final boolean optional;

    public QuestObjective(boolean optional) {
        this.optional = optional;
    }

    public boolean isOptional() {
        return optional;
    }

    public String getStatusMessage() {
        return optional ? "(Optional) " + getStatus() : getStatus();
    }

    protected abstract String getStatus();
}

