package se.su.dsv.inte.map;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileGridNonRandomOnlyMountainTest extends TileGrid {
    private static final int WORLD_WIDTH = 14;
    private static final int WORLD_HEIGHT = 14;
    private static final int NUMBER_TO_GENERATE_MOUNTAIN = 3;

    public TileGridNonRandomOnlyMountainTest() {
        super(WORLD_WIDTH, WORLD_HEIGHT);
    }

    /**
     * Emulate a random number generator to always return 3 (Corresponding to <code>TileType.MOUNTAIN</code>).
     * @return 3
     */
    @Override
    protected int generateRandomNumber() {
        return NUMBER_TO_GENERATE_MOUNTAIN;
    }


    @Test
    public void testTileGridCanNotBeGeneratedWithTooManyMountainTiles() {
        TileGrid world = new TileGridNonRandomOnlyMountainTest();
       // assertEquals(world.MAX_NUMBER_OF_MOUNTAIN_TILES, world.currentNumberOfMountainTiles);
    }



    @Test
    public void testMountainTilesIsReplacedByGrassTilesIfMaxNumberOfMountainTilesIsReachedDuringWorldGeneration() {
        TileGrid world = new TileGridNonRandomOnlyMountainTest();
        Tile[][] grid = world.getWorldOfTiles();

        assertEquals(TileType.MOUNTAIN, grid[0][0].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][1].getTileType());
        assertEquals(TileType.MOUNTAIN, grid[0][2].getTileType());
        assertEquals(TileType.GRASS, grid[1][0].getTileType());
        assertEquals(TileType.GRASS, grid[2][2].getTileType());
    }
}
