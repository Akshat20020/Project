package com.example.project;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;



public class mainGame extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader root = new FXMLLoader(mainGame.class.getResource("Menu.fxml"));
        Scene scene = new Scene(root.load(), 1080, 720);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
