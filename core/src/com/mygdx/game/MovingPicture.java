package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;

public abstract class MovingPicture {
    private static final int FRAME_COLS = 11, FRAME_ROWS = 1;
    Texture texture;
    Animation<TextureRegion> animation;
    float stateTime;
    String path;

    public MovingPicture() {
        texture = new Texture(Gdx.files.internal(getPath()));
        TextureRegion[][] tmp = TextureRegion.split(texture,
                texture.getWidth()/ FRAME_COLS,
                texture.getHeight()/FRAME_ROWS);


        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS*FRAME_ROWS];
        int index = 0;
        for(int i = 0; i< FRAME_ROWS; i++){
            for (int j= 0; j<FRAME_COLS; j++){
                walkFrames[index++] = tmp[i][j];
            }
        }

        animation = new Animation<TextureRegion>(0.4f,walkFrames);
        stateTime = 0;

    }

    public TextureRegion getCurrentFrame(float dt) {
        return animation.getKeyFrame(dt, true);
    }

    protected String getPath(){
        return this.path;
    }
}
