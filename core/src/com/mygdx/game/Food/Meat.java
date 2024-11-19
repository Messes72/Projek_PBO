package com.mygdx.game.Food;

public class Meat extends Food{

    private final String path = "Food/FOOD_1.png";


    public Meat() {
        super();
    }

    @Override
    protected String getPath(){
        return this.path;
    }
}
