package com.mygdx.game.Monster.MonsterList.Champion;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Ultimate.Chimeramon;
import com.mygdx.game.Monster.MonsterList.Ultimate.Weregarurumon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public class Garurumon extends Pet {

    private final String path = "Monster/Champion/Garurumon.png";

    int attack = 91;
    int hp = 136;
    int age = 18;
    NormalAttack normalAttack;

    public Garurumon(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        super(attack, hp, max_hp, age, hunger, max_hunger, stamina, max_stamina, normalAttack, specialAttack, sleep, pup, battleWins);
    }

    public Garurumon() {
        this.attack = 91;
        this.hp = 136;
        this.age = 18;
        this.normalAttack = new NormalAttack();
        this.specialAttack = new SpecialAttack();
    }

    public Garurumon(Pet petBefore) {
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
    public Pet evolve(Pet Garurumon){
        if (Garurumon.getMax_hp() >= 700 && Garurumon.getAge() >= 36 && Garurumon.getAttack() >= 200 && Garurumon.getBattleWins() >= 20) {
            return new Weregarurumon(this);
        } else if (Garurumon.getMax_hp() >= 690 && Garurumon.getAge() >= 36 && Garurumon.getAttack() >= 220 && Garurumon.getBattleWins() >= 20) {
            return new Chimeramon(this);
        }
        else return this;
    }
}
