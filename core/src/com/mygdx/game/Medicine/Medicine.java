package com.mygdx.game.Medicine;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MovingPicture;

public abstract class Medicine extends MovingPicture {

    public Medicine() {
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
