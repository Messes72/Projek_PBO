package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Grappuleomon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Warumonzaemon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Leomon extends Pet {

    private final String path = "Monster/Champion/Leomon.png";

    int attack = 45;
    int hp = 287;
    int age = 18;
    NormalAttack normalAttack;

    public Leomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Leomon() {
        this.attack = 45;
        this.hp = 287;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Leomon(Pet petBefore) {
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
    public Pet evolve(Pet Leomon){
        if (Leomon.getMax_hp() >= 700 && Leomon.getAge() >= 36 && Leomon.getAttack() >= 280 && Leomon.getBattleWins() >= 20) {
            return new Grappuleomon(this);
        } else if (Leomon.getMax_hp() >= 780 && Leomon.getAge() >= 36 && Leomon.getAttack() >= 190 && Leomon.getBattleWins() >= 20) {
            return new Warumonzaemon(this);
        } else return this;
    }
}
