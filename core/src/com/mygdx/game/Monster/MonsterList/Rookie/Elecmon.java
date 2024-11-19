package com.mygdx.game.Monster.MonsterList.Rookie;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.*;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Elecmon extends Pet {

    private final String path = "Monster/Rookie/Elecmon.png";

    int attack = 19;
    int hp = 56;
    int age = 9;
    NormalAttack normalAttack;

    public Elecmon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Elecmon() {
        this.attack = 19;
        this.hp = 56;
        this.age = 9;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Elecmon(Pet petBefore) {
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
    public Pet evolve(Pet Elecmon){
        if (Elecmon.getMax_hp() >= 287 && Elecmon.getAge() >= 18 && Elecmon.getAttack() >= 45) {
            return new Leomon(this);
        } else if (Elecmon.getMax_hp() >= 143 && Elecmon.getAge() >= 18 && Elecmon.getAttack() >= 76) {
            return new Grizzlymon(this);
        } else if (Elecmon.getMax_hp() >= 178 && Elecmon.getAge() >= 18 && Elecmon.getAttack() >= 65) {
            return new Numemon(this);
        }
        else return this;
    }
}
