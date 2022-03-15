package com.game.taki;

public class MenuController implements IController {
    private IModel model;
    private IView view;

    public void setModel(IModel m) {
        this.model = m;
    }

    public void setView(IView v) {
        this.view = v;
    }
}
