package se.su.dsv.inte.character;

public class Character {
    private Race race; // Race change? Modifies attributes!
    protected int level;
    private final String name; //no set method anyway but w/e
    private int currentHitPoints;
    private int movementSpeedModifier;// Use percentages instead. Round-off errors
    protected Stats stats;
    private boolean isAlive;
    private int stunTime;

    // Declare throws?
    public Character(Race race, int level) {
        this(race, level, race.getName());
    }

    public Character(Race race, int level, String name) {
        if (level < 1 || level > 100)
            throw new IllegalArgumentException("Level not in allowed range (1-100)");
        if (name == null || race == null)
            throw new IllegalArgumentException("Name or race can not be null");
        this.race = race;
        this.level = level;
        if(name.isEmpty()){
            this.name = race.getName();
        }
        else{
            this.name = name;
        }
        this.stats = new Stats(race, level);
        this.currentHitPoints = this.stats.getBaseHitPoints();
        isAlive = true;
        stunTime = 0;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public Race getRace() {
        return race;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public int getMovementSpeed() {
        return race.getBaseMovementSpeed() + movementSpeedModifier;
    }

    public Stats getStats(){
        return stats;
    }

    public int getCurrentHitpoints(){
        return currentHitPoints;
    }

    public int receiveDamage(int damage){
        if(Math.max(currentHitPoints-damage, 0) > 0){
            return currentHitPoints -= damage;
        }
        else{
            isAlive = false;
            return currentHitPoints = 0;
        }
    }

    public void heal(int hitpoints){
        if(currentHitPoints + hitpoints > stats.getBaseHitPoints()){
            currentHitPoints = stats.getBaseHitPoints();
        }
        else{
            currentHitPoints += hitpoints;
        }
    }

    public int getStunTime(){
        return stunTime;
    }

    public void setStunned(){
        if(stunTime == 0){
            stunTime = 2;
        }
    }

    public void decreaseStunTime(){
        stunTime = Math.max(stunTime - 1, 0);
    }

    // Not thread safe?
    public void changeMovementSpeedModifier(int movementSpeedModifier) {
        this.movementSpeedModifier += movementSpeedModifier;
        if (getMovementSpeed() < 0)
            this.movementSpeedModifier = -race.getBaseMovementSpeed();
    }
}
