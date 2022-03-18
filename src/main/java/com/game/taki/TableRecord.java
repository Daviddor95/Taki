package com.game.taki;

public class TableRecord {
    private String uName;
    private String score;

    public TableRecord(String name, String score) {
        this.uName = name;
        this.score = score;
    }

    public String getuName() {
        return this.uName;
    }

    public String getScore() {
        return this.score;
    }
}
