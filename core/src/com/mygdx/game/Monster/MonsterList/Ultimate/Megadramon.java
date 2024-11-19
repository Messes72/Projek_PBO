package com.mygdx.game.Monster.MonsterList.Ultimate;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Mega.Machinedramon;
import com.mygdx.game.Monster.MonsterList.Mega.Metalseadramon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Megadramon extends Pet{
    private final String path = "";
    int hp = 660;
    int attack = 190;
    int age = 36;
    NormalAttack normalAttack;
    public Megadramon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Megadramon()
    {
        this.attack = 190;
        this.hp = 660;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Megadramon(Pet petBefore)
    {
        super(petBefore);
    }

    protected String getPath()
    {
        return path;
    }

    public TextureRegion getNormalAttackFrame()
    {
        return specialAttack.getCurrentFrame(0.4f * 4);
    }

    public TextureRegion getSpecialAttackFrame()
    {
        return specialAttack.getCurrentFrame(0.4f * 5);
    }

    @Override
    public Pet evolve(Pet Megadramon) {
        if (Megadramon.getAttack() >= 590 && Megadramon.getMax_hp() >= 1600 && Megadramon.getAge() >= 41 && Megadramon.getBattleWins() >= 50){
            return new Metalseadramon(this);
        }
        if (Megadramon.getAttack() >= 630 && Megadramon.getMax_hp() >= 1800 && Megadramon.getAge() >= 41 && Megadramon.getBattleWins() >= 60){
            return new Machinedramon(this);
        }
        return this;
    }
}