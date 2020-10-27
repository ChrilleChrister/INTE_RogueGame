package se.su.dsv.inte.combat;

import se.su.dsv.inte.character.Character;
import se.su.dsv.inte.character.EnemyCharacter;
import se.su.dsv.inte.character.PlayerCharacter;
import se.su.dsv.inte.character.Stats;

public class Engagement {
    private PlayerCharacter player;
    private EnemyCharacter enemy;
    private Character turnHolder;
    private Character turnSitter;

    public Engagement(PlayerCharacter player, EnemyCharacter enemy){
        this.player = player;
        this.enemy = enemy;
    }

    public PlayerCharacter getPlayer(){
        return player;
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

    public void startEngagement(EnemyCharacter enemy, PlayerCharacter player, Character firstStriker){
        turnHolder = firstStriker;
        if(firstStriker.equals(player)){
            turnSitter = enemy;
        }
        else{
            turnSitter = player;
        }
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
    }

    //Could be removed, but tests are applied to it instad of attack(). Rewrite if there's time
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
}