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

    @Test (expected = IllegalArgumentException.class)
    public void testWorldSizeTooSmallThrowsIAE() {
        new TileGrid(0, HEIGHT);
    }

    @Test //TODO Decide if test is useful
    public void testLengthOfArraysOfTiles() {
        assertEquals(WIDTH, DEFAULT_GRID.getWorldOfTiles().length);
        assertEquals(HEIGHT, DEFAULT_GRID.getWorldOfTiles()[0].length);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalNumberThrowsIAE() {
        TileGrid tg = new TileGrid(WIDTH, HEIGHT);
        tg.makeRandomTileTypesInTheTileGrid(5);
    }

    /*
    @Test
    public void getTileTypesOfGrass() {
        worldOfTiles = new Tile[3][3];
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                worldOfTiles[i][j] = new Tile(i * 64, j * 64, TileType.GRASS);

                    assertEquals(worldOfTiles[i][j].getTileType(), TileType.GRASS);
                    assertEquals(worldOfTiles[i][j].getxPosition(), (i * 64));
                    assertEquals(worldOfTiles[i][j].getyPosition(), (j * 64));
            }
        }
    }

    @Test
    public void getTileTypesOfSnow() {
        worldOfTiles = new Tile[3][3];
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                worldOfTiles[i][j] = new Tile(i * 64, j * 64, TileType.SNOW);

                assertEquals(worldOfTiles[i][j].getTileType(), TileType.SNOW);
                assertEquals(worldOfTiles[i][j].getxPosition(), i * 64);
                assertEquals(worldOfTiles[i][j].getyPosition(), j * 64);
            }
        }
    }

    @Test
    public void testmakeRandomTileTypesInTheTileGridCreatesGrassTile(){
        Tile tile = new Tile(0, 0, DEFAULT_GRID.makeRandomTileTypesInTheTileGrid(GRASS_TILE));
        Tile tileTwo = new Tile(0, 0, DEFAULT_GRID.makeRandomTileTypesInTheTileGrid(GRASS_TILE_TWO));

        assertEquals(TileType.GRASS, tile.getTileType());
        assertEquals(TileType.GRASS, tileTwo.getTileType());
    }

    @Test
    public void testmakeRandomTileTypesInTheTileGridCreatesSnowTile(){
        Tile tile = new Tile(0, 0, DEFAULT_GRID.makeRandomTileTypesInTheTileGrid(SNOW_TILE));

        assertEquals(TileType.SNOW, tile.getTileType());
    }

    @Test
    public void testmakeRandomTileTypesInTheTileGridCreatesMountainTile(){
        Tile tile = new Tile(0, 0, DEFAULT_GRID.makeRandomTileTypesInTheTileGrid(MOUNTAIN_TILE));

        assertEquals(TileType.MOUNTAIN, tile.getTileType());
    }

     */

}
