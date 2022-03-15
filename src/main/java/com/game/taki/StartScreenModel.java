package com.game.taki;

public class StartScreenModel implements IModel {
    private IController controller;
    private IDatabase usersDatabase;
    private String userName;
    private String password;
    private boolean isSignedIn;

    public StartScreenModel(IController c) {
        this.controller = c;
        this.isSignedIn = false;
    }

    public void setUserName(CharSequence name) {
        this.userName = name.toString();
    }

    public void setPassword(CharSequence password) {
        this.password = password.toString();
    }

    public boolean logIn() {
        // this.controller.logInFailed("Log in failed. Please check again your credentials.");
        if (!this.usersDatabase.isExist(this.userName) || !this.usersDatabase.getPassword(this.userName).equals(this.password)) {
            this.isSignedIn = false;
            return false;
        }
        this.isSignedIn = true;  // this.usersDatabase.getUser(this.userName).getPassword().equals(this.password);
        return true;
    }

    public boolean guest() {
        return true;
    }

    public boolean createAccount() {
        if (!this.usersDatabase.isExist(this.userName)) {
            // IUser user = new User(this.userName, this.password);
            this.usersDatabase.addUser(this.userName, this.password);
            // this.usersDatabase.addUser(this.userName);
            // this.usersDatabase.getUser(this.userName).setPassword(this.password);
            this.logIn();
            return true;
        }
        return false;
    }
}
