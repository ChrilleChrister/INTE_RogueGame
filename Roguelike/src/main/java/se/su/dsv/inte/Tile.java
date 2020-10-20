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
//Height and width or tiles?
    private final int xPosition, yPosition;
    private TileType tileType; //Grass, mountain or snow

    public Tile(int xPosition, int yPosition, TileType tileType) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.tileType = tileType;
    }

    public TileType getTileType() {
        return tileType;
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

}
