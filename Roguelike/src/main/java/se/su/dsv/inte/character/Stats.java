package se.su.dsv.inte.character;


import se.su.dsv.inte.item.Outfit;
import se.su.dsv.inte.item.Weapon;

public class Stats {
    private int baseHitPoints;
    private int baseAttackPoints;
    private int baseDefensePoints;

    public Stats(Race race, int level) {
        updateStats(race, level);
    }

    public int getBaseHitPoints() {
        return baseHitPoints;
    }

    public int getBaseAttackPoints() {
        return baseAttackPoints;
    }

    public int getBaseDefensePoints() {
        return baseDefensePoints;
    }

    public void updateStats(Race race, int levelToScaleTo) {
        baseHitPoints = race.getBaseHitPoints() + ((levelToScaleTo - 1) * 5);
        baseAttackPoints = race.getBaseAttackPoints() + ((levelToScaleTo - 1) * 2);
        baseDefensePoints = race.getBaseDefensePoints() + ((levelToScaleTo - 1) * 2);
    }

    public void equipChangeBaseAttackPoints(Weapon item) {
        baseAttackPoints += item.getAttackPoints();
    }

    public void equipChangeBaseDefensePoints(Outfit item) {
        baseDefensePoints += item.getDefensePoints();
    }

    public void unEquipChangeBaseAttackPoints(Weapon item) {
        baseAttackPoints -= item.getAttackPoints();
    }

    public void unEquipChangeBaseDefensePoints(Outfit item) {
        baseDefensePoints -= item.getDefensePoints();
    }



}
