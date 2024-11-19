package com.mygdx.game.Training;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public abstract class Training {

    int giveStatus;
    String path;
    TextureRegion texture;

    public Training() {

    }

    protected String getPath() {
        return path;
    }

    public TextureRegion getCurrentFrame(float dt) {
        return texture;
    }

    public int giveStatus(boolean success) {
        return 0;
        }
    }


