package com.game.taki;

public class LogInCommand extends Command {
    public LogInCommand(Model m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.logIn();
    }
}
