package com.mygdx.game.Monster.MonsterList.Rookie;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.Garurumon;
import com.mygdx.game.Monster.MonsterList.Champion.Grizzlymon;
import com.mygdx.game.Monster.MonsterList.Champion.Yukidarumon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Bearmon extends Pet {

    private final String path = "Monster/Rookie/Bearmon.png";

    int attack = 17;
    int hp = 71;
    int age = 9;
    NormalAttack normalAttack;

    public Bearmon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Bearmon() {
        this.attack = 17;
        this.hp = 71;
        this.age = 9;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Bearmon(Pet petBefore) {
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
    public Pet evolve(Pet Bearmon){
        if (Bearmon.getMax_hp() >= 143 && Bearmon.getAge() >= 18 && Bearmon.getAttack() >= 76) {
            return new Grizzlymon(this);
        } else if (Bearmon.getMax_hp() >= 293 && Bearmon.getAge() >= 18 && Bearmon.getAttack() >= 89) {
            return new Yukidarumon(this);
        } else if (Bearmon.getMax_hp() >= 178 && Bearmon.getAge() >= 18 && Bearmon.getAttack() >= 65) {
            return new Garurumon(this);
        }
        else return this;
    }
}
