package com.game.taki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MenuView extends Application implements IView {
    private IMenuController controller;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(StartScreenView.class.getResource("menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 540);
        this.controller = fxmlLoader.getController();
        IMenuModel model = new MenuModel(this.controller);
        this.controller.setModel(model);
        this.controller.setView(this);
        stage.setTitle("Taki");
        stage.setScene(scene);
        stage.show();
    }
}
