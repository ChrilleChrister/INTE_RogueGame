package se.su.dsv.inte.map;

import java.util.Random;

//Henrik förslag, implementera hur snabbt man rör sig exempelvis. Movement-point kan spenderas till att ta slut.
//Kö av alla spelpjäser el prioritetskö. Spelare som går olika snabbt men prioritetskö. Timern. Tiden tickas ner.
//Mer tekniskt- generate world. Generera trovärdiga kartor? Norr ut alltid minus 25? För att få bort slump problem.
//Annan variant på kartor, Olika rum, dungeon crawl- inte super...
//Fraktaler, matematiskt koncept. (Mandelbrotmängden) Zoomar in på och en del av den blir kartan. Mandelbrotmängdgenerator, den används för att generera karta.


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
    protected TileType makeRandomTileTypesInTheTileGrid(int tileType) {
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
