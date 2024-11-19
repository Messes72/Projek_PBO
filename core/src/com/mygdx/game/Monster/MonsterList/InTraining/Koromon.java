package com.mygdx.game.Monster.MonsterList.InTraining;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Rookie.Agumon;
import com.mygdx.game.Monster.MonsterList.Rookie.Betamon;
import com.mygdx.game.Monster.MonsterList.Rookie.Toy_Agumon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Koromon extends Pet {

    final String path = "Monster/In Training/Koromon.png";

    int attack = 7;
    int hp = 48;
    int age = 3;
    NormalAttack normalAttack;

    public Koromon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Koromon() {
        this.attack = 7;
        this.hp = 48;
        this.age = 3;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Koromon(Pet petBefore) {
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
    public Pet evolve(Pet Koromon){
        if (Koromon.getAttack() >= 27 && Koromon.getMax_hp() >= 103 && Koromon.getAge() >= 9) {
            return new Agumon(this);

        } else if (Koromon.getAttack() >= 23 && Koromon.getMax_hp() >= 63 && Koromon.getAge() >= 9){
            return new Toy_Agumon(this);

        } else if (Koromon.getAttack() >= 20 && Koromon.getMax_hp() >= 94 && Koromon.getAge() >= 9){
            return new Betamon(this);

        }
        else return this;
    }
}
