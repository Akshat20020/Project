package com.example.project;

import javafx.scene.image.ImageView;

public class TNT extends Character{
    Player x;
    public TNT(ImageView EnemyImage, Character Player){
        super(EnemyImage);
        x = (Player)Player;
    }

    @Override
    public void playerCollide() {
        getimage().imageProperty().set(null);
        if (x.getHp() <= 0 ){
            x.getimage().setDisable(true);
        }
        System.out.println(x.getHp());
        x.changeHp(40);
        getimage().setDisable(true);

    }
}