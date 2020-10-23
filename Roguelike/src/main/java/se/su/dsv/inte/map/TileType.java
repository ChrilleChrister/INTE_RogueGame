package se.su.dsv.inte.map;

public enum TileType {

    //Can grass get snow on it?
    //Can Grass have items? Maybe not snow?
    GRASS ("Grass",  2, true),
    MOUNTAIN ("Mountain",  0, false), //Can not walk on Mountain
    SNOW ("Snow", 1, true ); //Moves slower in Snow compared to Grass

    private String name;
    private int tileTypeMovementSpeed;
    private boolean transversive;


    TileType(String name, int tileTypeMovementSpeed, boolean transversive) {
        this.name = name;
        this.tileTypeMovementSpeed = tileTypeMovementSpeed;
        this.transversive = transversive;
    }

    public String getName() {
        return name;
    }

    public int getTileTypeMovementSpeed() {
        return tileTypeMovementSpeed;
    }

    public boolean getIfTransversive(){
        return transversive;
    }


}
