package se.su.dsv.inte.item;

public class Weapon extends Item {

    //Weapon can be a sword, axe, bow or something else
    private String weaponType;
    private int attackPoints;



    public Weapon(String name, String weaponType, int attackPoints) {
        super(name);
        this.weaponType = weaponType;
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public String getWeaponType() {
        return weaponType;
    }


}
