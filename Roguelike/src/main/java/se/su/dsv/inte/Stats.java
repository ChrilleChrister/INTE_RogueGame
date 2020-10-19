package se.su.dsv.inte;

public class Stats {
    private int hitPoints;
    private int attackPoints;
    private int defensePoints;

    public Stats(int hitPoints, int attackPoints, int defensePoints) {
        this.hitPoints = hitPoints;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
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

}
