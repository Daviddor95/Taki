package com.game.taki;

public abstract class Command {
    protected Model model;

    protected Command(Model m) {
        this.model = m;
    }

    public abstract boolean execute();
}
