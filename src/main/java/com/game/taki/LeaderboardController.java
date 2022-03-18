package com.game.taki;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.util.Map;

public class LeaderboardController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private TableView<Map<String, String>> highscore;
    @FXML
    public TableColumn<String, String> users;
    @FXML
    public TableColumn<String, String> scores;
//    @FXML
//    protected EventHandler<SortEvent<TableView<Map.Entry<String, Integer>>>> onHighscoreTableViewSort = sortEvent -> {
//        ObservableList<Map.Entry<String, Integer>> tableEntries = FXCollections.emptyObservableList();
//        tableEntries.addAll(model.getScores().entrySet());
//        highscore.setItems(tableEntries);
//    };

    public LeaderboardController() {
        // this.highscore.getItems().addAll(this.model.getScores().entrySet());
    }

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
//        ObservableList<Map.Entry<String, Integer>> tableEntries = FXCollections.emptyObservableList();
//        tableEntries.addAll();

        this.highscore.setItems(this.model.getScores());
    }

    @FXML
    private void initialize() {
        // this.pane.setOn(this.onHighscoreTableViewSort);
    }
}

