package com.game.taki;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class LeaderboardController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private TableView<TableRecord> highscore;
    @FXML
    private TableColumn<TableRecord, String> users;
    @FXML
    private TableColumn<TableRecord, String> scores;
    @FXML
    private Button back;
    @FXML
    protected EventHandler<ActionEvent> onBackButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Command leaderboardBack = new SettingsCommand(model);
            if (leaderboardBack.execute()) {
                try {
                    new MenuView().start(stage);
                } catch (Exception e) {
                    System.out.println("Failed to load the menu");
                    e.printStackTrace();
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
        this.users.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getuName()));
        this.scores.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getScore()));
        ObservableList<TableRecord> sl = this.model.getScores();
        this.highscore.setItems(sl);
        this.scores.setSortType(TableColumn.SortType.DESCENDING);
        this.highscore.getSortOrder().add(this.scores);
        this.highscore.sort();
    }

    @FXML
    private void initialize() {
        this.back.setOnAction(this.onBackButtonClick);
    }
}
