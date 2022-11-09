package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MainMenuController extends Kontroler {

    public void nGameKlik(ActionEvent actionEvent) {
        HangmanApplication.postaviScenu(HangmanApplication.SCENE_GAME);
    }

    @Override
    public void populate() {

    }
}
