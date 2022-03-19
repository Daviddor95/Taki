package com.game.taki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;

public class SettingsController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private ComboBox<String> playersNum;
    @FXML
    private ComboBox<String> handCards;
    @FXML
    private Button startGame;
    @FXML
    protected EventHandler<ActionEvent> onStartGameButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            model.setNumberOfPlayers(Integer.parseInt(playersNum.getValue().toString()));
            model.setNumberOfHandCards(Integer.parseInt(handCards.getValue().toString()));
            Command startGame = new StartGameCommand(model);
            if (startGame.execute()) {
                try {
                    new GameView().start(stage);
                } catch (IOException e) {
                    e.printStackTrace();
                    // log message
                }
            } else {
                // user message
            }
        }
    };

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

    }
    @FXML
    private void initialize() {
        this.startGame.setOnAction(this.onStartGameButtonClick);
    }
}
