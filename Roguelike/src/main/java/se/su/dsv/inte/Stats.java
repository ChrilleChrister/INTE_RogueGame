package se.su.dsv.inte;

public class Stats {
    private int hitPoints;
    private int attackPoints;
    private int defensePoints;

    public Stats(Race race, int level) {
        this.hitPoints = race.getBaseHitPoints();
        this.attackPoints = race.getBaseAttackPoints();
        this.defensePoints = race.getBaseDefensePoints();
        updateStats(level);
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    private void updateStats(int levelToScaleTo) {

    }

}
