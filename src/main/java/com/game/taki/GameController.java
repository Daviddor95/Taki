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
    private Button playPCButton;
    @FXML
    private Button playOnlineButton;
    @FXML
    private Button settingsButton;
    @FXML
    private Button leaderboardButton;
    @FXML
    protected EventHandler<ActionEvent> onPlayPCButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    @FXML
    protected EventHandler<ActionEvent> onPlayOnlineButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    @FXML
    protected EventHandler<ActionEvent> onSettingsButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };

    @Override
    public void updateScene() {

    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void setView(Application v) {
        this.view = v;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

}
