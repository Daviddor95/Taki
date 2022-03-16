package com.game.taki;

public class GuestCommand extends Command {
    public GuestCommand(IStartScreenModel m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.guest();
    }
}
