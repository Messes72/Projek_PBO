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

public class Monzaemon extends Pet {
    private final String path = "";
    int attack = 220;
    int hp = 740;
    int age = 36;
    NormalAttack normalAttack;

    public Monzaemon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Monzaemon()
    {
        this.attack = 220;
        this.hp = 740;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Monzaemon(Pet petBefore)
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
    public Pet evolve(Pet Monzaemon) {
        if (Monzaemon.getMax_hp() >= 1200 && Monzaemon.getAge() >= 41 && Monzaemon.getAttack()>500 && Monzaemon.getBattleWins() >= 50) {
            return new Saberleomon(this);
        } else if (Monzaemon.getMax_hp() >= 1800 && Monzaemon.getAge() >= 41 && Monzaemon.getAttack()>630 && Monzaemon.getBattleWins() >= 60) {
            return new Milleniummon(this);
        } else return this;
    }
}
