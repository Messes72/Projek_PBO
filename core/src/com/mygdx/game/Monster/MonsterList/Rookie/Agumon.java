package com.mygdx.game.Monster.MonsterList.Rookie;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.DarkTyranomon;
import com.mygdx.game.Monster.MonsterList.Champion.Greymon;
import com.mygdx.game.Monster.MonsterList.Champion.Tyranomon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Agumon extends Pet {

    private final String path = "Monster/Rookie/Agumon.png";

    int attack = 27;
    int hp = 103;
    int age = 9;
    NormalAttack normalAttack;

    public Agumon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Agumon() {
        this.attack = 27;
        this.hp = 103;
        this.age = 9;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Agumon(Pet petBefore) {
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
    public Pet evolve(Pet agumon){
        if (agumon.getMax_hp() >= 225 && agumon.getAge() >= 18 && agumon.getAttack() >= 36) {
            return new Greymon(this);
        } else if (agumon.getMax_hp() >= 199 && agumon.getAge() >= 18 && agumon.getAttack() >= 42){
            return new Tyranomon(this);
        } else if (agumon.getMax_hp() >= 262 && agumon.getAge() >= 18 && agumon.getAttack() >= 83){
            return new DarkTyranomon(this);
        } else return this;
    }
}
