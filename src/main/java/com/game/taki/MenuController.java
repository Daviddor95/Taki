package com.game.taki;

public class MenuController implements IMenuController {
    private IMenuModel model;
    private IView view;

    public void setModel(IMenuModel m) {
        this.model = m;
    }

    public void setView(IView v) {
        this.view = v;
    }
}
