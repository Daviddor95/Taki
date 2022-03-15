package com.game.taki;

public class User implements IUser {
    private String userName;
    private String password;
    private int highScore;

    public User(String name, String password) {
        this.userName = name;
        this.password = password;
        this.highScore = 0;
    }

    public void updateScore() {
        this.highScore++;
    }
}
