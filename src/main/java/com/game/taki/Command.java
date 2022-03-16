package com.game.taki;

public abstract class Command {
    public IStartScreenModel model;

    protected Command(IStartScreenModel m) {
        this.model = m;
    }

    public abstract boolean execute();
}
