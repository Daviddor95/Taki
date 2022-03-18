package com.game.taki;

import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public interface IDatabase {
    boolean isExist(String userName);
    void addUser(String userName, String password);
    String getPassword(String userName);
    Integer getScore(String userName);
    void updateScore(String userName);
    Map<String, Integer> getScores();
}
