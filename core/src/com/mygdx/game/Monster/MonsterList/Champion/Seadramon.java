package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Megadramon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Megaseadramon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Seadramon extends Pet {

    private final String path = "Monster/Champion/Seadramon.png";

    int attack = 97;
    int hp = 240;
    int age = 18;
    NormalAttack normalAttack;

    public Seadramon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep , Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Seadramon() {
        this.attack = 97;
        this.hp = 240;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Seadramon(Pet petBefore) {
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
    public Pet evolve(Pet Seadramon){
        if (Seadramon.getMax_hp() >= 700 && Seadramon.getAge() >= 36 && Seadramon.getAttack() >= 200 && Seadramon.getBattleWins() >= 20) {
            return new Megaseadramon(this);
        }else if (Seadramon.getMax_hp() >= 660 && Seadramon.getAge() >= 36 && Seadramon.getAttack() >= 190 && Seadramon.getBattleWins() >= 20) {
            return new Megadramon(this);
        }
        else return this;
    }
}
