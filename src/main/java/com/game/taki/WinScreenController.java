package com.game.taki;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class WinScreenController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private Label winMessage;

    @Override
    public void setModel(Model m) {
        this.model = m;
    }

    @Override
    public void setView(Application v) {
        this.view = v;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void updateScene() {
        int playerWon = this.model.whoWon();
        if (playerWon == 0) {
            this.winMessage.setText("You won!");
        } else {
            this.winMessage.setText("Player " + playerWon + " won");
        }
    }
}
