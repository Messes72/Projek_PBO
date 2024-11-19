package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Battle.BattleArena;
import com.mygdx.game.Button.Button;
import com.mygdx.game.Medicine.Medicine;
import com.mygdx.game.Medicine.Pill;
import com.mygdx.game.Medicine.Potion;
import com.mygdx.game.Medicine.Tablet;
import com.mygdx.game.Monster.MonsterList.Champion.Garurumon;
import com.mygdx.game.Monster.MonsterList.Egg.BlueEgg;
import com.mygdx.game.Monster.MonsterList.Egg.YellowEgg;
import com.mygdx.game.Monster.MonsterList.Mega.Wargreymon;
import com.mygdx.game.Monster.MonsterList.Rookie.Betamon;
import com.mygdx.game.Monster.MonsterList.Rookie.Toy_Agumon;
import com.mygdx.game.Training.AttackTraining;
import com.mygdx.game.Training.HPTraining;
import com.mygdx.game.Training.Training;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;
import com.mygdx.game.Monster.MonsterList.Tokomon;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Food.*;

import java.util.Random;


public class MyGdxGame extends ApplicationAdapter {

    SpriteBatch batch;
    int chooseEgg;
    boolean egg;

    //Animation Control
    float stateTime;
    float animationTime;
    float monsterTime;
    float waitTimer;
    float refuseTimer;
    float hungerTimer;
    float battleTimer;
    float happyTimer;
    int projectileX = 270;
    int petPositionX = 275;
    boolean lookRight = true;
    boolean skip = false;


    //Tombol
    Button btn;

    //Game

    //Tulisan


    //Pet
    Pet pet;
    TextureRegion currentFrame;
    int age;

    //Food
    Food food;
    int lunch;
    float foodTimer;
    TextureRegion foodFrame;
    Medicine medicine;


    //Training
    Training training;
    TextureRegion trainingFrame;
    BitmapFont font100;
    int trainingTimer;
    int trainingPosition;
    boolean choice;
    boolean petTrainFinish;

    //Sleep
    TextureRegion sleepFrame;
    float sleepTimer;

    //Clicking
    int screenX;
    int screenY;

    //Firing
    TextureRegion currentFireFrame;

    //Battle
    BattleArena battleArena;
    TextureRegion currentArenaFrame;
    TextureRegion currentMonsterFrame;
    int monsterPosition;

    //Begron
    TextureRegion background;
    TextureRegion digivice;
    TextureRegion YellowEgg;
    TextureRegion BlueEgg;

    @Override
    public void create() {
        batch = new SpriteBatch();
        background = new TextureRegion(new Texture("Background/grassplainbackground.png"));
        digivice = new TextureRegion(new Texture("Background/orangeShell.png"));
        btn = new Button();
        font100 = new BitmapFont(Gdx.files.internal("projectFont.fnt"));
        Gdx.input.setInputProcessor(btn);
        egg = true;
        YellowEgg = new TextureRegion(new Texture("Background/YellowEgg.png"));
        BlueEgg = new TextureRegion(new Texture("Background/BlueEgg.png"));
        pet = new Toy_Agumon(5, 10, 10, 0, 5, 5, 5, 5, new NormalAttack(), new SpecialAttack(), new Sleep(),  new Pup(), 0);

        petTrainFinish = true;
    }

