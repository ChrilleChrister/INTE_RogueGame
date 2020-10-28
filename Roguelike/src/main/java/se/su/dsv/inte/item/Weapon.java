package se.su.dsv.inte.item;

public class Weapon extends Item {


    private WeaponType weaponType;
    private int attackPoints;



    public Weapon(String name, WeaponType weaponType, int attackPoints) {
        super(name);

        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }


}
