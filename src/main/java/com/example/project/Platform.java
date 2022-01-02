package com.example.project;

import javafx.scene.image.ImageView;

public class Platform  extends Character{
    public Platform(ImageView PlatformImage){
        super(PlatformImage);
    }
    public void playerCollide(){
        translating(getimage(), 0, -100, true, true, 1000);
    }

}
