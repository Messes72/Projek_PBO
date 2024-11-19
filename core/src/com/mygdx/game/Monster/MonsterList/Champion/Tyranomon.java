package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Metaltyranomon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Skullgreymon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Tyranomon extends Pet {

    private final String path = "Monster/Champion/Tyranomon.png";

    int attack = 42;
    int hp = 199;
    int age = 18;
    NormalAttack normalAttack;

    public Tyranomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Tyranomon() {
        this.attack = 42;
        this.hp = 199;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Tyranomon(Pet petBefore) {
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
    public Pet evolve(Pet Tyranomon){
        if (Tyranomon.getMax_hp() >= 716 && Tyranomon.getAge() >= 36 && Tyranomon.getAttack() >= 220) {
            return new Metaltyranomon(this);
        } else if (Tyranomon.getMax_hp() >= 690 && Tyranomon.getAge() >= 36 && Tyranomon.getAttack() >= 170) {
            return new Skullgreymon(this);
        }
        else return this;
    }
}
