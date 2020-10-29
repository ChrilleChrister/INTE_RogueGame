package se.su.dsv.inte.map;

import org.junit.Ignore;
import org.junit.Test;

public class TileGridIllegalNumberThrowsIAE extends TileGrid {

    public TileGridIllegalNumberThrowsIAE() {
        super(3, 3);
    }

    @Override
    protected int generateRandomNumber() {
        return 5;
    }

    @Test (expected = IllegalArgumentException.class)
    @Ignore
    public void testIAE() {
        new TileGridIllegalNumberThrowsIAE();

    }
}
