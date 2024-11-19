package com.mygdx.game.Monster.MonsterList.Ultimate;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Mega.Machinedramon;
import com.mygdx.game.Monster.MonsterList.Mega.Wargreymon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Metaltyranomon extends Pet {
    private final String path = "";
    int hp = 716;
    int attack = 220;
    int age = 36;
    NormalAttack normalAttack;

    public Metaltyranomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Metaltyranomon()
    {
        this.attack = 220;
        this.hp = 716;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Metaltyranomon(Pet petBefore)
    {
        super(petBefore);
    }

    protected String getPath()
    {
        return path;
    }

    public TextureRegion getNormalAttackFrame()
    {
        return specialAttack.getCurrentFrame(0.4f * 4);
    }

    public TextureRegion getSpecialAttackFrame()
    {
        return specialAttack.getCurrentFrame(0.4f * 5);
    }

    @Override
    public Pet evolve(Pet Metaltyranomon) {
        if (Metaltyranomon.getAttack() >= 600 && Metaltyranomon.getMax_hp() >= 1500 && Metaltyranomon.getAge() >= 41 && Metaltyranomon.getBattleWins() >= 50){
            return new Wargreymon(this);
        } else if (Metaltyranomon.getAttack() >= 630 && Metaltyranomon.getMax_hp() >= 1800 && Metaltyranomon.getAge() >= 41 && Metaltyranomon.getBattleWins() >= 60){
            return new Machinedramon(this);
        } else return this;
    }
}
