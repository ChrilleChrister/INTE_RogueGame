package se.su.dsv.inte.item;

public class Weapon extends Item {


    private WeaponType weaponType;
    private int attackPoints;



    public Weapon(String name, WeaponType weaponType, int attackPoints) {
        super(name);
        this.weaponType = weaponType;
        this.attackPoints = attackPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public WeaponType getWeaponType() {
        return weaponType;
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
