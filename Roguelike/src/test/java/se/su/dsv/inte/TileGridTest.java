package se.su.dsv.inte;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TileGridTest {
    public Tile [][] worldOfTiles;

    @Test //TODO Decide if test is useful
    public void testLenghtOfArraysOfTiles() {
        worldOfTiles = new Tile[3][3];
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                worldOfTiles[i][j] = new Tile(i * 64, j * 64, TileType.GRASS);
            }
            assertEquals(3, worldOfTiles.length);
            assertEquals(3, worldOfTiles[i].length);
        }
    }

    @Test
    public void getTileTypesOfGrass() {
        worldOfTiles = new Tile[3][3];
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                worldOfTiles[i][j] = new Tile(i * 64, j * 64, TileType.GRASS);

                    assertEquals(worldOfTiles[i][j].getTileType(), TileType.GRASS);
            }
        }
    }

}