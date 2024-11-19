package com.mygdx.game.Monster.Pet;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Fresh.Botamon;
import com.mygdx.game.Monster.MonsterList.Tokomon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.MovingPicture;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;


public abstract class Pet extends MovingPicture {
    // 61 X 48 Y

    //Game
    int attack;
    int hp;
    int max_hp;
    int age;
    int hunger;
    int max_hunger;
    int stamina;
    int max_stamina;
    int battleWins;
    NormalAttack normalAttack;
    public SpecialAttack specialAttack;
    Sleep sleep;
    Pup pup;

    public Pet(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, Pup pup, int battleWins) {
        this.attack = attack;
        this.hp = hp;
        this.max_hp = max_hp;
        this.age = age;
        this.hunger = hunger;
        this.max_hunger = max_hunger;
        this.stamina = stamina;
        this.max_stamina = max_stamina;
        this.normalAttack = normalAttack;
        this.specialAttack = specialAttack;
        this.sleep = sleep;
        this.pup = pup;
        this.battleWins = battleWins;
    }

    public Pet(Pet petBefore){
        this.attack = petBefore.attack;
        this.hp = petBefore.hp;
        this.max_hp = petBefore.max_hp;
        this.age = petBefore.age;
        this.hunger = petBefore.hunger;
        this.max_hunger = petBefore.max_hunger;
        this.stamina = petBefore.stamina;
        this.max_stamina = petBefore.max_stamina;
        this.normalAttack = petBefore.normalAttack;
        this.specialAttack = petBefore.specialAttack;
        this.sleep = petBefore.sleep;
        this.pup = petBefore.pup;
        this.battleWins = petBefore.battleWins;
    }

    public Pet()
    {

    }

    public Pet(int attack, int max_hp) {
        this.attack = attack;
        this.hp = max_hp;
    }

    @Override
    public TextureRegion getCurrentFrame(float dt) {
        return super.getCurrentFrame(dt);
    }

    @Override
    protected String getPath(){
        return super.getPath();
    }
    public TextureRegion getNormalAttackFrame() {
        return normalAttack.getCurrentFrame(0);
    }

    public TextureRegion getSpecialAttackFrame() {
        return specialAttack.getCurrentFrame(0);
    }

    public TextureRegion getSleepFrame1() {
        return sleep.getFrame1();
    }

    public TextureRegion getSleepFrame2() {
        return sleep.getFrame2();
    }


//    public Pet evolve(Pet tokomon){
//        return new Botamon(5,10,10,0,5,5,5,5,normalAttack,specialAttack,sleep,pup,0);
//    }

    protected void evoAnimation(){

    }

    public int getBattleWins() {
        return battleWins;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public abstract Pet evolve(Pet Chimeramon);
}
