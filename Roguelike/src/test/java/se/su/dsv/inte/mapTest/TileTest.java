package se.su.dsv.inte.mapTest;

import org.junit.Test;
import se.su.dsv.inte.map.Tile;
import se.su.dsv.inte.map.TileType;


import static org.junit.Assert.*;

public class TileTest {

    private final int TILE_WIDTH_64 = 64;
    private final int TILE_HEIGHT_64 = 64;
    private final int X_POSITION_ONE = 1;
    private final int Y_POSITION_ONE = 1;
    private TileType TILE_TYPE_GRASS = TileType.GRASS; //Grass, mountain or snow
    private TileType TILE_TYPE_MOUNTAIN = TileType.MOUNTAIN; //Grass, mountain or snow



    //Thoughts, can two hobbits be on the same tile?


    @Test
    public void testCtrSetsAttributesMountain() {
        Tile tile = new Tile(X_POSITION_ONE, Y_POSITION_ONE, TILE_TYPE_MOUNTAIN);
        assertEquals(tile.getTileWidth(), TILE_WIDTH_64);
        assertEquals(tile.getTileHeight(), TILE_HEIGHT_64);
        assertEquals(X_POSITION_ONE, tile.getxPosition());
        assertEquals(Y_POSITION_ONE, tile.getyPosition());
        assertEquals(TILE_TYPE_MOUNTAIN, tile.getTileType());


    }
    @Test
    public void testCtrSetsAttributesGrass() {
        Tile tile = new Tile(X_POSITION_ONE, Y_POSITION_ONE, TILE_TYPE_GRASS);
        assertEquals(TILE_WIDTH_64, tile.getTileWidth());
        assertEquals(TILE_HEIGHT_64, tile.getTileHeight());
        assertEquals(X_POSITION_ONE, tile.getxPosition());
        assertEquals(Y_POSITION_ONE, tile.getyPosition());
        assertEquals(TILE_TYPE_GRASS, tile.getTileType());

    }
    @Test
    public void testCtrSetsAttributesSnow() {
        Tile tile = new Tile(X_POSITION_ONE, Y_POSITION_ONE, TILE_TYPE_GRASS);
        assertEquals(TILE_WIDTH_64, tile.getTileWidth());
        assertEquals(TILE_HEIGHT_64, tile.getTileHeight());
        assertEquals(X_POSITION_ONE, tile.getxPosition());
        assertEquals(Y_POSITION_ONE, tile.getyPosition());
        assertEquals(TILE_TYPE_GRASS, tile.getTileType());

    }

}