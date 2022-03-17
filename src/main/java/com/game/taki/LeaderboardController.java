package com.game.taki;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class LeaderboardController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private TableView<Map.Entry<String, Integer>> highscore;

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

    @FXML
    private void initialize() {
        // ObservableList<Map.Entry<String, Integer>> tableEntries = ;
        this.highscore.getItems().addAll(this.model.getScores().entrySet());
    }
}







