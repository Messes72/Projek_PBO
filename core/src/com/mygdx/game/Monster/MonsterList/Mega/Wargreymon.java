package com.mygdx.game.Monster.MonsterList.Mega;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Wargreymon extends Pet {
    final String path = "Monster/Mega/Wargreymon.png";
    int attack = 600;
    int hp = 1500;
    int age = 41;
    NormalAttack normalAttack;

    public Wargreymon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }
    public Wargreymon()
    {
        this.attack = 600;
        this.hp = 1500;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }


    public Wargreymon(Pet petBefore) {
        super(petBefore);
    }
    @Override
    protected String getPath(){
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
    public Pet evolve(Pet wargreymon){
        return this;
    }
}
