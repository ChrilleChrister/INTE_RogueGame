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

    @Override
    public String toString() {
        return String.format("Name: %s || Weapontype: %s || Attackpower: %d", getName(), weaponType, attackPoints);
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Weapon) {
            Weapon other = (Weapon) object;
            return other.weaponType.equals(weaponType) && other.attackPoints == attackPoints;
        }

        return false;
    }
}
