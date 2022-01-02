package com.example.project;

import javafx.scene.image.ImageView;

public class Enemy extends Character{
    private int hp;

    public Enemy(ImageView EnemyImage){
        super(EnemyImage);
        this.hp = 100;
    }

    @Override
    public void playerCollide() {
        translating(getimage(), 300, 0 , false, false ,1 );
        if (this.hp == 0 ){
            getimage().imageProperty().set(null);
        }
        this.hp = this.hp - 50;
    }


}
