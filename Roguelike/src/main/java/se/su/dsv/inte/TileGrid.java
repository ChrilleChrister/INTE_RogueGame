package se.su.dsv.inte;

import java.util.Random;

//Creates the map/world by creating an array of arrays of tiles, worldOfTiles.
public class TileGrid {
    public Tile[][] worldOfTiles;


    public TileGrid() {
        worldOfTiles = new Tile[3][3];
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                worldOfTiles[i][j] = new Tile(i * 64, j * 64, makeRandomTileTypesInTheTileGrid());
            }
        }
        preventMoreThanAThirOfTilesToBeMountain();
        this.worldOfTiles = worldOfTiles;
    }

    //The worldOfTiles have a greater chance to contain more grass than snow and mountain.
    public TileType makeRandomTileTypesInTheTileGrid() {
        Random randTile = new Random();
        int upperbound = 3;
        int int_rand = randTile.nextInt(upperbound);

        switch (int_rand) {
            case 0:
                return TileType.GRASS;
            case 1:
                return TileType.GRASS;
            case 2:
                return TileType.SNOW;
            case 3:
                return TileType.MOUNTAIN;
            default:
                throw new IllegalArgumentException("Random number can only be 0-3");
        }
    }

    public void preventMoreThanAThirOfTilesToBeMountain() {
        int countMountainTiles = 0;
        for (int i = 0; i < worldOfTiles.length; i++) {
            for (int j = 0; j < worldOfTiles[i].length; j++) {
                if (worldOfTiles[i][j].getTileType().equals(TileType.MOUNTAIN)) {
                    countMountainTiles++;
                }
            }
            //If Mountain tiles are more than a third of all tiles,
            if (countMountainTiles > ((worldOfTiles.length * worldOfTiles[i].length) / 3)) ; //
            worldOfTiles = null;
        }
    }
}
