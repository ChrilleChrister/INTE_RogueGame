package se.su.dsv.inte;

public class EnemyCharacter extends Character{

    /**
     * Borde ha något slags loottable
     * behavior, exempelvis aggressive eller passive
     * Abilities, har den stuns eller liknande
     */

    private int aggressiveRange;
    
    public EnemyCharacter(Race race, int level, int aggressiveRange){
        super(race, level, "Angry " + race.getName());
        if(aggressiveRange < 0 || aggressiveRange > 40){
            throw new IllegalArgumentException("aggressiveRange out of range (0-40)");
        }
        this.aggressiveRange = aggressiveRange;
    }

    //Kommer antagligen inte användas, kanske ta bort?
    public int getAggressiveRange(){
        return aggressiveRange;
    }
}
