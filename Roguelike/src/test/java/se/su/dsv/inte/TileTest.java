package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileTest {

    private final int X_POSITION_ONE = 1;
    private final int Y_POSITION_ONE = 1;
    private String TILE_TYPE_GRASS = "grass"; //Grass, mountain or snow


    @Test
    public void testCtrSetsAttributes() {
        Tile tile = new Tile(X_POSITION_ONE, Y_POSITION_ONE, TILE_TYPE_GRASS);
        assertEquals(X_POSITION_ONE, tile.getxPosition());
        assertEquals(Y_POSITION_ONE, tile.getyPosition());
        assertEquals(TILE_TYPE_GRASS, tile.getTileType());
    }
}
