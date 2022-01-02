package com.example.project;

import javafx.scene.shape.Rectangle;

public class Collision{

    public void checkCollisionPX(Character a , Character b){

            if (b.getimage().getBoundsInParent().intersects(a.getimage().getBoundsInParent())){
                if(a instanceof Player && b instanceof Platform) {
                    a.playerCollide();
                }
                else if( a instanceof  Player && b instanceof Enemy){
                    b.playerCollide();
                }
                else if( a instanceof  Player && b instanceof Boss){
                    b.playerCollide();
                }
                else if( a instanceof  Player && b instanceof TNT){
                    b.playerCollide();
                }
                else if( a instanceof  Player && b instanceof TreasureChest){
                    b.playerCollide();
                }
                System.out.println("yes");

            }
    }


    public void checkCollision(Character p , Rectangle r){
        if(p.getimage().getBoundsInParent().intersects(r.getBoundsInParent())){
            p.deathLineCollide();
        }
    }
}
