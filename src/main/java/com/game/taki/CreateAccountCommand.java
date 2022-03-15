package com.game.taki;

public class CreateAccountCommand extends Command {
    public CreateAccountCommand(IModel m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.createAccount();
    }
}
