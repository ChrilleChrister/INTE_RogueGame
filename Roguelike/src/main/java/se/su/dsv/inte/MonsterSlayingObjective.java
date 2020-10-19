package se.su.dsv.inte;

public class MonsterSlayingObjective extends QuestObjective {
    private final String monsterType;
    private final int numberToSlay;
    private int numberSlain;

    public MonsterSlayingObjective(String monsterType, int numberToSlay) {
        if (numberToSlay < 1)
            throw new IllegalArgumentException("Number of monsters to slay can not be less than one");
        this.monsterType = monsterType;
        this.numberToSlay = numberToSlay;
    }

    public String getMonsterType() {
        return monsterType;
    }

    public int getNumberToSlay() {
        return numberToSlay;
    }

    public int getNumberSlain() {
        return numberSlain;
    }
}
