package se.su.dsv.inte;
/*
Fog-of-war
Treasure chests? (items)
Environments, grass, snow, mountain, cave (different movement speed, can not walk on)
Weather effects (affects on weapon)
(Line of sight)
//Directions in enum?
*/

public class Tile {

    private int tileWidth; // Width and Height, set values?
    private int tileHeight;
    private int xPosition, yPosition;
    private TileType tileType; //Grass, mountain or snow



    public Tile(int tileWidth, int tileHeight, int xPosition, int yPosition, TileType tileType) {
        this.tileWidth = tileWidth;
        this.tileHeight = tileHeight;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.tileType = tileType;
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
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
