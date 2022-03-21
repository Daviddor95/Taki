package com.game.taki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuView extends Application {
    private IController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuView.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 540);
        this.controller = fxmlLoader.getController();
        Model model = Model.getModel(this.controller);
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
