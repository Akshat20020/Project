package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class pauseMenuController implements Initializable {
    private Stage stage;
    private Parent root;
    @FXML
    private Group menuGroup;
    @FXML
    private Button exit;

    @FXML
    private Button load;

    @FXML
    private Button resume;

    @FXML
    private Button save;

    @FXML
    void exit(MouseEvent event) throws IOException {
        root = FXMLLoader.load(mainGame.class.getResource("Menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void resume(MouseEvent event) throws IOException {
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
    private void translating(Group group, int x, int y){
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(group);
        translate.setByX(x);
        translate.setByY(y);
        translate.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        translating(menuGroup, 0, -600);
    }
}
