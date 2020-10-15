package se.su.dsv.inte;

public class Weapon extends Item {

    //Weapon can be a sword, axe, bow or something else
    private String weaponType;
    private int attackPower;


    public Weapon(String name, String weaponType, int attackPower) {
        super(name);
        this.weaponType = weaponType;
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public String getWeaponType(){
        return weaponType;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Weapontype: %s Attackpower: %d", getName(), weaponType, attackPower);
    }
}
