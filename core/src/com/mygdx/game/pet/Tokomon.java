package com.mygdx.game.pet;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.pet.FindEnemies.FindEnemies;
import com.mygdx.game.pet.Projectile.NormalAttack;
import com.mygdx.game.pet.Projectile.SpecialAttack;
import com.mygdx.game.pet.Pup.Pup;
import com.mygdx.game.pet.Sleep.Sleep;


public class Tokomon extends Pet{ //Jenis Pet e
    final String path = "Monster/inTraining.png";


    public Tokomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, FindEnemies findEnemies, Pup pup) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, findEnemies, pup);
    }

    public Tokomon(Pet petBefore) {
        super(petBefore);
    }

    @Override
    public String getPath(){
        return this.path;
    }

    @Override
    public Pet evolve(){
        return new Agumon(this);
    }

    @Override
    public TextureRegion getNormalAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 0);
    }
    @Override
    public TextureRegion getSpecialAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 1);
    }

}
