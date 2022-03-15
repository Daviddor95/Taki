package com.game.taki;

public interface IModel {
    void setUserName(CharSequence name);
    void setPassword(CharSequence password);
    boolean logIn();
    boolean guest();
    boolean createAccount();
}
