package com.game.taki;

public class Card {
    private String name;
    private String color;

    public Card(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void doAction(){

    }

    public String getName() {
        return name;
    }

    public void setNum(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
