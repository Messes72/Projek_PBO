package com.mygdx.game.Food;

public class Fish extends Food{

    private final String path = "Food/FOOD_2.png";
    public Fish() {
        super();
    }
    @Override
    protected String getPath(){
        return this.path;
    }
}
