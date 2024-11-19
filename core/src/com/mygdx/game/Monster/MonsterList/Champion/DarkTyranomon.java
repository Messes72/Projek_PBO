package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Metaltyranomon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class DarkTyranomon extends Pet {

    private final String path = "Monster/Champion/DarkTyranomon.png";

    int attack = 83;
    int hp = 262;
    int age = 18;
    NormalAttack normalAttack;

    public DarkTyranomon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep , Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public DarkTyranomon() {
        this.attack = 83;
        this.hp = 262;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public DarkTyranomon(Pet petBefore) {
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
    public Pet evolve(Pet DarkTyranomon){
        if (DarkTyranomon.getMax_hp() >= 716 && DarkTyranomon.getAge() >= 36 && DarkTyranomon.getAttack() >= 220 && DarkTyranomon.getBattleWins() >= 20) {
            return new Metaltyranomon(this);
        }
        else return this;
    }
}
