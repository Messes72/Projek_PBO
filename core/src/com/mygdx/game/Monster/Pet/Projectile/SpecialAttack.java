package com.mygdx.game.Monster.Pet.Projectile;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MovingPicture;

public class SpecialAttack extends MovingPicture {

    final String path = "Monster/Attack/SpecialAttack.png";

    public SpecialAttack() {
        super();
    }

    public TextureRegion getCurrentFrame(float dt) {
        return super.getCurrentFrame(dt);
    }

    public String getPath(){
        return this.path;
    }


}
