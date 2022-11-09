package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HangmanApplication extends Application {
    public static final int SCENE_MAIN_MENU = 0;
    public static final int SCENE_GAME = 1;
    public static final int SCENE_PROFILE = 2;
    public static int scenesWidth = 723, scenesHeight=543;
    private static Stage stage;
    private static Scene[] scenes;

    public static Kontroler[] kontrolers;

    @Override
    public void start(Stage stage) throws IOException {
        HangmanApplication.stage = stage;
        scenes = new Scene[5];
        kontrolers = new Kontroler[5];

        FXMLLoader fxmlLoader = new FXMLLoader(HangmanApplication.class.getResource("mainMenu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), scenesWidth, scenesHeight);
        scenes[0]=scene;
        kontrolers[0]=fxmlLoader.getController();

        FXMLLoader fxmlLoader1 = new FXMLLoader(HangmanApplication.class.getResource("game-View.fxml"));
        Scene scene1 = new Scene(fxmlLoader1.load(), scenesWidth, scenesHeight);
        scenes[1] = scene1;
        kontrolers[1]=fxmlLoader1.getController();

        stage.getIcons().add(new Image("file:src/main/resources/slike/gallows.png"));
        stage.setTitle("Hangman");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);


    }

    public static void main(String[] args) {
        launch();
    }

    public static void postaviScenu(int i){
        kontrolers[i].populate();
        HangmanApplication.stage.setScene(HangmanApplication.scenes[i]);
    }
}