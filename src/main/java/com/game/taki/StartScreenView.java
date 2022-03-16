package com.game.taki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenView extends Application implements IView {
    private IStartScreenController controller;

//    public StartScreenView(IController c) {
//
//    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartScreenView.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 540);
        this.controller = fxmlLoader.getController();
        IStartScreenModel model = new StartScreenModel(this.controller);
        this.controller.setModel(model);
        this.controller.setView(this);
        this.controller.setStage(stage);
        stage.setTitle("Taki");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
