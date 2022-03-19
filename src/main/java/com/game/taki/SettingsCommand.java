package com.game.taki;

public class SettingsCommand extends Command {
    public SettingsCommand(Model m) {
        super(m);
    }

    @Override
    public boolean execute() {
        return this.model.showSettings();
    }
}
