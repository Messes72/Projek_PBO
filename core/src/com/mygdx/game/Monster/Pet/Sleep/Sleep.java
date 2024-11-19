package com.mygdx.game.Monster.Pet.Sleep;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Sleep {
    final String path01 = "Monster/Sleep/sleepLights2.png";
    final String path02 = "Monster/Sleep/sleepLights.png";
    Texture texture1;
    Texture texture2;
    TextureRegion frame1;
    TextureRegion frame2;
    public Sleep(){
        texture1 = new Texture(Gdx.files.internal(path01));
        texture2 = new Texture(Gdx.files.internal(path02));
        frame1 = new TextureRegion(texture1);
        frame2 = new TextureRegion(texture2);

    }

    public TextureRegion getFrame1() {
        return frame1;
    }

    public TextureRegion getFrame2() {
        return frame2;
    }
}
