package com.game.taki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController implements IController {
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
    @FXML
    protected EventHandler<ActionEvent> onLeaderboardButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Command showLeaderboard = new LeaderboardCommand(model);
            if (showLeaderboard.execute()) {
                try {
                    new LeaderboardView().start(stage);
                } catch (Exception e) {
                    // log message
                    e.printStackTrace();
                }
            } else {
                // user message
            }
        }
    };


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
