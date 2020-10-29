package se.su.dsv.inte.itemTest;

import org.junit.Test;
import se.su.dsv.inte.item.Outfit;
import se.su.dsv.inte.item.OutfitType;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class OutfitTest {
    private static final String DEFAULT_NAME = "Knight's Armor";
    private static final OutfitType DEFAULT_OUTFIT_TYPE = OutfitType.PLATE;
    private static final int DEFAULT_DEFENSE_POINTS = 10;

    @Test
    public void testOutfitsWithIdenticalAttributesAreEqual() {
        assertEquals(new Outfit(DEFAULT_NAME, DEFAULT_OUTFIT_TYPE, DEFAULT_DEFENSE_POINTS),
                new Outfit(DEFAULT_NAME, DEFAULT_OUTFIT_TYPE, DEFAULT_DEFENSE_POINTS));
    }

    @Test
    public void testOutfitsWithDifferentAttributesAreNotEqual() {
        Outfit o1 = new Outfit(DEFAULT_NAME, DEFAULT_OUTFIT_TYPE, 10);
        Outfit o2 = new Outfit(DEFAULT_NAME, DEFAULT_OUTFIT_TYPE, 20);
        assertNotEquals(o1, o2);
    }

    @Test
    public void testOutfitNotEqualToOtherClass() {
        assertNotEquals(new Outfit(DEFAULT_NAME, DEFAULT_OUTFIT_TYPE, DEFAULT_DEFENSE_POINTS), new Object());
    }
}
