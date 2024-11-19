package com.mygdx.game.Monster.MonsterList.Fresh;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.InTraining.Koromon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Botamon extends Pet {

    final String path = "Monster/Fresh/Botamon.png";

    int attack = 2;
    int hp = 8;
    int age = 0;
    NormalAttack normalAttack;

    public Botamon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Botamon() {
        this.attack = 2;
        this.hp = 8;
        this.age = 0;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Botamon(Pet petBefore) {
        super(petBefore);
    }

    @Override
    protected String getPath(){
        return this.path;
    }

    @Override
    public TextureRegion getNormalAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 0);
    }

    @Override
    public TextureRegion getSpecialAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 0);
    }

    @Override
    public Pet evolve(Pet Botamon){
        if (Botamon.getMax_hp() >= 48 && Botamon.getAge() >= 3 && Botamon.getAttack() >= 7) {
            return new Koromon(this);
        }
        else return this;
    }
}
