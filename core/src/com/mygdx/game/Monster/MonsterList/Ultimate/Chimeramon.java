package com.mygdx.game.Monster.MonsterList.Ultimate;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Mega.Metalgarurumon;
import com.mygdx.game.Monster.MonsterList.Mega.Milleniummon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class Chimeramon extends Pet{
    private final String path = "";
    int attack = 220;
    int hp = 690;
    int age = 36;
    NormalAttack normalAttack;

    public Chimeramon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Chimeramon()
    {
        this.attack = 220;
        this.hp = 690;
        this.age = 36;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

//    namaPet{
//        this.attack = (nilai attack monster e)
//        this.hp = (nilai max hp monster e)
//        this.normalAttack = new normal attackk
//        this.specialAttack = new Specialattack
//    }

    public Chimeramon(Pet petBefore)
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
    public Pet evolve(Pet Chimeramon) {
        if (Chimeramon.getMax_hp() >= 1500 && Chimeramon.getAge() >= 41 && Chimeramon.getAttack()>= 600 && Chimeramon.getBattleWins() >= 50) {
            return new Metalgarurumon(this);
        } else if (Chimeramon.getMax_hp() >= 1800 && Chimeramon.getAge() >= 41 && Chimeramon.getAttack()>= 630 && Chimeramon.getBattleWins() >= 60) {
            return new Milleniummon(this);
        } else return this;
    }
}
