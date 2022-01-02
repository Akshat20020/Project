package com.example.project;

import javafx.scene.image.ImageView;

public class Boss extends Character{
    private int hp;

    public Boss(ImageView EnemyImage){
        super(EnemyImage);
        this.hp = 1000;
    }

    @Override
    public void playerCollide() {
        translating(getimage(), 300, 0 , false, false ,0 );
        if (this.hp == 0 ){
            getimage().imageProperty().set(null);
        }
        this.hp = this.hp - 50;
    }


}
