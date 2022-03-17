package com.game.taki;

public class LeaderboardCommand extends Command {
    public LeaderboardCommand(Model m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.showLeaderboard();
    }
}
