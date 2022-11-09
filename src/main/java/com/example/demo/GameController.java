package com.example.demo;

import javafx.fxml.FXML;

public class GameController {
    @FXML
    public void klikNewGame(){
        HangmanApplication.stage.setScene(HangmanApplication.scenes[0]);
    }
}
