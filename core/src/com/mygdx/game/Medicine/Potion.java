package com.mygdx.game.Medicine;

public class Potion extends Medicine{

    private final String path = "Medicine/MEDICINE_3.png";
    public Potion() {
        super();

    }

    @Override
    protected String getPath(){
        return this.path;
    }

}
