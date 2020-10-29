package se.su.dsv.inte.itemTest;

import org.junit.Test;
import se.su.dsv.inte.item.Weapon;
import se.su.dsv.inte.item.WeaponType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class WeaponTest {
    private static final String DEFAULT_NAME = "Frostmourne";
    private static final WeaponType DEFAULT_WEAPON_TYPE = WeaponType.SWORD;
    private static final int DEFAULT_ATTACK_POINTS = 10;

    @Test
    public void testWeaponCtrSetsAttributes() {
        Weapon w = new Weapon(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, DEFAULT_ATTACK_POINTS);
        assertEquals(DEFAULT_NAME, w.getName());
        assertEquals(DEFAULT_WEAPON_TYPE, w.getWeaponType());
        assertEquals(DEFAULT_ATTACK_POINTS, w.getAttackPoints());
    }

    @Test
    public void testWeaponsWithIdenticalAttributesAreEqual() {
        assertEquals(new Weapon(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, DEFAULT_ATTACK_POINTS),
                new Weapon(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, DEFAULT_ATTACK_POINTS));
    }

    @Test
    public void testWeaponsWithDifferentAttributesAreNotEqual() {
        Weapon w1 = new Weapon(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, 10);
        Weapon w2 = new Weapon(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, 20);
        assertNotEquals(w1, w2);
    }

    @Test
    public void testWeaponNotEqualToOtherClass() {
        assertNotEquals(new Weapon(DEFAULT_NAME, DEFAULT_WEAPON_TYPE, DEFAULT_ATTACK_POINTS), new Object());
    }
}

