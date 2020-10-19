package se.su.dsv.inte;

public class Stats {
    private int hitPoints;
    private int attackPoints;
    private int defensePoints;

    public Stats(Race race, int level) {
        updateStats(race, level);
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

    private void updateStats(Race race, int levelToScaleTo) {
        hitPoints = race.getBaseHitPoints() + ((levelToScaleTo - 1) * 5);
        attackPoints = race.getBaseAttackPoints() + ((levelToScaleTo - 1) * 2);
        defensePoints = race.getBaseDefensePoints() + ((levelToScaleTo - 1) * 2);
    }

}
