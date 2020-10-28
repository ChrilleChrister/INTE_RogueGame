package se.su.dsv.inte.combat;

import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.EnemyCharacter;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Stats;

//PLAYER WHO'S TAUNTED DOES NEVER BECOME NOT TAUNTED
public class Engagement {
    private PlayerCharacter player;
    private EnemyCharacter enemy;
    private Character turnHolder;
    private Character turnSitter;
    private boolean active;

    public Engagement(PlayerCharacter player, EnemyCharacter enemy, Character firstStriker){
        this.player = player;
        this.enemy = enemy;
        this.turnHolder = firstStriker;
        active = true;
        if(firstStriker.equals(player)){
            this.turnSitter = enemy;
        }
        else{
            this.turnSitter = player;
        }
    }

    public PlayerCharacter getPlayer(){
        return player;
    }

    public boolean isActive(){
        return active;
    }

    public EnemyCharacter getEnemy(){
        return enemy;
    }

    public Character getTurnHolder(){
        return turnHolder;
    }

    public Character getTurnSitter(){
        return turnSitter;
    }

    public void setTurnHolder(Character character){
        turnHolder = character;
    }

    public void setTurnSitter(Character character){
        turnSitter = character;
    }

    public void attack(Stats attackerStats, Character target, double hitChance){
        double trueDamage = attackerStats.getBaseAttackPoints();
        double mitigationPercentage = ((double )target.getStats().getBaseDefensePoints())/200;
        double damageMitigation = 1 - mitigationPercentage;
        int damage = (int) Math.round(trueDamage * damageMitigation); // unchecked cast
        if(Math.random() <= hitChance){
            applyDamage(target, damage);
        }
        swapTurns();
    }

    public void swapTurns(){
        if (turnSitter.getStunTime() == 0){
            Character temp = getTurnHolder();
            setTurnHolder(getTurnSitter());
            setTurnSitter(temp);
        }
        else{
            turnSitter.decreaseStunTime();
        }
        player.decreaseTauntTime();
    }

    //Could be removed, but tests are applied to it instead of attack(). Rewrite if there's time
    public void applyDamage(Character target, int damage){
        target.receiveDamage(damage);
    }

    public void stun(Character target, double hitChance){
        if(target.getStunTime() == 0){
            if(Math.random() <= hitChance){
                target.setStunned();
            }
            else{
                swapTurns();
            }
        }
    }
    
    public void taunt(PlayerCharacter target){
        if(!turnHolder.equals(target)){
            target.setTaunted();
        swapTurns();
        }
    }

    public void escape(PlayerCharacter player, double escapeChance){
        if(Math.random() <= escapeChance && player.getTauntTime() == 0){
            active = false;
        }
        else{
            swapTurns();
        }
    }
}