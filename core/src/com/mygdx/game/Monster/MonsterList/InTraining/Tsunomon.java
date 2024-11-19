package com.mygdx.game.Monster.MonsterList.InTraining;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Rookie.Bearmon;
import com.mygdx.game.Monster.MonsterList.Rookie.Elecmon;
import com.mygdx.game.Monster.MonsterList.Rookie.Gabumon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Tsunomon  extends Pet {

    final String path = "Monster/In Training/Tsunomon.png";

    int attack = 7;
    int hp = 48;
    int age = 3;
    NormalAttack normalAttack;

    public Tsunomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Tsunomon() {
        this.attack = 7;
        this.hp = 48;
        this.age = 3;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Tsunomon(Pet petBefore) {
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
    public Pet evolve(Pet Tsunomon){
        if (Tsunomon.getMax_hp() >= 56 && Tsunomon.getAge() >= 9 && Tsunomon.getAttack() >= 19) {
            return new Elecmon(this);
        }else if (Tsunomon.getMax_hp() >= 71 && Tsunomon.getAge() >= 9 && Tsunomon.getAttack() >= 17) {
            return new Bearmon(this);
        }else if (Tsunomon.getMax_hp() >= 82 && Tsunomon.getAge() >= 9 && Tsunomon.getAttack() >= 28){
            return new Gabumon(this);
        }
        else return this;
    }
}
