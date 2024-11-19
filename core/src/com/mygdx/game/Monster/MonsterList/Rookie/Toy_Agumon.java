package com.mygdx.game.Monster.MonsterList.Rookie;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.Airdramon;
import com.mygdx.game.Monster.MonsterList.Champion.DarkTyranomon;
import com.mygdx.game.Monster.MonsterList.Champion.Tyranomon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Toy_Agumon extends Pet {

    private final String path = "Monster/Rookie/ToyAgumon.png";

    int attack = 23;
    int hp = 63;
    int age = 9;
    NormalAttack normalAttack;

    public Toy_Agumon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Toy_Agumon() {
        this.attack = 23;
        this.hp = 63;
        this.age = 9;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Toy_Agumon(Pet petBefore) {
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
    public Pet evolve(Pet Toy_Agumon){
        if (Toy_Agumon.getMax_hp() >= 199 && Toy_Agumon.getAge() >= 18 && Toy_Agumon.getAttack() >= 42) {
            return new Tyranomon(this);
        } else if (Toy_Agumon.getMax_hp() >= 187 && Toy_Agumon.getAge() >= 18 && Toy_Agumon.getAttack() >= 54) {
            return new Airdramon(this);
        } else if (Toy_Agumon.getMax_hp() >= 262 && Toy_Agumon.getAge() >= 18 && Toy_Agumon.getAttack() >= 83) {
            return new DarkTyranomon(this);
        }
        else return this;
    }
}
