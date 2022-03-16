package com.game.taki;

import javafx.stage.Stage;

public interface IStartScreenController {
    void setModel(IStartScreenModel m);
    void setView(IView v);
    void setStage(Stage stage);
}
