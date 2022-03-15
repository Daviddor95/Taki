package com.game.taki;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;

public class StartScreenController implements IController {
    private IModel model;
    private IView view;
    @FXML
    private TextField userNameInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private Label errorMessage;
    @FXML
    private Pane welcomeScreen;
    @FXML
    private AnchorPane startScreen;

    public void setModel(IModel m) {
        this.model = m;
    }

    public void setView(IView v) {
        this.view = v;
    }

    @FXML
    protected EventHandler<ActionEvent> onLogInButtonClick = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            model.setUserName(userNameInput.getCharacters());
            model.setPassword(passwordInput.getCharacters());
            Command logIn = new LogInCommand(model);
            if (logIn.execute()) {
                try {
                    URL fxml = StartScreenView.class.getResource("menu.fxml");
                    if (fxml == null) {
                        throw new java.io.FileNotFoundException("The menu FXML file not found");
                    }
                    startScreen = FXMLLoader.load(fxml);
                } catch (IOException e) {
                    System.out.println("Failed to load an FXML file");
                }
            } else {
                errorMessage.setText("Log in failed. Please check again your credentials.");
            }
        }
    };

    public StartScreenController() {
        btn.setHandler
    }

//    @FXML
//    protected void onLogInButtonClick() {
//
//    }




    @FXML
    protected void onCreateAccountButtonClick() {
        this.model.setUserName(this.userNameInput.getCharacters());
        this.model.setPassword(this.passwordInput.getCharacters());
        Command createAccount = new CreateAccountCommand(this.model);
        if (createAccount.execute()) {
            this.welcomeScreen.setVisible(false);
        } else {
            this.errorMessage.setText("Failed to create the account. Please try a different user name.");
        }
    }

    @FXML
    protected void onGuestButtonClick() {
        Command guest = new GuestCommand(this.model);
        if (guest.execute()) {
            this.welcomeScreen.setVisible(false);
        } else {
            this.errorMessage.setText("Failed to start the game. Please try again.");
        }
    }

//    public void logInSuccessful() {
//
//    }
//
//    public void logInFailed(String message) {
//        this.errorMessage.setText(message);
//    }
}
