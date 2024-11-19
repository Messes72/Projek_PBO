package com.mygdx.game.pet;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.pet.FindEnemies.FindEnemies;
import com.mygdx.game.pet.Projectile.NormalAttack;
import com.mygdx.game.pet.Projectile.SpecialAttack;
import com.mygdx.game.pet.Pup.Pup;
import com.mygdx.game.pet.Sleep.Sleep;

public class Wargreymon extends Pet {
    final String path = "Monster/Wargreymon.png";

    public Wargreymon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, FindEnemies findEnemies, Pup pup) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, findEnemies, pup);
    }

    public Wargreymon(Pet petBefore) {
        super(petBefore);
    }
    @Override
    public String getPath(){
        return this.path;
    }
    @Override
    public TextureRegion getNormalAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 6);
    }
    @Override
    public TextureRegion getSpecialAttackFrame() {
        return specialAttack.getCurrentFrame(0.4f * 7);
    }

    @Override
    public Pet evolve(){
        return new Wargreymon(this);
    }
}
