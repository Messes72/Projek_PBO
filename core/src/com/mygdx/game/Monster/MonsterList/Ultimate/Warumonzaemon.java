package com.mygdx.game.Monster.MonsterList.Ultimate;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Mega.Milleniummon;
import com.mygdx.game.Monster.MonsterList.Mega.Saberleomon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Warumonzaemon extends Pet {
    private final String path = "";
    int attack = 190;
    int hp = 780;
    int age = 36;
    NormalAttack normalAttack;

    public Warumonzaemon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Warumonzaemon()
    {
        this.attack = 190;
        this.hp = 780;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Warumonzaemon(Pet petBefore)
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
    public Pet evolve(Pet Warumonzaemon) {
        if (Warumonzaemon.getMax_hp() >= 1200 && Warumonzaemon.getAge() >= 41 && Warumonzaemon.getAttack()>500 && Warumonzaemon.getBattleWins() >= 50) {
            return new Saberleomon(this);
        } else if (Warumonzaemon.getMax_hp() >= 1800 && Warumonzaemon.getAge() >= 41 && Warumonzaemon.getAttack()>630 && Warumonzaemon.getBattleWins() >= 60) {
            return new Milleniummon(this);
        } else return this;
    }
}
