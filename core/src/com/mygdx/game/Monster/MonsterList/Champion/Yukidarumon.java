package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Chimeramon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Monzaemon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Yukidarumon extends Pet {

    private final String path = "Monster/Champion/Yukidarumon.png";

    int attack = 89;
    int hp = 293;
    int age = 18;
    NormalAttack normalAttack;

    public Yukidarumon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Yukidarumon() {
        this.attack = 89;
        this.hp = 293;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Yukidarumon(Pet petBefore) {
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
    public Pet evolve(Pet Yukidarumon){
        if (Yukidarumon.getMax_hp() >= 740 && Yukidarumon.getAge() >= 36 && Yukidarumon.getAttack() >= 220 && Yukidarumon.getBattleWins() >= 20) {
            return new Monzaemon(this);
        } else if (Yukidarumon.getMax_hp() >= 690 && Yukidarumon.getAge() >= 36 && Yukidarumon.getAttack() >= 220 && Yukidarumon.getBattleWins() >= 20) {
            return new Chimeramon(this);
        }
        else return this;
    }
}
