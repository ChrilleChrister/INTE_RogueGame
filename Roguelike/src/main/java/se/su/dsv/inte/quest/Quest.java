package se.su.dsv.inte.quest;

public class Quest {
    private final String title;
    private final String description;
    private final int requiredLevel;
    private final QuestReward reward;
    private final QuestObjective[] objectives;

    public Quest(String title, String description, int requiredLevel, QuestReward reward, QuestObjective... objectives) {
        if (!isValid(objectives))
            throw new IllegalArgumentException("Quest can not contain null objectives, and must contain at least " +
                    "one mandatory objective");
        if (title == null || description == null || reward == null || requiredLevel < 1  || requiredLevel > 100)
            throw new IllegalArgumentException("Parameters can not be null. Level must be in range 1 - 100");

        this.title = title;
        this.description = description;
        this.requiredLevel = requiredLevel;
        this.reward = reward;
        this.objectives = objectives;
    }

    /**
     * Controls if an objective array only contains non-null objectives, and that at least one mandatory objective exists.
     * @param objectives the array to validate.
     * @return true if the array does not contain null objects, and at least one objective is mandatory.
     */
    private boolean isValid(QuestObjective[] objectives) {
        if (objectives.length < 1)
            return false;

        boolean containsMandatoryObjective = false;
        for (QuestObjective q : objectives) {
            if (q == null)
                return false;
            if (!q.isOptional())
                containsMandatoryObjective = true;
        }

        return containsMandatoryObjective;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public QuestReward getReward() {
        return reward;
    }

    public QuestObjective[] getObjectives() {
        return objectives;
    }

    public boolean isComplete() {
        for (QuestObjective o : objectives)
            if (!o.isOptional() && !o.isComplete())
                return false;

        return true;
    }

}
