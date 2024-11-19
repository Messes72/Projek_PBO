package com.mygdx.game.Battle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Champion.*;
import com.mygdx.game.Monster.MonsterList.Fresh.Botamon;
import com.mygdx.game.Monster.MonsterList.Fresh.Punimon;
import com.mygdx.game.Monster.MonsterList.InTraining.Koromon;
import com.mygdx.game.Monster.MonsterList.InTraining.Tsunomon;
import com.mygdx.game.Monster.MonsterList.Joggress.Omegamon;
import com.mygdx.game.Monster.MonsterList.Joggress.ZeedMilleniummon;
import com.mygdx.game.Monster.MonsterList.Mega.*;
import com.mygdx.game.Monster.MonsterList.Rookie.*;
import com.mygdx.game.Monster.MonsterList.Ultimate.*;
import com.mygdx.game.Monster.Pet.Pet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class BattleArena {

    private final String pathBattleFound1 = "Battle/battleStart.png";
    private final String pathBattleFound2 = "Battle/battleStartFlash.png";

    Pet pet;
    Pet monster;
    Random rnd;

    Texture battleStart01;
    Texture battleStart02;
    TextureRegion battleStartFrame01;
    TextureRegion battleStartFrame02;

    ArrayList<Pet> listMonster = new ArrayList<>();
    {
        listMonster.add(new Botamon());
        listMonster.add(new Punimon());
        listMonster.add(new Botamon());
        listMonster.add(new Koromon());
        listMonster.add(new Tsunomon());
        listMonster.add(new Agumon());
        listMonster.add(new Bearmon());
        listMonster.add(new Betamon());
        listMonster.add(new Elecmon());
        listMonster.add(new Gabumon());
        listMonster.add(new Toy_Agumon());
        listMonster.add(new Airdramon());
        listMonster.add(new DarkTyranomon());
        listMonster.add(new Garurumon());
        listMonster.add(new Greymon());
        listMonster.add(new Grizzlymon());
        listMonster.add(new Leomon());
        listMonster.add(new Numemon());
        listMonster.add(new Seadramon());
        listMonster.add(new Tyranomon());
        listMonster.add(new Yukidarumon());
        listMonster.add(new Chimeramon());
        listMonster.add(new Grappuleomon());
        listMonster.add(new Megadramon());
        listMonster.add(new Megaseadramon());
        listMonster.add(new Metalgreymon());
        listMonster.add(new Metaltyranomon());
        listMonster.add(new Monzaemon());
        listMonster.add(new Skullgreymon());
        listMonster.add(new Warumonzaemon());
        listMonster.add(new Weregarurumon());
        listMonster.add(new Machinedramon());
        listMonster.add(new Metalgarurumon());
        listMonster.add(new Metalseadramon());
        listMonster.add(new Milleniummon());
        listMonster.add(new Saberleomon());
        listMonster.add(new Wargreymon());
        listMonster.add(new Omegamon());
        listMonster.add(new ZeedMilleniummon());
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getMonster() {
        return monster;
    }

    public void setMonster(Pet monster) {
        this.monster = monster;
    }

    public BattleArena(Pet pet) {
        rnd = new Random();
        int pilihan = rnd.nextInt(0,listMonster.size());

        battleStart01 = new Texture(Gdx.files.internal(pathBattleFound1));
        battleStart02 = new Texture(Gdx.files.internal(pathBattleFound2));

        battleStartFrame01 = new TextureRegion(battleStart01);
        battleStartFrame02 = new TextureRegion(battleStart02);

        this.pet = pet;
        this.monster = listMonster.get(pilihan);
    }

    public void petAttack(Pet attacker, Pet defender){
        int damage = attacker.getAttack() * (attacker.getAge()/100);
        defender.setHp(defender.getHp() - damage);

    }

    public TextureRegion getPetFrame(float dt){
        return pet.getCurrentFrame(dt);
    }

    public TextureRegion getMonsterFrame(float dt){
        return monster.getCurrentFrame(dt);
    }

    public TextureRegion getBattleFrame(float dt){
        if (dt <= 0.6f){
            return battleStartFrame01;
        } else {
            return battleStartFrame02;
        }
    }
}
