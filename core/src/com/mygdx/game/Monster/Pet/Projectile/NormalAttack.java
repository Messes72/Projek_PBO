package com.mygdx.game.Monster.Pet.Projectile;

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
