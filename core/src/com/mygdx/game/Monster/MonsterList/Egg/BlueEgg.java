package com.mygdx.game.Monster.MonsterList.Egg;

import com.mygdx.game.Monster.MonsterList.Fresh.Punimon;
import com.mygdx.game.Monster.MonsterList.Tokomon;
import com.mygdx.game.Monster.Pet.FindEnemies.FindEnemies;
import com.mygdx.game.Monster.Pet.Pet;
import com.mygdx.game.Monster.Pet.Projectile.NormalAttack;
import com.mygdx.game.Monster.Pet.Projectile.SpecialAttack;
import com.mygdx.game.Monster.Pet.Pup.Pup;
import com.mygdx.game.Monster.Pet.Sleep.Sleep;

public class BlueEgg extends Pet {
    final String path = "Monster/Egg/BlueEgg.png";

    public BlueEgg() {
        super();
    }

    @Override
    protected String getPath(){
        return this.path;
    }

    @Override
    public Pet evolve(Pet punimon){
        return new Punimon(5,10,10,0,5,5,5,5,
                new NormalAttack(), new SpecialAttack(),
                new Sleep(),
                new Pup(),0);
    }
}
