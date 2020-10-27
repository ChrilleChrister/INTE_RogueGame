package se.su.dsv.inte.character;

import se.su.dsv.inte.item.Consumable;
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

    private void updateStats(Race race, int levelToScaleTo) {
        baseHitPoints = race.getBaseHitPoints() + ((levelToScaleTo - 1) * 5);
        baseAttackPoints = race.getBaseAttackPoints() + ((levelToScaleTo - 1) * 2);
        baseDefensePoints = race.getBaseDefensePoints() + ((levelToScaleTo - 1) * 2);
    }

    public void changeBaseAttackPoints(Weapon item) {
        baseAttackPoints += item.getAttackPoints();
    }

    public void changeBaseDefensePoints(Outfit item) {
        baseDefensePoints += item.getDefensePoints();
    }

/* ej klar
    public void restoreHitpoints(Consumable item) {
         if(currentHitPoints + item.getRestorePoints() > getBaseHitPoints() ){

         }

    }
*/
}