package com.mygdx.game.Monster.MonsterList.Joggress;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class ZeedMilleniummon extends Pet {
    private final String path = "Monster/Joggress/ZeedMilleniummon.png";
    int attack = 2000;
    int hp = 4000;
    int age = 54;
    NormalAttack normalAttack;


    public ZeedMilleniummon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, FindEnemies findEnemies, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public ZeedMilleniummon()
    {
        this.attack  = 2000;
        this.hp = 4000;
        this.age = 54;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public ZeedMilleniummon(Pet petBefore) {
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
    public Pet evolve(Pet Omegamon){
        if () {
            return new ZeedMilleniummon(this);
        }
        else return this;
    }
}
