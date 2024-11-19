package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Monzaemon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Warumonzaemon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Grizzlymon extends Pet {

    private final String path = "Monster/Champion/Grizzlymon.png";

    int attack = 76;
    int hp = 143;
    int age = 18;
    NormalAttack normalAttack;

    public Grizzlymon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Grizzlymon() {
        this.attack = 76;
        this.hp = 143;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Grizzlymon(Pet petBefore) {
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
    public Pet evolve(Pet Grizzlymon){
        if (Grizzlymon.getMax_hp() >= 740 && Grizzlymon.getAge() >= 36 && Grizzlymon.getAttack() >= 220 && Grizzlymon.getBattleWins() >= 20) {
            return new Monzaemon(this);
        } else if (Grizzlymon.getMax_hp() >= 780 && Grizzlymon.getAge() >= 36 && Grizzlymon.getAttack() >= 190 && Grizzlymon.getBattleWins() >= 20) {
            return new Warumonzaemon(this);
        }
        else return this;
    }
}
