package com.game.taki;

public class LogInCommand extends Command {
    public LogInCommand(IStartScreenModel m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.logIn();
    }
}
