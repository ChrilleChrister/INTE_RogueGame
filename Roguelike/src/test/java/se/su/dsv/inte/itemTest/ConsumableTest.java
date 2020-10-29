package se.su.dsv.inte.itemTest;

import org.junit.Test;
import se.su.dsv.inte.item.Consumable;

import static org.junit.Assert.*;

public class ConsumableTest {
    private static final String DEFAULT_NAME = "Potion";

    @Test
    public void testConsumablesWithIdenticalAttributesAreEqual() {
        assertEquals(new Consumable(DEFAULT_NAME), new Consumable(DEFAULT_NAME));
    }

    @Test
    public void testConsumablesWithDifferentAttributesAreNotEqual() {
        Consumable c1 = new Consumable(DEFAULT_NAME);
        c1.addOneItemToStack();
        Consumable c2 = new Consumable(DEFAULT_NAME);
        assertNotEquals(c1, c2);
    }

    @Test
    public void testConsumableNotEqualToOtherClass() {
        assertNotEquals(new Consumable(DEFAULT_NAME), new Object());
    }
}
