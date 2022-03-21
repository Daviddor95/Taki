package com.game.taki;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartScreenController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private TextField userNameInput;
    @FXML
    private TextField passwordInput;
    @FXML
    private Label errorMessage;
    @FXML
    private Button logInButton;
    @FXML
    private Button createAccountButton;
    @FXML
    private Button guestButton;
    @FXML
    protected EventHandler<ActionEvent> onLogInButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            model.setUserName(userNameInput.getText());
            model.setPassword(passwordInput.getText());
            Command logIn = new LogInCommand(model);
            if (logIn.execute()) {
                try {
                    new MenuView().start(stage);
                } catch (Exception e) {
                    System.out.println("Failed to load the menu");
                    e.printStackTrace();
                }
            } else {
                errorMessage.setText("Log in failed. Please check again your credentials.");
            }
        }
    };
    @FXML
    protected EventHandler<ActionEvent> onCreateAccountButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            model.setUserName(userNameInput.getText());
            model.setPassword(passwordInput.getText());
            Command createAccount = new CreateAccountCommand(model);
            if (createAccount.execute()) {
                try {
                    new MenuView().start(stage);
                } catch (Exception e) {
                    System.out.println("Failed to load the menu");
                    e.printStackTrace();
                }
            } else {
                errorMessage.setText("Account creation failed. Please choose a different user name.");
            }
        }
    };
    @FXML
    protected EventHandler<ActionEvent> onGuestButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            Command guest = new GuestCommand(model);
            if (guest.execute()) {
                try {
                    new MenuView().start(stage);
                } catch (Exception e) {
                    System.out.println("Failed to load the menu");
                    e.printStackTrace();
                }
            } else {
                errorMessage.setText("Account creation failed. Please choose a different user name.");
            }
        }
    };

    @FXML
    private void initialize() {
        this.logInButton.setOnAction(this.onLogInButtonClick);
        this.createAccountButton.setOnAction(this.onCreateAccountButtonClick);
        this.guestButton.setOnAction(this.onGuestButtonClick);
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void setView(Application v) {
        this.view = v;
    }

    public void setStage(Stage s) {
        this.stage = s;
    }

    @Override
    public void updateScene() {
    }
}
