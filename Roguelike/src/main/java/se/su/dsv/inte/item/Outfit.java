package se.su.dsv.inte.item;

public class Outfit extends Item {



    private OutfitType outfitType;
    private int defensePoints;


    public Outfit(String name, OutfitType outfitType, int defensePoints) {
        super(name);
        this.outfitType = outfitType;
        this.defensePoints = defensePoints;
    }

    public int getDefensePoints() {
        return defensePoints;
    }

    public OutfitType getOutfitType() {
        return outfitType;
    }



    @Override
    public boolean equals(Object object) {
        if (object instanceof Outfit) {
            Outfit other = (Outfit) object;
            return other.outfitType.equals(outfitType) && other.defensePoints == defensePoints;
        }

        return false;
    }
}
