package com.game.taki;

import javafx.beans.property.SimpleStringProperty;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Database implements IDatabase {
    private Map<String, ArrayList<String>> users;

    public Database() {
        this.users = new TreeMap<>();
        ArrayList<String> userDetails1 = new ArrayList<>();
        userDetails1.add("95");
        userDetails1.add("112");
        this.users.put("David", userDetails1);
        ArrayList<String> userDetails2 = new ArrayList<>();
        userDetails2.add("97");
        userDetails2.add("124");
        this.users.put("Ella", userDetails2);
        ArrayList<String> userDetails3 = new ArrayList<>();
        userDetails3.add("100");
        userDetails3.add("150");
        this.users.put("Miri", userDetails3);
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
    public Map<String, Integer> getScores() {
        Map<String, Integer> scores = new TreeMap<>();
        for (String name : this.users.keySet()) {
            scores.put(name, this.getScore(name));
        }
        return scores;
    }
}











