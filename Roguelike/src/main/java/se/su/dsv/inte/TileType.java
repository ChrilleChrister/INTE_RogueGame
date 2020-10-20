package se.su.dsv.inte;

public enum TileType {

    //Can grass get snow on it?
    //Can Grass have items? Maybe not snow?

    GRASS ("Grass",  2),
    MOUNTAIN ("Mountain",  0),
    SNOW ("Snow", 1 );

    private String name;
    private int tileTypeMovementSpeed;

    TileType(String name, int tileTypeMovementSpeed) {
        this.name = name;
        this.tileTypeMovementSpeed = tileTypeMovementSpeed;
    }

    public String getName() {
        return name;
    }

    public int getTileTypeMovementSpeed() {
        return tileTypeMovementSpeed;
    }
}
