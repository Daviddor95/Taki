package com.game.taki;

import java.util.ArrayList;
import java.util.HashMap;

public class Database implements IDatabase {
    private HashMap<String, ArrayList<String>> users;

    public Database() {
        this.users = new HashMap<>();
    }

    @Override
    public boolean isExist(String userName) {
        return this.users.containsKey(userName);
    }

    @Override
    public void addUser(String userName, String password) {
        ArrayList<String> userDetails = new ArrayList<>();
        userDetails.add(this.getPassword(userName));
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
}















