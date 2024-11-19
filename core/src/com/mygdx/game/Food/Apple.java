package com.mygdx.game.Food;

public class Apple extends Food{

    private final String path = "Food/FOOD_3.png";
    public Apple() {
        super();

    }

    @Override
    protected String getPath(){
        return this.path;
    }
}
