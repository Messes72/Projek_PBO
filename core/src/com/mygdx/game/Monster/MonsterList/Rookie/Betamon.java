package com.mygdx.game.Monster.MonsterList.Rookie;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.Airdramon;
import com.mygdx.game.Monster.MonsterList.Champion.DarkTyranomon;
import com.mygdx.game.Monster.MonsterList.Champion.Seadramon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Betamon extends Pet {

    private final String path = "Monster/Rookie/Betamon.png";

    int attack = 20;
    int hp = 94;
    int age = 9;
    NormalAttack normalAttack;

    public Betamon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Betamon() {
        this.attack = 20;
        this.hp = 94;
        this.age = 9;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Betamon(Pet petBefore) {
        super(petBefore);
    }

    @Override
    protected String getPath(){
        return this.path;
    }

    public TextureRegion getNormalAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 4);
    }

    public TextureRegion getSpecialAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 5);
    }

    @Override
    public Pet evolve(Pet Betamon){
        if (Betamon.getMax_hp() >= 240 && Betamon.getAge() >= 18 && Betamon.getAttack() >= 97) {
            return new Seadramon(this);
        } else if (Betamon.getMax_hp() >= 187 && Betamon.getAge() >= 18 && Betamon.getAttack() >= 54) {
            return new Airdramon(this);
        } else if (Betamon.getMax_hp() >= 262 && Betamon.getAge() >= 18 && Betamon.getAttack() >= 83) {
            return new DarkTyranomon(this);
        } else return this;
    }
}
