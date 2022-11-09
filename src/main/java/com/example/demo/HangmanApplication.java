package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HangmanApplication extends Application {
    public static Stage stage;
    public static Scene[] scenes;
    @Override
    public void start(Stage stage) throws IOException {
        HangmanApplication.stage = stage;
        scenes = new Scene[5];

        FXMLLoader fxmlLoader = new FXMLLoader(HangmanApplication.class.getResource("mainMenu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        scenes[0]=scene;

        FXMLLoader fxmlLoader1 = new FXMLLoader(HangmanApplication.class.getResource("game-View.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), 320, 240);
        scenes[1] = scene1;

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        BazaProxy.konektuj();
        BazaProxy.procitajReci();

    }

    public static void main(String[] args) {
        launch();
    }
}