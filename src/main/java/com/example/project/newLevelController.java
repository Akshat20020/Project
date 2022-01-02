package com.example.project;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class newLevelController implements Initializable {
    private Stage stage;
    private Parent root;
    @FXML
    private ImageView Background;

    @FXML
    private ImageView Boss;

    @FXML
    private Rectangle DeathLine;


    @FXML
    private ImageView Enemy1;

    @FXML
    private ImageView Enemy2;

    @FXML
    private ImageView Enemy3;

    @FXML
    private ImageView Enemy4;

    @FXML
    private ImageView Enemy5;

    @FXML
    private ImageView Enemy6;

    @FXML
    private ImageView Enemy7;

    @FXML
    private ImageView Enemy8;

    @FXML
    private ImageView Enemy9;


    @FXML
    private ImageView Platform1;

    @FXML
    private ImageView Platform10;

    @FXML
    private ImageView Platform11;

    @FXML
    private ImageView Platform12;

    @FXML
    private ImageView Platform13;

    @FXML
    private ImageView Platform14;

    @FXML
    private ImageView Platform2;

    @FXML
    private ImageView Platform3;

    @FXML
    private ImageView Platform4;

    @FXML
    private ImageView Platform5;

    @FXML
    private ImageView Platform6;

    @FXML
    private ImageView Platform7;

    @FXML
    private ImageView Platform8;

    @FXML
    private ImageView Platform9;


    @FXML
    private ImageView Player;

    @FXML
    private ImageView Tnt1;

    @FXML
    private ImageView Tnt2;

    @FXML
    private ImageView Tnt3;

    @FXML
    private ImageView Tnt4;

    @FXML
    private ImageView Tnt5;

    @FXML
    private ImageView Tnt6;

    @FXML
    private ImageView Treasure1;

    @FXML
    private ImageView Treasure2;

    @FXML
    private ImageView Treasure3;


    @FXML
    private ImageView Pause;

    @FXML
    private Text score;


    Collision col = new Collision();
    private static ArrayList<Character> characters = new ArrayList<Character>();

    private void setCharArr(){
        Character x = new Player(Player);
        characters.add(x);
        x = new Platform(Platform1);
        characters.add(x);
        x = new Platform(Platform2);
        characters.add(x);
        x = new Platform(Platform3);
        characters.add(x);
        x = new Platform(Platform4);
        characters.add(x);
        x = new Platform(Platform5);
        characters.add(x);
        x = new Platform(Platform6);
        characters.add(x);
        x = new Platform(Platform7);
        characters.add(x);
        x = new Platform(Platform8);
        characters.add(x);
        x = new Platform(Platform9);
        characters.add(x);
        x = new Platform(Platform10);
        characters.add(x);
        x = new Platform(Platform11);
        characters.add(x);
        x = new Platform(Platform12);
        characters.add(x);
        x = new Platform(Platform13);
        characters.add(x);
        x = new Platform(Platform14);
        characters.add(x);
        x = new Enemy(Enemy1);
        characters.add(x);
        x = new Enemy(Enemy2);
        characters.add(x);
        x = new Enemy(Enemy3);
        characters.add(x);
        x = new Enemy(Enemy4);
        characters.add(x);
        x = new Enemy(Enemy5);
        characters.add(x);
        x = new Enemy(Enemy6);
        characters.add(x);
        x = new Enemy(Enemy7);
        characters.add(x);
        x = new Enemy(Enemy8);
        characters.add(x);
        x = new Enemy(Enemy9);
        characters.add(x);
        x = new Boss(Boss);
        characters.add(x);
        x = new TNT(Tnt1,characters.get(0));
        characters.add(x);
        x = new TNT(Tnt2,characters.get(0));
        characters.add(x);
        x = new TNT(Tnt3,characters.get(0));
        characters.add(x);
        x = new TNT(Tnt4,characters.get(0));
        characters.add(x);
        x = new TNT(Tnt5,characters.get(0));
        characters.add(x);
        x = new TNT(Tnt6,characters.get(0));
        characters.add(x);
        x = new TreasureChest(Treasure1);
        characters.add(x);
        x = new TreasureChest(Treasure2);
        characters.add(x);
        x = new TreasureChest(Treasure3);
        characters.add(x);
    }

    public void Playermove(){
        for(Character c: characters){
            c.move();
        }
    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            col.checkCollision(characters.get(0), DeathLine);
            for(Character c : characters){
                if(c instanceof Platform){col.checkCollisionPX(characters.get(0), c);}
                if(c instanceof Enemy){col.checkCollisionPX(characters.get(0), c);}
                if(c instanceof TNT){col.checkCollisionPX(characters.get(0), c);}
                if(c instanceof TreasureChest){col.checkCollisionPX(characters.get(0), c);}
                if(c instanceof Boss){col.checkCollisionPX(characters.get(0), c);}
            }
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCharArr();
        timer.start();
        translating(Player, 0, 200, false,false, 1000);
        translating(Enemy1, 0, -200, true,true, 600);
        translating(Enemy2, 0, -200, true,true, 500);
        translating(Enemy3, 0, -200, true,true, 800);
        translating(Enemy4, 0, -200, true,true, 900);
        translating(Enemy5, 0, -200, true,true, 300);
        translating(Enemy6, 0, -200, true,true, 500);
        translating(Enemy7, 0, -200, true,true, 600);
        translating(Enemy8, 0, -200, true,true, 700);
        translating(Enemy9, 0, -200, true,true, 500);
        translating(Boss, 0, -200, true, true,600);
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

    @FXML
    void changeMenu(MouseEvent event) throws IOException {
        root = FXMLLoader.load(newLevelController.class.getResource("pauseMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
