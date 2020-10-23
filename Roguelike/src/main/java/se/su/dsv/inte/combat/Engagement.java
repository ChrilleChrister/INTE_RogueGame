package se.su.dsv.inte.combat;

import se.su.dsv.inte.EnemyCharacter;
import se.su.dsv.inte.PlayerCharacter;

public class Engagement {
    private PlayerCharacter player;
    private EnemyCharacter enemy;

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
}
