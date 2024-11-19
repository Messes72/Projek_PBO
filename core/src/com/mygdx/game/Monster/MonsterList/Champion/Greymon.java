package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Metalgreymon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Skullgreymon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Greymon extends Pet {

    private final String path = "Monster/Champion/Greymon.png";

    int attack = 36;
    int hp = 225;
    int age = 18;
    NormalAttack normalAttack;

    protected Greymon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Greymon() {
        this.attack = 36;
        this.hp = 225;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Greymon(Pet petBefore) {
        super(petBefore);
    }

    @Override
    public String getPath(){
        return this.path;
    }

    @Override
    public Pet evolve(Pet greymon) {
        if (greymon.getMax_hp() >= 760 && greymon.getAge() >= 36 && greymon.getAttack() >= 210 && greymon.getBattleWins() >= 20) {
            return new Metalgreymon(this);
        } else if (greymon.getMax_hp() >= 690 && greymon.getAge() >= 36 && greymon.getAttack() >= 170 && greymon.getBattleWins() >= 20) {
            return new Skullgreymon(this);
        } else return this;
    }
    @Override
    public TextureRegion getNormalAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 1);
    }
    @Override
    public TextureRegion getSpecialAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 2);
    }

}
