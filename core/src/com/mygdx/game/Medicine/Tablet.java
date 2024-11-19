package com.mygdx.game.Medicine;

public class Tablet extends Medicine{

    private final String path = "Medicine/MEDICINE_2.png";
    public Tablet() {
        super();

    }

    @Override
    protected String getPath(){
        return this.path;
    }


}
