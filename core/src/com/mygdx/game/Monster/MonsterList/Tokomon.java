package com.mygdx.game.Monster.MonsterList;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Rookie.Agumon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Tokomon extends Pet { //Jenis Pet e
    private final String path = "Monster/Rookie/Bearmon.png";


    public Tokomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, FindEnemies findEnemies, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, findEnemies, pup, battleWins);
    }

    public Tokomon(Pet petBefore) {
        super(petBefore);
    }

    @Override
    protected String getPath(){
        return this.path;
    }

    @Override
    public Pet evolve(Pet tokomon){
        if (tokomon.getAttack() >= 20 && tokomon.getMax_hp() > 100 && tokomon.getAge() > 3) {
            return new Agumon(this);
        }
        else return this;
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
