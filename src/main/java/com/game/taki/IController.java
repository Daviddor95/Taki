package com.game.taki;

import javafx.application.Application;
import javafx.stage.Stage;

public interface IController {
    void setModel(Model m);
    void setView(Application v);
    void setStage(Stage stage);
}
