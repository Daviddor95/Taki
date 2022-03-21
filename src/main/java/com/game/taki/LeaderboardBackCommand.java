package com.game.taki;

public class LeaderboardBackCommand extends Command {
    public LeaderboardBackCommand(Model m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.leaderboardBack();
    }
}
