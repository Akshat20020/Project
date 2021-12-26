package com.example.project;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        root = FXMLLoader.load(levelController.class.getResource("level.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
