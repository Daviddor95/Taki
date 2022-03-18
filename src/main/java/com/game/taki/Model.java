package com.game.taki;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Model {
    private IController controller;
    private IDatabase usersDatabase;
    private String userName;
    private String password;
    private boolean isSignedIn;
    private static Model model;
    public static final String usersColumnKey = "Users";
    public static final String scoresColumnKey = "Scores";

    private Model() {
        this.usersDatabase = new Database();
        this.isSignedIn = false;
    }

    public static Model getModel(IController c) {
        if (model == null) {
            model = new Model();
        }
        model.setController(c);
        return model;
    }

    public void setController(IController c) {
        this.controller = c;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean logIn() {
        if (!this.usersDatabase.isExist(this.userName) ||
                !this.usersDatabase.getPassword(this.userName).equals(this.password)) {
            this.isSignedIn = false;
            return false;
        }
        this.isSignedIn = true;
        return true;
    }

    public boolean guest() {
        return true;
    }

    public boolean createAccount() {
        if (!this.usersDatabase.isExist(this.userName)) {
            this.usersDatabase.addUser(this.userName, this.password);
            this.logIn();
            return true;
        }
        return false;
    }

    public boolean showLeaderboard() {
        // this.usersScores = this.usersDatabase.getScores();
        this.controller.updateScene();
        return true;
    }

    public ObservableList<TableRecord> getScores() {
        Map<String, Integer> entries = this.usersDatabase.getScores();
        // ArrayList<Map.Entry<String, Integer>> arrList = new ArrayList<Map.Entry<String, Integer>>(entries);
        ObservableList<TableRecord> table = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> e : entries.entrySet()) {
            TableRecord tableRecord = new TableRecord(e.getKey(), e.getValue().toString());
            table.add(tableRecord);
        }
        return table;


        // SortedList<Map> sortedList = new SortedList<Map>(table);
//        ObservableList<Map> table = FXCollections.observableArrayList();
//        Map scoresMap = new TreeMap<>(this.usersDatabase.getScores());
//        int len = scoresMap.size();
//        for (int i = 0; i < len; i++) {
//            Map row = new TreeMap<>();
//            String userName = scoresMap.keySet().toArray()[0].toString();
//            row.put(Model.usersColumnKey, userName);
//            row.put(Model.scoresColumnKey, scoresMap.get(userName).toString());
//            table.add(row);
//            scoresMap.remove(userName);
//        }
        // return sortedList;
    }

//    // @@@@@@
//    public HashMap<String, Integer> getSortedScores() {
//        Stream<Map.Entry<String, Integer>> stream = this.usersDatabase.getScores().entrySet().stream();
//        Stream<Map.Entry<String, Integer>> sortedStream = stream.sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
//        return sortedStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1,
//                LinkedHashMap::new));
//    }

}
