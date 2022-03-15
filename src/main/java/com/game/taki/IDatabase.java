package com.game.taki;

public interface IDatabase {
    boolean isExist(String userName);
    void addUser(String userName, String password);
    String getPassword(String userName);
    Integer getScore(String userName);
    void updateScore(String userName);
}
