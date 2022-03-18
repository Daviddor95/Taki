package com.game.taki;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Model {
    private IController controller;
    private IDatabase usersDatabase;
    private String userName;
    private String password;
    private boolean isSignedIn;
    private static Model model;

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

    public ObservableList<Map<String, String>> getScores() {
        ObservableList<Map<String, String>> table = FXCollections.observableArrayList();
        HashMap<String, Integer> scoresMap = new HashMap<>(this.usersDatabase.getScores());
        int len = scoresMap.size();
        for (int i = 0; i < len; i++) {
            Map<String, String> row = new HashMap<>();
            String userName = scoresMap.keySet().toArray()[0].toString();
            System.out.println(userName);
            row.put("users", userName);
            row.put("scores", scoresMap.get(userName).toString());
            table.add(row);
            scoresMap.remove(userName);
        }
        return table;
    }

//    // @@@@@@
//    public HashMap<String, Integer> getSortedScores() {
//        Stream<Map.Entry<String, Integer>> stream = this.usersDatabase.getScores().entrySet().stream();
//        Stream<Map.Entry<String, Integer>> sortedStream = stream.sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
//        return sortedStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o1,
//                LinkedHashMap::new));
//    }

}
