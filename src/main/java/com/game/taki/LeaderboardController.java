package com.game.taki;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

//        this.users.setCellValueFactory(new MapValueFactory<>(Model.usersColumnKey));
//        this.scores.setCellValueFactory(new MapValueFactory<>(Model.scoresColumnKey));
//
        // this.highscore = new TableView<>(this.model.getScores());
//        Callback<TableColumn<Map, String>, TableCell<Map, String>> cellFactory = (TableColumn<Map, String> c) ->
//                new TextFieldTableCell<>(new StringConverter<>() {
//                    @Override
//                    public String toString(String s) {
//                        return s.toString();
//                    }
//
//                    @Override
//                    public String fromString(String s) {
//                        return s;
//                    }
//                });
//        this.users.setCellFactory(cellFactory);
//        this.scores.setCellFactory(cellFactory);
        // ObservableList<Map> tableEntries = FXCollections.observableList();
        this.users.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getuName()));
        this.scores.setCellValueFactory(data -> new ReadOnlyObjectWrapper<>(data.getValue().getScore()));
        ObservableList<TableRecord> sl = this.model.getScores();
        this.highscore.setItems(sl);
        // sl.comparatorProperty().bind(this.highscore.comparatorProperty());
        // this.scores.setSortable(true);
        this.scores.setSortType(TableColumn.SortType.DESCENDING);
        this.highscore.getSortOrder().add(this.scores);
        this.highscore.sort();
        // this.highscore.refresh();
//        this.stage.show();
    }

    @FXML
    private void initialize() {
        // this.pane.setOn(this.onHighscoreTableViewSort);

    }
}

