package com.game.taki;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartScreenController implements IStartScreenController {
    private IStartScreenModel model;
    private IView view;
    private Stage stage;
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
    @FXML
    public Button logInButton;
    @FXML
    public Button createAccountButton;
    @FXML
    public Button guestButton;
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

    public void setModel(IStartScreenModel m) {
        this.model = m;
    }

    public void setView(IView v) {
        this.view = v;
    }

    public void setStage(Stage s) {
        this.stage = s;
    }


//    @FXML
//    protected void onCreateAccountButtonClick() {
//        this.model.setUserName(this.userNameInput.getCharacters());
//        this.model.setPassword(this.passwordInput.getCharacters());
//        Command createAccount = new CreateAccountCommand(this.model);
//        if (createAccount.execute()) {
//            this.welcomeScreen.setVisible(false);
//        } else {
//            this.errorMessage.setText("Failed to create the account. Please try a different user name.");
//        }
//    }
//
//    @FXML
//    protected void onGuestButtonClick() {
//        Command guest = new GuestCommand(this.model);
//        if (guest.execute()) {
//            this.welcomeScreen.setVisible(false);
//        } else {
//            this.errorMessage.setText("Failed to start the game. Please try again.");
//        }
//    }

//    public void logInSuccessful() {
//
//    }
//
//    public void logInFailed(String message) {
//        this.errorMessage.setText(message);
//    }
}
