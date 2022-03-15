package com.game.taki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StartScreenView extends Application implements IView {
    private IController controller;

    public StartScreenView(IController c) {
        this.controller = c;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartScreenView.class.getResource("view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Taki");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        IController controller = new StartScreenController();
        IView view = new StartScreenView(controller);
        IModel model = new StartScreenModel(controller);
        controller.setModel(model);
        controller.setView(view);
        launch(args);
    }
}
