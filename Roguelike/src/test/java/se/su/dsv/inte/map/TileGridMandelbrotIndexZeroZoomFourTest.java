package se.su.dsv.inte.map;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TileGridMandelbrotIndexZeroZoomFourTest extends TileGrid {
    private static final int WORLD_WIDTH = 14;
    private static final int WORLD_HEIGHT = 14;
    private static final int INDEX_TO_CREATE_MAP_FROM_ZERO = 0;
    private static final double ZOOM_IN_ON_MANDELBROT_FOUR = 4.0;



    public TileGridMandelbrotIndexZeroZoomFourTest() {
        super(WORLD_WIDTH, WORLD_HEIGHT);
    }

    /**
     * Emulate random number generator to always return 0 and 4.0 (Corresponding to index 0 and zoom 4.0 in Mandelbrot Fraction).
     *
     */
    @Override
    protected int indexOfMapCreation() {
        return INDEX_TO_CREATE_MAP_FROM_ZERO;
    }

    @Override
    protected double zoomOfMandelbrot() {
        return ZOOM_IN_ON_MANDELBROT_FOUR;
    }


    @Test
    public void testMandelbrotIndexZeroZoomFour() {
        Tile[][] grid = getWorldOfTiles();

        assertEquals(TileType.MOUNTAIN, grid[0][0].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][1].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][2].getTileType());
        assertEquals(TileType.SNOW, grid[0][3].getTileType());
        assertEquals(TileType.SNOW, grid[0][4].getTileType());
        assertEquals(TileType.SNOW, grid[0][5].getTileType());
        assertEquals(TileType.SNOW, grid[0][6].getTileType());
        assertEquals(TileType.GRASS, grid[1][0].getTileType());
        assertEquals(TileType.GRASS, grid[1][3].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[2][0].getTileType());
        assertEquals(TileType.GRASS, grid[3][0].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[4][0].getTileType());
        assertEquals(TileType.SNOW, grid[12][6].getTileType());
    }
}
