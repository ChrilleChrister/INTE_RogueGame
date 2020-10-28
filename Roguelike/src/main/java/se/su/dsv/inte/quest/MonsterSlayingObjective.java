package se.su.dsv.inte.quest;

public class MonsterSlayingObjective extends QuestObjective {
    private final String monsterName;
    private final int numberToSlay;
    private int numberSlain;

    public MonsterSlayingObjective(boolean optional, String monsterName, int numberToSlay) {
        super(optional);
        if (monsterName == null)
            throw new IllegalArgumentException("Monster name can not be null");
        if (numberToSlay < 1)
            throw new IllegalArgumentException("Number of monsters to slay can not be less than one");
        this.monsterName = monsterName;
        this.numberToSlay = numberToSlay;
    }

    @Override
    protected String getStatus() {
        return numberSlain + "/" + numberToSlay + " " + monsterName + " slain";
    }

    @Override
    public boolean isComplete() {
        return numberSlain == numberToSlay;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public int getNumberToSlay() {
        return numberToSlay;
    }

    public int getNumberSlain() {
        return numberSlain;
    }

    public void incrementNumberSlain() {
        if (numberSlain < numberToSlay)
            numberSlain++;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof MonsterSlayingObjective) {
            MonsterSlayingObjective other = (MonsterSlayingObjective) object;
            return other.monsterName.equals(monsterName) && other.numberToSlay == numberToSlay &&
                    other.numberSlain == numberSlain;
        }

        return false;
    }
}
