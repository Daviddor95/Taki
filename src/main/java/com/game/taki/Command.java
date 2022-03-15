package com.game.taki;

public abstract class Command {
    public IModel model;

    protected Command(IModel m) {
        this.model = m;
    }

    public abstract boolean execute();
}
