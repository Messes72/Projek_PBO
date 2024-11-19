package com.mygdx.game.Food;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MovingPicture;

public abstract class Food extends MovingPicture {

    public Food(){
        super();
    }


    @Override
    public TextureRegion getCurrentFrame(float dt) {
        return super.getCurrentFrame(dt);
    }

    @Override
    protected String getPath(){
        return super.getPath();
    }


}
