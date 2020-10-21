package se.su.dsv.inte;

import org.junit.Test;


import static org.junit.Assert.*;

public class TileTest {

    private final int TILE_WIDTH_64 = 64;
    private final int TILE_HEIGHT_64 = 64;
    private final int X_POSITION_ONE = 1;
    private final int Y_POSITION_ONE = 1;
    private TileType TILE_TYPE_GRASS = TileType.GRASS; //Grass, mountain or snow

    //Thoughts, can two hobbits be on some tile?


    @Test
    public void testCtrSetsAttributes() {
        Tile tile = new Tile(TILE_WIDTH_64, TILE_HEIGHT_64, X_POSITION_ONE, Y_POSITION_ONE, TILE_TYPE_GRASS);
        assertEquals(TILE_WIDTH_64, tile.getTileWidth());
        assertEquals(TILE_HEIGHT_64, tile.getTileHeight());
        assertEquals(X_POSITION_ONE, tile.getxPosition());
        assertEquals(Y_POSITION_ONE, tile.getyPosition());
        assertEquals(TILE_TYPE_GRASS, tile.getTileType());

    }
}
