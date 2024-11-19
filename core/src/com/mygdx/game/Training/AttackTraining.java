package com.mygdx.game.Training;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AttackTraining extends Training{

    final String punchingBagPath = "Training/punchingBag.png";
    final String punchingBagBrokenPath = "Training/punchingBagBroken.png";


    Texture punchingBag;
    Texture punchingBagBroken;
    TextureRegion punchingBagFrame;
    TextureRegion punchingBagBrokenFrame;

    public AttackTraining(){

        punchingBag = new Texture(Gdx.files.internal(punchingBagPath));
        punchingBagFrame = new TextureRegion(punchingBag);

        punchingBagBroken = new Texture(Gdx.files.internal(punchingBagBrokenPath));
        punchingBagBrokenFrame = new TextureRegion(punchingBagBroken);



    }


    public TextureRegion getPunchingBagFrame() {
        return punchingBagFrame;
    }

    public TextureRegion getPunchingBagBrokenFrame() {
        return punchingBagBrokenFrame;
    }

    @Override
    public TextureRegion getCurrentFrame(float dt) {
        if(dt == 0){
            return getPunchingBagFrame();
        } else {
            return getPunchingBagBrokenFrame();
        }
    }
    @Override
    public int giveStatus(boolean success) {
        if (success) {
            return 2;
        } else {
            return 0;
        }
    }
}
