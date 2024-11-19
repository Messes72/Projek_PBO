package com.mygdx.game.pet.Projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MovingPicture;

public class NormalAttack extends MovingPicture{

    final String path = "Monster/Attack/NormalAttack.png";

    public NormalAttack() {
        super();
    }

    public TextureRegion getCurrentFrame(float dt) {
        return super.getCurrentFrame(dt);
    }

    public String getPath(){
        return this.path;
    }
}
