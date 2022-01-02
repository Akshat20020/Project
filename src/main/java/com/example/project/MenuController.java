package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MenuController implements Initializable {
    private Stage stage;
    private Parent root;

    @FXML
    private ImageView Background;

    @FXML
    private ImageView exitButton;

    @FXML
    private ImageView playButton;

    @FXML
    private ImageView loadButton;

    @FXML
    void enterExit(MouseEvent event) {
        System.out.println("entering");
    }

    @FXML
    void enterLoad(MouseEvent event) {

        System.out.println("entering");
   }

    @FXML
    void enterPlay(MouseEvent event) {
        System.out.println("entering");
    }

    @FXML
    void exit(MouseEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
        System.out.println("Exiting");
    }

    @FXML
    void exitExit(MouseEvent event) {
        System.out.println("exiting");
    }

    @FXML
    void exitLoad(MouseEvent event) {
        System.out.println("exiting");
    }

    @FXML
    void exitPlay(MouseEvent event) {
        System.out.println("exiting");
    }

    @FXML
    void load(MouseEvent event) {
        System.out.println("loadscreen");
    }

    @FXML
    void start(MouseEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("newLevel.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        newLevelController controller = loader.getController();
        Scene scene = new Scene(root);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode().isWhitespaceKey()){
                    controller.Playermove();
                }
            }
        });
        stage.setScene(scene);
        stage.show();

        System.out.println("starting");
    }

    private void translating(ImageView image, int x, int y){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(image);
        translate.setByX(x);
        translate.setByY(y);
        translate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translating(playButton,0 , -500);
        translating(exitButton, 0 , -200);
        translating(loadButton, 0 , -200);
    }

}
