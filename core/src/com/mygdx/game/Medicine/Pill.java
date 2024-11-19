package com.mygdx.game.Medicine;

public class Pill extends Medicine{

    private final String path = "Medicine/MEDICINE_1.png";
    public Pill() {
        super();

    }

    @Override
    protected String getPath(){
        return this.path;
    }


}
