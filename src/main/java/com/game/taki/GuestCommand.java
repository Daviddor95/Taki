package com.game.taki;

public class GuestCommand extends Command {
    public GuestCommand(Model m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.guest();
    }
}
