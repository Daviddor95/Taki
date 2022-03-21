package com.game.taki;

import javafx.application.Application;
import javafx.stage.Stage;

public class WinScreenController implements IController {
    private Model model;
    private Application view;
    private Stage stage;

    @Override
    public void setModel(Model m) {
        this.model = m;
    }

    @Override
    public void setView(Application v) {
        this.view = v;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void updateScene() {
    }
}
