package se.su.dsv.inte.map;

import java.util.Random;

//Creates the map/world by creating an array of arrays of tiles, worldOfTiles.
public class TileGrid {
    private final int worldWidth;
    private final int worldHeight;
    protected final int MAX_NUMBER_OF_MOUNTAIN_TILES;
    protected int currentNumberOfMountainTiles;
    public Tile[][] worldOfTiles;

    public TileGrid(int worldWidth, int worldHeight) {
        if (worldWidth < 1 || worldHeight < 1)
            throw new IllegalArgumentException("World size too small");
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        MAX_NUMBER_OF_MOUNTAIN_TILES = 3;
        worldOfTiles = generateWorld();
    }

    public Tile[][] getWorldOfTiles() {
        return worldOfTiles;
    }

    private Tile[][] generateWorld() {
        Tile[][] world = new Tile[worldWidth][worldHeight];
        for (int i = 0; i < world.length; i++) { // Y
            for (int j = 0; j < world[i].length; j++) { // X

                world[i][j] = new Tile(i * 64, j * 64, makeRandomTileTypesInTheTileGrid(generateRandomNumber()));
            }
        }
        return world;
    }

    protected int generateRandomNumber(){
        Random randTile = new Random();
        int upperbound = 4;
        return randTile.nextInt(upperbound);
    }

    //The worldOfTiles have a greater chance to contain more grass than snow and mountain.
    public TileType makeRandomTileTypesInTheTileGrid(int tileType) {
        switch (tileType) {
            case 0:
            case 1:
                return TileType.GRASS;
            case 2:
                return TileType.SNOW;
            case 3:
                if (currentNumberOfMountainTiles < MAX_NUMBER_OF_MOUNTAIN_TILES) {
                    currentNumberOfMountainTiles++;
                    return TileType.MOUNTAIN;
                }
                return TileType.GRASS;
            default:
                throw new IllegalArgumentException();
        }
    }
}
