package se.su.dsv.inte;

public class Outfit extends Item {


    //Outfit can be made out of plate, mail, leather and more
    private String outfitType;
    private int defensePoints;


    public Outfit(String name, String outfitType, int defensePoints) {
        super(name);
        this.outfitType = outfitType;
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public String getOutfitType() {
        return outfitType;
    }

    @Override
    public String toString() {
        return String.format("Name: %s Outfittype: %s Defense points: %d", getName(), outfitType, defensePoints);
    }


}
