package se.su.dsv.inte.mapTest;

import org.junit.Test;
import se.su.dsv.inte.map.Tile;
import se.su.dsv.inte.map.TileType;

import static org.junit.Assert.assertEquals;

public class TileGridTest {
    public Tile[][] worldOfTiles;


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
//TODO is it possble to test that 2/3 of map is not of mountain tiles?
    @Test
    public void getTileTypesOfMountain() {
        worldOfTiles = new Tile[3][3];
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                worldOfTiles[i][j] = new Tile(i * 64, j * 64, TileType.MOUNTAIN);
                assertEquals(worldOfTiles[i][j].getxPosition(), i * 64);
                assertEquals(worldOfTiles[i][j].getyPosition(), j * 64);

                assertEquals(worldOfTiles[i][j].getTileType(), TileType.MOUNTAIN);
            }
        }
    }

}
