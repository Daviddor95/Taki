package com.game.taki;

public class StartGameCommand extends Command {
    public StartGameCommand(Model m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.startGame();
    }

}
