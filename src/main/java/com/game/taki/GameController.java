package com.game.taki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameController implements IController {
    private Model model;
    private Application view;
    private Stage stage;

    @FXML
    private void initialize() {
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void setView(Application v) {
        this.view = v;
    }

    public void setStage(Stage s) {
        this.stage = s;
    }

    @Override
    public void updateScene() {

    }
}
