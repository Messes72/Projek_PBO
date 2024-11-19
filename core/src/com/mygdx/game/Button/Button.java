package com.mygdx.game.Button;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;

public class Button implements InputProcessor {

    private boolean keyPressedQ;
    private boolean keyPressedW;
    private boolean keyPressedE;
    private boolean keyPressedR;
    private boolean keyPressedT;
    private boolean keyPressedY;
    private boolean keyPressedS;
    private boolean keyPressedD;
    private boolean keyPressedSPACE;
    private boolean keyPressedNUM_1;
    private boolean keyPressedNUM_2;
    Rectangle buttonBounds = new Rectangle(0,0,1000,1000) ;

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.Q)
        {
            keyPressedQ = true;
            keyPressedW = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.W) {
            keyPressedW = true;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.E) {
            keyPressedE = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.R) {
            keyPressedR = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.T) {
            keyPressedT = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.Y) {
            keyPressedY = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.S) {
            keyPressedS = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.D) {
            keyPressedD = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;

        } else if (keycode == Input.Keys.SPACE){
            keyPressedQ = false;
            keyPressedW = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;
            keyPressedSPACE = true;
        } else if (keycode == Input.Keys.NUM_1){

            keyPressedNUM_1 = true;
        }else if (keycode == Input.Keys.NUM_2){

            keyPressedNUM_2 = true;
        }else{
            keyPressedQ = false;
            keyPressedW = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;
            keyPressedSPACE = true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if (keycode == Input.Keys.Q)
        {
            keyPressedQ = true;
            keyPressedW = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.W) {
            keyPressedW = true;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.E) {
            keyPressedE = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.R) {
            keyPressedR = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.T) {
            keyPressedT = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.Y) {
            keyPressedY = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedS = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.S) {
            keyPressedS = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedD = false;

        } else if (keycode == Input.Keys.D) {
            keyPressedD = true;
            keyPressedW = false;
            keyPressedQ = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;

        }else if (keycode == Input.Keys.SPACE) {
            keyPressedQ = false;
            keyPressedW = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;
            keyPressedSPACE = true;
        }else if (keycode == Input.Keys.NUM_1){
            keyPressedNUM_1 = true;
        }else if (keycode == Input.Keys.NUM_2){
            keyPressedNUM_2 = true;
        } else {
            keyPressedQ = false;
            keyPressedW = false;
            keyPressedE = false;
            keyPressedR = false;
            keyPressedT = false;
            keyPressedY = false;
            keyPressedS = false;
            keyPressedD = false;
            keyPressedSPACE = true;
        }
        return false;
    }


    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (buttonBounds.contains(screenX, screenY)) {
            return true;
        }
        return false;
    }



    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    public boolean isKeyPressedQ() {
        return keyPressedQ;
    }

    public boolean isKeyPressedW() {
        return keyPressedW;
    }

    public boolean isKeyPressedE() {

        return keyPressedE;
    }
    public void setIsKeyPressedE(boolean condition) {
        keyPressedE = condition;
    }

    public boolean isKeyPressedR() {
        return keyPressedR;
    }

    public boolean isKeyPressedT() {
        return keyPressedT;
    }

    public boolean isKeyPressedY() {
        return keyPressedY;
    }

    public boolean isKeyPressedS() {
        return keyPressedS;
    }
    public boolean isKeyPressedD(){
        return keyPressedD;
    }

    public boolean isKeyPressedSPACE() {
        return keyPressedSPACE;
    }

    public boolean isKeyPressedNUM_1() {
        return keyPressedNUM_1;
    }

    public boolean isKeyPressedNUM_2() {
        return keyPressedNUM_2;
    }

    public void setKeyPressedNUM_1(boolean keyPressedNUM_1) {
        this.keyPressedNUM_1 = keyPressedNUM_1;
    }

    public void setKeyPressedNUM_2(boolean keyPressedNUM_2) {
        this.keyPressedNUM_2 = keyPressedNUM_2;
    }

    public void setKeyPressedSPACE() {
        this.keyDown(Input.Keys.SPACE);
    }

}


