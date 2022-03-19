package com.game.taki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private ImageView pickCardFromDeck;
    @FXML
    private MenuButton chooseColorButton;
    @FXML
    private ImageView playerCardImages;

    @FXML
    protected EventHandler<ActionEvent> onPickCardFromDeckClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    @FXML
    protected EventHandler<ActionEvent> onChooseColorButtonClick = new EventHandler<>() {
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
