package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainMenuController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        HangmanApplication.stage.setScene(HangmanApplication.scenes[1]);
    }
}