package com.mygdx.game.Training;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.Pet.Pet;

public class HPTraining extends Training {

    //GESER SARUNG TINJU DARI UJUNG KIRI KE UJUNG KANAN DENGAN CARA SPAM KLIK SEBELOM DETIK MENYENTUH ANGKA 0 dari 100
    final String punchingBagPath = "Training/punchingBag.png";



    Texture punchingBag;
    TextureRegion punchingBagFrame;


    Pet pet;
    public HPTraining(){
        punchingBag = new Texture(Gdx.files.internal(punchingBagPath));
        punchingBagFrame = new TextureRegion(punchingBag);

    }


    public TextureRegion getPunchingBagFrame() {
        return punchingBagFrame;
    }

    @Override
    public TextureRegion getCurrentFrame(float dt) {
        return getPunchingBagFrame();

    }
    @Override
    public int giveStatus(boolean success) {
        if (success) {
            return 10;
        } else {
            return 0;
        }
    }
}
