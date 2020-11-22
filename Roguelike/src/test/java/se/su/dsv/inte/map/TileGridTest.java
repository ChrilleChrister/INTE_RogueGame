package se.su.dsv.inte.map;

import org.junit.Test;

import static org.junit.Assert.*;

public class TileGridTest {
    private static final int GRASS_TILE = 0;
    private static final int GRASS_TILE_TWO = 1;
    private static final int SNOW_TILE = 2;
    private static final int MOUNTAIN_TILE = 3;

    private static final int WIDTH = 3;
    private static final int HEIGHT = 3;
    private static final TileGrid DEFAULT_GRID = new TileGrid(WIDTH, HEIGHT);
    public Tile[][] worldOfTiles;

    //Rest-tankar, behöver width vara ok och height för liten och för att testa att världen inte är för liten?


    @Test (expected = IllegalArgumentException.class)
    public void testWorldSizeTooSmallThrowsIAE() {
        new TileGrid(0, HEIGHT);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testWorldSizeTooSmallHeightThrowsIAE() {
        new TileGrid(WIDTH, 0);
    }

    @Test
    public void testLengthOfArraysOfTiles() {
        assertEquals(WIDTH, DEFAULT_GRID.getWorldOfTiles().length);
        assertEquals(HEIGHT, DEFAULT_GRID.getWorldOfTiles()[0].length);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalNumberThrowsIAE() {
        TileGrid tg = new TileGrid(WIDTH, HEIGHT);
        tg.makeRandomTileTypesInTheTileGrid(5);
    }
}
