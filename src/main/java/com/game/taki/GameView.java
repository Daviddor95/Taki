package com.game.taki;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class GameView extends Application {
    private IController controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameView.class.getResource("Game.fxml"));
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
