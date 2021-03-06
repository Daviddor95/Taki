package com.game.taki;

import java.util.Map;

public interface IDatabase {
    boolean isExist(String userName);
    void addUser(String userName, String password);
    String getPassword(String userName);
    Integer getScore(String userName);
    void updateScore(String userName);
    Map<String, Integer> getScores();
}
