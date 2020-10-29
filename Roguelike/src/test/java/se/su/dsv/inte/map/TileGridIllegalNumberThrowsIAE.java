package se.su.dsv.inte.map;

import org.junit.Test;

public class TileGridIllegalNumberThrowsIAE extends TileGrid {

    public TileGridIllegalNumberThrowsIAE(int i) {
        super(3, 3);
    }

    @Override
    protected int generateRandomNumber() {
        return 5;
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIAE() {
        new TileGridIllegalNumberThrowsIAE();

    }
}
