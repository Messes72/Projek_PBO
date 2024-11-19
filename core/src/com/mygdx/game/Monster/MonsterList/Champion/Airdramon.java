package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Megadramon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Metaltyranomon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Airdramon extends Pet {

    private final String path = "Monster/Champion/Airdramon.png";

    int attack = 54;
    int hp = 187;
    int age = 18;
    NormalAttack normalAttack;

    public Airdramon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Airdramon() {
        this.attack = 54;
        this.hp = 187;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Airdramon(Pet petBefore) {
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
    public Pet evolve(Pet Airdramon){
        if (Airdramon.getMax_hp() >= 714 && Airdramon.getAge() >= 36 && Airdramon.getAttack() >= 220 && Airdramon.getBattleWins() >= 20) {
            return new Metaltyranomon(this);
        } else if (Airdramon.getMax_hp() >= 660 && Airdramon.getAge() >= 36 && Airdramon.getAttack() >= 190 && Airdramon.getBattleWins() >= 20) {
            return new Megadramon(this);
        }
        else return this;
    }
}
