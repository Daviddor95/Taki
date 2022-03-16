package com.game.taki;

public class MenuModel implements IMenuModel {
    private IMenuController controller;

    public MenuModel(IMenuController controller) {
        this.controller = controller;
    }
}
