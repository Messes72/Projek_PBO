package com.mygdx.game.Monster.MonsterList.Egg;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Monster.MonsterList.Fresh.Botamon;
import com.mygdx.game.Monster.MonsterList.Tokomon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;
import com.mygdx.game.MovingPicture;

public class YellowEgg extends Pet {

    final String path = "Monster/Egg/YellowEgg.png";

    public YellowEgg(){
        super();
    }

    @Override
    protected String getPath(){
        return this.path;
    }
    @Override
    public Pet evolve(Pet botamon){
        return new Botamon(5,10,10,0,5,5,5,5,
                new NormalAttack(), new SpecialAttack(),
                new Sleep(),
                new Pup(),0);
    }
}
