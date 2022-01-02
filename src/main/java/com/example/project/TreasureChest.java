package com.example.project;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TreasureChest extends Character{
    Player p;
    public TreasureChest(ImageView EnemyImage){
        super(EnemyImage);
    }

    @Override
    public void playerCollide() {
        Image open = new Image(getClass().getResourceAsStream("/Assets/ChestOpen.png"));
        getimage().setImage(open);
    }
}