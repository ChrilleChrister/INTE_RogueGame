package se.su.dsv.inte.map;

public class Tile {

    private final int TILE_WIDTH; // Width and Height, set values?
    private final int TILE_HEIGHT;
    private int xPosition, yPosition;
    private TileType tileType; //Grass, mountain or snow




    public Tile(int xPosition, int yPosition, TileType tileType) {
        this.TILE_WIDTH = 64;
        this.TILE_HEIGHT = 64;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.tileType = tileType;

    }

    public int getTileWidth() {
        return TILE_WIDTH;
    }

    public int getTileHeight() {
        return TILE_HEIGHT;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public TileType getTileType() {
        return tileType;
    }



}
