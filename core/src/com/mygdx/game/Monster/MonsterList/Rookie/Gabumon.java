package com.mygdx.game.Monster.MonsterList.Rookie;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.Garurumon;
import com.mygdx.game.Monster.MonsterList.Champion.Yukidarumon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Gabumon extends Pet {

    private final String path = "Monster/Rookie/Gabumon.png";

    int attack = 28;
    int hp = 82;
    int age = 9;
    NormalAttack normalAttack;

    public Gabumon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Gabumon() {
        this.attack = 28;
        this.hp = 82;
        this.age = 9;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Gabumon(Pet petBefore) {
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
    public Pet evolve(Pet Gabumon){
        if (Gabumon.getMax_hp() >= 136 && Gabumon.getAge() >= 18 && Gabumon.getAttack() >= 91) {
            return new Garurumon(this);
        } else if (Gabumon.getMax_hp() >= 293 && Gabumon.getAge() >= 18 && Gabumon.getAttack() >= 89) {
            return new Yukidarumon(this);
        } else if (Gabumon.getMax_hp() >= 178 && Gabumon.getAge() >= 18 && Gabumon.getAttack() >= 65) {
            return new Garurumon(this);
        }
        else return this;
    }
}
