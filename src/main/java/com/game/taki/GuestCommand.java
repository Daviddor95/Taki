package com.game.taki;

public class GuestCommand extends Command {
    public GuestCommand(IModel m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.guest();
    }
}
