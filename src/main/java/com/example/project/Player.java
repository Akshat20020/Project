package com.example.project;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player extends  Character{
    private static int coins;
    private static int score;
    private static int ressurectLeft;
    private static int position;
    private static int hp;
    private Weapon weapon;

    public Player(ImageView PlayerImage){
        super(PlayerImage);
        coins = 0;
        score = 0;
        position = 0;
        hp = 100;
        setRessurect(1);
    }

    @Override
    public void move(){
        translating(getimage(), 1, 0, false,false,  300);
        position += 1;
        System.out.println(position);
    }
    @Override
    public void playerCollide(){
        translating(getimage(), 0, -100, true, true, 500);
    }

    @Override
    public void deathLineCollide(){
        System.out.println("Dead");
    }

    public int addWeapon(){
        return 1;
    }

    public int remWeapon(){
        return 1;
    }

    public void changeHp(int i){
        hp = hp - i;
    }
    public int getHp(){
        System.out.println(hp);
        return hp;}

    public void setRessurect(int i){
        ressurectLeft = i;
    }



}