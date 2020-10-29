package se.su.dsv.inte.character;

public class EnemyCharacter extends Character{

    /**
     * Should have loottable
     * behavior, ex aggressive or passive
     * Abilities, stuns or something
     */

    private int aggressiveRange;
    
    public EnemyCharacter(Race race, int level, int aggressiveRange){
        super(race, level, "Angry " + race.getName());
        if(aggressiveRange < 0 || aggressiveRange > 40){
            throw new IllegalArgumentException("aggressiveRange out of range (0-40)");
        }
        this.aggressiveRange = aggressiveRange;
    }

    //Not used
    public int getAggressiveRange(){
        return aggressiveRange;
    }
}
