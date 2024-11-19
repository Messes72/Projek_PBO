package com.mygdx.game.pet;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MovingPicture;
import com.mygdx.game.pet.FindEnemies.FindEnemies;
import com.mygdx.game.pet.Projectile.NormalAttack;
import com.mygdx.game.pet.Projectile.SpecialAttack;
import com.mygdx.game.pet.Pup.Pup;
import com.mygdx.game.pet.Sleep.Sleep;


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
    NormalAttack normalAttack;
    SpecialAttack specialAttack;
    Sleep sleep;
    FindEnemies findEnemies;
    Pup pup;

    public Pet(int attack, int hp, int max_hp, int age, int hunger, int max_hunger, int stamina, int max_stamina, NormalAttack normalAttack, SpecialAttack specialAttack, Sleep sleep, FindEnemies findEnemies, Pup pup) {
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
        this.findEnemies = findEnemies;
        this.pup = pup;
    }

    public Pet(Pet petBefore){
        super();
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
        this.findEnemies = petBefore.findEnemies;
        this.pup = petBefore.pup;
    }

    @Override
    public TextureRegion getCurrentFrame(float dt) {
        return super.getCurrentFrame(dt);
    }

    @Override
    public String getPath(){
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

    public Pet evolve(){
        return new Tokomon(5,10,10,0,5,5,5,5,normalAttack,specialAttack,sleep,findEnemies,pup);
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

    public int getMax_hunger() {
        return max_hunger;
    }

    public void setMax_hunger(int max_hunger) {
        this.max_hunger = max_hunger;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getMax_stamina() {
        return max_stamina;
    }

    public void setMax_stamina(int max_stamina) {
        this.max_stamina = max_stamina;
    }
}
