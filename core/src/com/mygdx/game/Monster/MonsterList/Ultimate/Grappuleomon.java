package com.mygdx.game.Monster.MonsterList.Ultimate;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Mega.Saberleomon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Grappuleomon extends Pet {
    private final String path = "";

    int attack = 280;
    int hp = 700;
    int age = 36;
    NormalAttack normalAttack;
    public Grappuleomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Grappuleomon()
    {
        this.attack = 280;
        this.hp = 700;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Grappuleomon(Pet petBefore)
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
    public Pet evolve(Pet Grappuleomon) {
        if (Grappuleomon.getMax_hp() >= 1200 && Grappuleomon.getAge() >= 41 && Grappuleomon.getAttack()>500 && Grappuleomon.getBattleWins() >= 50) {
            return new Saberleomon(this);
        } else return this;
    }
}
