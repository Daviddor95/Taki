package com.game.taki;

public interface IStartScreenModel {
    void setUserName(String name);
    void setPassword(String password);
    boolean logIn();
    boolean guest();
    boolean createAccount();
}
