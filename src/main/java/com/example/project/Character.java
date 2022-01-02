package com.example.project;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Character {
    private ImageView image;
    private int position;

    public Character(ImageView x){
        this.image = x;
    }
    public void despawn(){
        this.image.imageProperty().set(null);
    }

    protected void move(){
        translating(this.image, -200, 0, false, true, 600);
    }

    protected void translating(ImageView image, int x, int y, boolean loop,boolean reverse, double duration){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(image);
        if(loop){
            translate.setCycleCount(TranslateTransition.INDEFINITE);
        }
        if(reverse){
            translate.setAutoReverse(reverse);
        }
        translate.setDuration(Duration.millis(duration));
        translate.setByX(x);
        translate.setByY(y);
        translate.play();
    }
    protected ImageView getimage(){
        return this.image;
    }
    public void playerCollide(){}
    public void deathLineCollide(){}

}
