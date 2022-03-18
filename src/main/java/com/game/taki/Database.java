package com.game.taki;

import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Database implements IDatabase {
    private HashMap<String, ArrayList<String>> users;

    public Database() {
        this.users = new HashMap<>();
        ArrayList<String> userDetails1 = new ArrayList<>();
        userDetails1.add("95");
        userDetails1.add("10");
        this.users.put("David", userDetails1);
        ArrayList<String> userDetails2 = new ArrayList<>();
        userDetails2.add("97");
        userDetails2.add("9");
        this.users.put("Ella", userDetails2);
    }

    @Override
    public boolean isExist(String userName) {
        return this.users.containsKey(userName);
    }

    @Override
    public void addUser(String userName, String password) {
        ArrayList<String> userDetails = new ArrayList<>();
        userDetails.add(password);
        userDetails.add("0");
        this.users.put(userName, userDetails);
    }

    @Override
    public String getPassword(String userName) {
        return this.users.get(userName).get(0);
    }

    @Override
    public Integer getScore(String userName) {
        return Integer.parseInt(this.users.get(userName).get(1));
    }

    @Override
    public void updateScore(String userName) {
        ArrayList<String> userDetails = new ArrayList<>();
        userDetails.add(this.getPassword(userName));
        int newScore = this.getScore(userName) + 1;
        userDetails.add((Integer.toString(newScore)));
        this.users.replace(userName, userDetails);
    }

    @Override
    public HashMap<String, Integer> getScores() {
        HashMap<String, Integer> scores = new HashMap<>();
        for (String name : this.users.keySet()) {
            scores.put(name, this.getScore(name));
        }
        return scores;
    }
}

