package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class levelController implements  Initializable {
    private Stage stage;
    private Parent root;
    @FXML
    private ImageView Background;

    @FXML
    private ImageView Chest;

    @FXML
    private ImageView Coin;

    @FXML
    private ImageView Coin2;

    @FXML
    private ImageView Coin3;

    @FXML
    private ImageView Sword;

    @FXML
    private ImageView Enemy;

    @FXML
    private ImageView Hero;

    @FXML
    private ImageView Pause;

    @FXML
    private ImageView Platform;

    @FXML
    private ImageView Platform2;

    @FXML
    private Text score;

    @FXML
    void changeMenu(MouseEvent event) throws IOException{
        root = FXMLLoader.load(levelController.class.getResource("pauseMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void moveHero(KeyEvent event) {
    }

    @FXML
    void openChest(MouseEvent event){
        Image image = new Image(getClass().getResourceAsStream("/Assets/ChestOpen.png"));
        translating(Sword, 0, -50, false, 500);
        Chest.setImage(image);

    }

    private void translating(ImageView image, int x, int y, boolean loop, double duration){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(image);
        if(loop){
            translate.setCycleCount(TranslateTransition.INDEFINITE);
            translate.setAutoReverse(true);
        }
        translate.setDuration(Duration.millis(duration));
        translate.setByX(x);
        translate.setByY(y);
        translate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translating(Coin, 0, -7, true, 700);
        translating(Coin2, 0, -7, true, 700);
        translating(Coin3, 0, -7, true, 700);
        translating(Hero, 0, -100, true, 600);
        translating(Enemy, 0, -60, true, 500);
    }
}
