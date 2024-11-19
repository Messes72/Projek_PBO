package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Monzaemon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Numemon extends Pet {

    private final String path = "Monster/Champion/Numemon.png";

    int attack = 65;
    int hp = 178;
    int age = 18;
    NormalAttack normalAttack;

    public Numemon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Numemon() {
        this.attack = 65;
        this.hp = 178;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Numemon(Pet petBefore) {
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
    public Pet evolve(Pet Numemon){
        if (Numemon.getMax_hp() >= 740 && Numemon.getAge() >= 36 && Numemon.getAttack() >= 220 && Numemon.getBattleWins() >= 20) {
            return new Monzaemon(this);
        }
        else return this;
    }
}