    @Override
    public void render() {

        waitTimer += Gdx.graphics.getDeltaTime();
        stateTime += Gdx.graphics.getDeltaTime();
        animationTime += Gdx.graphics.getDeltaTime();
        hungerTimer += Gdx.graphics.getDeltaTime();
        battleTimer += Gdx.graphics.getDeltaTime();
        monsterTime += Gdx.graphics.getDeltaTime();
        ScreenUtils.clear(1, 1, 1, 1);

        batch.begin();
        batch.draw(background, 50, -120, Gdx.graphics.getWidth(), Gdx.graphics.getWidth());

        if (btn.isKeyPressedT()) { // Cari musuh

            if (Gdx.input.isKeyJustPressed(Input.Keys.T)){
                battleTimer = 0f;
                battleArena = new BattleArena(pet);
                monsterPosition = 50;
                monsterTime = 0;
            }

            if (battleTimer <= 3f){
                petIdle();
                if (monsterPosition <= 150) {
                    monsterPosition += 1;
                }
                currentMonsterFrame = battleArena.getMonsterFrame(animationTime);
                batch.draw(currentMonsterFrame, monsterPosition, 130, 61 / 2, 48 / 2, -61, 48, 1f, 1f, 0f);
            } else if (battleTimer <= 7.2f) {

                if (animationTime >= 1.2f) {
                    animationTime = 0f;
                }
                currentArenaFrame = battleArena.getBattleFrame(animationTime);
                batch.draw(currentArenaFrame, 80, 88, 330, 295);
            } else if (battleTimer <= 8.2f){
                currentArenaFrame = battleArena.getBattleFrame(0.9f);
                batch.draw(currentArenaFrame, 80, 88, 330, 295);
            } else if (battleTimer <= 10f) {
                if (animationTime >= 0.4f * 2){
                    animationTime = 0.4f * 0;
                }
                currentFrame = battleArena.getPetFrame(animationTime);
                batch.draw(currentFrame, 330, 130, 61 / 2, 48 / 2, 61, 48, 1f, 1f, 0f);
                currentMonsterFrame = battleArena.getMonsterFrame(animationTime);
                batch.draw(currentMonsterFrame, 150, 130, 61 / 2, 48 / 2, -61, 48, 1f, 1f, 0f);
            } else {
                animationTime = 0.4f * 6;
                if (battleArena.getMonster().getHp() > 0){
                    if (monsterTime >= 0.4f * 2){
                        monsterTime = 0.4f * 0;
                    }
                    currentFrame = battleArena.getPetFrame(animationTime);
                    batch.draw(currentFrame, 330, 130, 61 / 2, 48 / 2, 61, 48, 1f, 1f, 0f);
                    currentMonsterFrame = battleArena.getMonsterFrame(monsterTime);
                    batch.draw(currentMonsterFrame, 150, 130, 61 / 2, 48 / 2, -61, 48, 1f, 1f, 0f);


                }
                System.out.println(battleArena.getMonster().getHp());
            }
        }


        batch.draw(digivice, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        //GAME

        if (false) checkEgg();
        else {
            //TIMER

            if (stateTime >= 2f) {
                age = pet.getAge() + 1;
                pet.setAge(age);
                stateTime = 0;
            }

            if (hungerTimer >= 30f) {
                if (pet.getHunger() >= 0) {
                    int hunger = pet.getHunger() - 1;
                    pet.setHunger(hunger);
                    hungerTimer = 0;
                } else {
                    int hp = pet.getHp() - 1;
                    pet.setHp(hp);
                    hungerTimer = 0;
                }

            }

            //Button Press
            if (btn.isKeyPressedQ()) {
                if (pet.getHunger() + 25 <= 100) {
                    petEat();
                } else {
                    refuse();
                }
            }

            else if (btn.isKeyPressedW()) {
                if (pet.getHp() >= pet.getMax_hp()) {
                    refuse();
                } else {
                    petHeal();
                }
            }

            else if (btn.isKeyPressedE()) {

                if ((pet.getStamina() - 10 <= 0 || pet.getHunger() - 5 <= 0) && petTrainFinish) {
                    refuse();
                } else {
                    petTrain();
                }
            }

            else if (btn.isKeyPressedR()) {
                if (pet.getStamina() >= 100) {
                    refuse();
                } else {
                    petSleep();
                }
            }

            else if (Gdx.input.isKeyPressed(Input.Keys.S)){
                showPetStatus();
            }

            else if (btn.isKeyPressedD()){
                happy();
            }

            else if (!btn.isKeyPressedT()){
                petIdle();
                pet = pet.evolve(pet);
            }

        }


        batch.end();
    }


    private void checkEgg() {
        if (btn.isKeyPressedNUM_1()) {
            pet = new YellowEgg();
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);

            if (animationTime > 0.4f * 11) {
                pet = pet.evolve(pet);
                egg = false;
            }

        } else if (btn.isKeyPressedNUM_2()) {
            pet = new BlueEgg();
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);

            if (animationTime > 0.4f * 11) {
                pet = pet.evolve(pet);
                egg = false;
            }

        } else {
            font100.setColor(Color.BLACK);
            font100.getData().setScale(1.5f, 1.5f);
            font100.draw(batch, "CHOOSE EGG", 170, 250);
            font100.draw(batch, "PRESS 1", 110, 200);
            font100.draw(batch, "PRESS 2", 270, 200);
            batch.draw(YellowEgg, 140, 120);
            batch.draw(BlueEgg, 300, 120);
            animationTime = 0;
        }
    }

    private void petHeal() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            Random rnd = new Random();
            lunch = rnd.nextInt(1, 4);
            foodTimer = 0;
            animationTime = 0;
            waitTimer = 0;
            skip = false;
        }

        if (animationTime > 0.4f * 9) {
            animationTime = 0.4f * 7;
            foodTimer += 0.4f;
        } else if (animationTime < 0.4f * 7) {
            animationTime = 0.4f * 7;

        }

        if (lunch == 1) {
            medicine = new Pill();
        } else if (lunch == 2) {
            medicine = new Tablet();
        } else {
            medicine = new Potion();
        }

        if (foodTimer <= 0.4f * 3) {
            foodFrame = medicine.getCurrentFrame(foodTimer);
            batch.draw(foodFrame, 170, 160);
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);
        } else {
            foodFrame = medicine.getCurrentFrame(0.4f * 3);
            batch.draw(foodFrame, 170, 160);
            animationTime = 0.4f * 5;
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);
            if (!skip) {
                int hp = pet.getHp() + (pet.getMax_hp() / 2);
                pet.setHp(hp);
                if (pet.getHp() >= pet.getMax_hp()) {
                    pet.setHp(pet.getMax_hp());
                }
            }
            skip = true;
        }
        if (waitTimer >= 4f) {
            btn.setKeyPressedSPACE();
        }
    }


    private void showPetStatus() {
        font100.setColor(Color.BLACK);
        font100.getData().setScale(1, 1);
        font100.draw(batch, "Attack            :   " + String.valueOf(pet.getAttack()), 100, 300);
        font100.draw(batch, "HP/ Max HP  :   " + String.valueOf(pet.getHp()) + "/" + String.valueOf(pet.getMax_hp()), 100, 280);
        font100.draw(batch, "Age                 :   " + String.valueOf(pet.getAge()), 100, 260);
        font100.draw(batch, "Hunger          :   " + String.valueOf(pet.getHunger()) + "%", 100, 240);
        font100.draw(batch, "Stamina         :   " + String.valueOf(pet.getStamina()) + "%", 100, 220);
        animationTime = 0.4f * 0;
        currentFrame = pet.getCurrentFrame(animationTime);
        batch.draw(currentFrame, 400, 130, 61 / 2, 48 / 2, -61 * 2, 48 * 2, 1f, 1f, 0f);
    }

    private void petEat() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            Random rnd = new Random();
            lunch = rnd.nextInt(1, 4);
            foodTimer = 0;
            animationTime = 0;
            waitTimer = 0;
            skip = false;
        }

        if (animationTime > 0.4f * 9) {
            animationTime = 0.4f * 7;
            foodTimer += 0.4f;
        } else if (animationTime < 0.4f * 7) {
            animationTime = 0.4f * 7;

        }

        if (lunch == 1) {
            food = new Apple();
        } else if (lunch == 2) {
            food = new Fish();
        } else if (lunch == 3) {
            food = new Meat();
        }

        if (foodTimer <= 0.4f * 3) {
            foodFrame = food.getCurrentFrame(foodTimer);
            batch.draw(foodFrame, 170, 160);
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);
        } else {
            foodFrame = food.getCurrentFrame(0.4f * 3);
            batch.draw(foodFrame, 170, 160);
            animationTime = 0.4f * 5;
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);
            if (!skip) {
                int hunger = pet.getHunger() + 25;
                pet.setHunger(hunger);
            }
            skip = true;
        }
        if (waitTimer >= 4f) {
            btn.setKeyPressedSPACE();
        }
    }


    private void petIdle() {
        //IDLE BEHAVIOUR

        //Animation Control
        if (animationTime > 0.4f * 2) {
            animationTime = 0;

        }
        //WALK RIGHT
        if (lookRight) {
            if (petPositionX < 400) {
                waitTimer = 0;
                petPositionX += 1;
                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, petPositionX, 130, 61 / 2, 48 / 2, -61, 48, 1f, 1f, 0f);
            }
            if (petPositionX >= 400) {
                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, petPositionX, 130, 61 / 2, 48 / 2, -61, 48, 1f, 1f, 0f);
                if (waitTimer >= 4f) {

                    lookRight = false;
                    petPositionX -= 61;
                }
            }

            //WALK LEFT
        } else if (!lookRight) {

            if (petPositionX > 100) {

                waitTimer = 0;
                petPositionX -= 1;
                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, petPositionX, 130, 61 / 2, 48 / 2, 61, 48, 1f, 1f, 0f);
            } else if (petPositionX <= 100) {

                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, petPositionX, 130, 61 / 2, 48 / 2, 61, 48, 1f, 1f, 0f);
                if (waitTimer >= 4f) {
                    lookRight = true;
                    petPositionX += 61;
                }
            }
        }
    }

    private void petSleep() {
        sleepTimer += Gdx.graphics.getDeltaTime();
        // Tidur R
        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            waitTimer = 0;
            sleepTimer = 0;
        }
        font100.getData().setScale(1, 1);
        font100.draw(batch, "Stamina  :   " + String.valueOf(pet.getStamina()) + "%", 186, 250);

        if (pet.getStamina() < 100) {

            if (waitTimer > 0.4f) {
                sleepFrame = pet.getSleepFrame2();
                if (waitTimer > 0.8f) {
                    waitTimer = 0;
                }

            } else {
                sleepFrame = pet.getSleepFrame1();
            }
            if (animationTime > 0.4f * 4) {
                animationTime = 0.4f * 2;

            } else if (animationTime < 0.4f * 2) {
                animationTime = 0.4f * 2;

            }

            //STAMINA GAIN
            if (sleepTimer >= 0.2f) {
                int stamina = pet.getStamina() + 1;
                pet.setStamina(stamina);
                sleepTimer = 0;
            }

            batch.draw(sleepFrame, 270, 174, 0, 0, 25, 25, 1f, 1f, 0f);
            currentFrame = pet.getCurrentFrame(animationTime);
            batch.draw(currentFrame, 275 - 61, 130);
        } else {
            btn.setKeyPressedSPACE();
        }
    }


    private void petTrain() {
        //RESET TIAP PENCET E
        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            waitTimer = 0;
            trainingTimer = 0;
            screenX = -9999;
            screenY = -9999;
            projectileX = 270;
            skip = false;
            btn.setKeyPressedNUM_1(false);
            btn.setKeyPressedNUM_2(false);
            choice = false;
            petTrainFinish = false;
        }

        if (btn.isKeyPressedNUM_1() && !choice) {

            //Latihan Attack
            training = new AttackTraining();

            if (trainingTimer > 100) {
                trainingTimer = 0;
            }

            if (Gdx.input.justTouched()) {
                screenX = Gdx.input.getX();
                screenY = Gdx.input.getY();
            }

            if (btn.touchDown(screenX, screenY, 1, Input.Buttons.LEFT)) {

                // FREEZE

                font100.setColor(Color.BLACK);
                font100.getData().setScale(3, 3);
                font100.draw(batch, String.valueOf(trainingTimer), 200, 220);


                if (projectileX > 110) {
                    animationTime = 0.4f * 6;
                    projectileX -= 1.4f;

                    currentFireFrame = pet.getNormalAttackFrame();
                    batch.draw(currentFireFrame, projectileX, 150);

                    trainingFrame = training.getCurrentFrame(0);
                    batch.draw(trainingFrame, 100, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

                    currentFrame = pet.getCurrentFrame(animationTime);
                    batch.draw(currentFrame, 300, 130);

                    // Lebih dari 80 bag ancur
                } else if (projectileX <= 110 && trainingTimer >= 80) {
                    trainingFrame = training.getCurrentFrame(1);
                    animationTime = 0.4f * 5;
                    batch.draw(trainingFrame, 100, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 55, 1f, 1f, 0f);
                    font100.draw(batch, "Attack +2", 140, 300);
                    if (!skip) {
                        pet.setAttack(pet.getAttack() + training.giveStatus(true) + 10000);
                        pet.setStamina(pet.getStamina() - 10);
                        waitTimer = 0;
                        int hunger = pet.getHunger() - 5;
                        pet.setHunger(hunger);
                    }
                    currentFrame = pet.getCurrentFrame(animationTime);
                    batch.draw(currentFrame, 300, 130);
                    skip = true;


                    // kurang dari 80 bag tetep utuh
                } else {
                    animationTime = 0.4f * 6;
                    trainingFrame = training.getCurrentFrame(0);
                    batch.draw(trainingFrame, 100, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

                    font100.draw(batch, ":(", 200, 300);
                    if (!skip) {
                        pet.setAttack(pet.getAttack() + training.giveStatus(false));
                        pet.setStamina(pet.getStamina() - 10);
                        waitTimer = 0;
                        int hunger = pet.getHunger() - 5;
                        pet.setHunger(hunger);
                    }

                    currentFrame = pet.getCurrentFrame(animationTime);
                    batch.draw(currentFrame, 300, 130);

                    trainingFrame = training.getCurrentFrame(0);
                    batch.draw(trainingFrame, 100, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);
                    skip = true;
                }

            } else if (projectileX == 270) {
                animationTime = 0.4f * 7;
                trainingTimer += 1;
                font100.setColor(Color.BLACK);
                font100.getData().setScale(3, 3);
                font100.draw(batch, String.valueOf(trainingTimer), 200, 220);

                trainingFrame = training.getCurrentFrame(0);
                batch.draw(trainingFrame, 100, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, 300, 130);

            }

        } else if (btn.isKeyPressedNUM_2()) {

            training = new HPTraining();
            if (!choice) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
                    trainingTimer = 150;
                    trainingPosition = 150;
                    waitTimer = 0;
                    choice = true;
                }
            }
            if (!skip) {
                trainingTimer -= 1;
                font100.setColor(Color.BLACK);
                font100.getData().setScale(3, 3);
                font100.draw(batch, String.valueOf(trainingTimer), 200, 220);
            }
            if (Gdx.input.justTouched()) {
                screenX = Gdx.input.getX();
                screenY = Gdx.input.getY();
            }


            if (btn.touchDown(screenX, screenY, 1, Input.Buttons.LEFT) && trainingTimer > 0 && trainingPosition < 370) {
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) {
                    waitTimer = 0;
                }
                trainingPosition += 4;
                animationTime = 0.4f * 4;
                trainingFrame = training.getCurrentFrame(0);
                batch.draw(trainingFrame, trainingPosition, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, trainingPosition + 10, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);
                //ngesot
                if (waitTimer >= 0.1f) {
                    waitTimer = 0;
                    screenX = -9999;
                    screenY = -9999;
                }

                //berhasil
            } else if (trainingPosition >= 370) {
                trainingFrame = training.getCurrentFrame(0);
                animationTime = 0.4f * 5;
                trainingFrame = training.getCurrentFrame(0);
                batch.draw(trainingFrame, trainingPosition, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, trainingPosition + 10, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);

                font100.draw(batch, "HP +10", 140, 300);
                if (!skip) {
                    pet.setMax_hp(pet.getMax_hp() + training.giveStatus(true) + 10000);
                    waitTimer = 0;
                    pet.setStamina(pet.getStamina() - 10);
                    int hunger = pet.getHunger() - 5;
                    pet.setHunger(hunger);
                }
                skip = true;

                //gagal
            } else if (trainingPosition < 370 && trainingTimer <= 0) {
                animationTime = 0.4f * 4;
                trainingFrame = training.getCurrentFrame(0);
                batch.draw(trainingFrame, trainingPosition, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, trainingPosition + 10, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);

                font100.draw(batch, ":(", 200, 300);
                if (!skip) {
                    pet.setMax_hp(pet.getMax_hp() + training.giveStatus(false));
                    waitTimer = 0;
                    int hunger = pet.getHunger() - 5;
                    pet.setHunger(hunger);

                }
                skip = true;
            } else {
                animationTime = 0.4f * 1;
                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, trainingPosition + 20, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);
                trainingFrame = training.getCurrentFrame(0);
                batch.draw(trainingFrame, trainingPosition, 120, Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 30, 80, 1f, 1f, 0f);

            }

        } else {
            font100.setColor(Color.BLACK);
            font100.getData().setScale(1.2f, 1.2f);
            font100.draw(batch, "PRESS 1 FOR ATTACK TRAINING ", 100, 240);
            font100.draw(batch, "PRESS 2 FOR HP TRAINING ", 100, 200);
        }

        if (waitTimer > 2f && skip) {
            petTrainFinish = true;
            btn.setKeyPressedSPACE();
        }
    }

    private void refuse() {
        animationTime = 0.4f * 4;
        currentFrame = pet.getCurrentFrame(animationTime);

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            waitTimer = 0;
            refuseTimer = 0;
        }
        refuseTimer += Gdx.graphics.getDeltaTime();

        if (refuseTimer < 2.0f) {
            if (waitTimer > 0.4f) {
                batch.draw(currentFrame, 275, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);
                if (waitTimer > 0.8f) {
                    waitTimer = 0;
                }
            } else {
                batch.draw(currentFrame, 275 - 61, 130, 61 / 2f, 48 / 2f, 61, 48, 1f, 1f, 0f);
            }
        } else {
            btn.setKeyPressedSPACE();
        }
    }

    private void happy() {

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            waitTimer = 0;
            happyTimer = 0;
        }
        happyTimer += Gdx.graphics.getDeltaTime();

        if (happyTimer < 2.4f) {
            if (waitTimer <= 0.4f) {
                animationTime = 0.4f * 5;
                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, 275, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);

            } else {
                animationTime = 0.4f * 7;
                currentFrame = pet.getCurrentFrame(animationTime);
                batch.draw(currentFrame, 275, 130, 61 / 2f, 48 / 2f, -61, 48, 1f, 1f, 0f);
                if (waitTimer > 0.8f) {
                    waitTimer = 0;
                }
            }
        } else {
            btn.setKeyPressedSPACE();
        }
    }

    @Override
    public void dispose() {

        batch.dispose();

    }
}