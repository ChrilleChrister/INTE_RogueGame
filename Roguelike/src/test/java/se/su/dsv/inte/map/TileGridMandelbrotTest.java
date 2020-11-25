package se.su.dsv.inte.map;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TileGridMandelbrotTest extends TileGrid {
    private static final int WORLD_WIDTH = 14;
    private static final int WORLD_HEIGHT = 14;
    private static final int NUMBER_FOR_INTERVAL = 200;

    public TileGridMandelbrotTest() {
        super(WORLD_WIDTH, WORLD_HEIGHT);
    }

    @Override
    protected int generateMaxNumberForIterationInMandelbrot() {
        return NUMBER_FOR_INTERVAL;
    }

    @Test
    public void testMandelbrot() {
        TileGrid world = new TileGridMandelbrotTest();
        Tile[][] grid = world.getWorldOfTiles();

        assertEquals(TileType.MOUNTAIN, grid[0][0].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][1].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][2].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][3].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][4].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][10].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][13].getTileType());
        assertEquals(TileType.GRASS, grid[1][0].getTileType());
        assertEquals(TileType.GRASS, grid[2][0].getTileType());
        assertEquals(TileType.GRASS, grid[3][0].getTileType());
        assertEquals(TileType.GRASS, grid[4][0].getTileType());
        assertEquals(TileType.GRASS, grid[5][0].getTileType());

    }
}

