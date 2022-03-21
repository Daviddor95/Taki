package com.game.taki;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.Map;

public class Model {
    private IController controller;
    private IDatabase usersDatabase;
    private String userName;
    private String password;
    private boolean isSignedIn;
    private int playersNum;
    private int handSize;
    private static GameModel gameModel;
    private static Model model;
    public static final String usersColumnKey = "Users";
    public static final String scoresColumnKey = "Scores";

    private Model() {
        this.usersDatabase = new Database();
        this.isSignedIn = false;
        // this.gameModel = new GameModel(this.controller);
    }

    public static Model getModel(IController c) {
        if (model == null) {
            model = new Model();
        }
        model.setController(c);
        if (gameModel == null) {
            gameModel = new GameModel();
        }
        gameModel.setController(c);
        return model;
    }

    public void setController(IController c) {
        this.controller = c;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // startScreen
    public boolean logIn() {
        if (!this.usersDatabase.isExist(this.userName) ||
                !this.usersDatabase.getPassword(this.userName).equals(this.password)) {
            this.isSignedIn = false;
            return false;
        }
        this.isSignedIn = true;
        return true;
    }

    public boolean guest() {
        return true;
    }

    public boolean createAccount() {
        if (!this.usersDatabase.isExist(this.userName)) {
            this.usersDatabase.addUser(this.userName, this.password);
            this.logIn();
            return true;
        }
        return false;
    }
    // ------

    // leaderboard
    public boolean showLeaderboard() {
        this.controller.updateScene();
        return true;
    }

    public ObservableList<TableRecord> getScores() {
        Map<String, Integer> entries = this.usersDatabase.getScores();
        ObservableList<TableRecord> table = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> e : entries.entrySet()) {
            TableRecord tableRecord = new TableRecord(e.getKey(), e.getValue().toString());
            table.add(tableRecord);
        }
        return table;
    }
    // ------------

    public boolean showSettings() {
        return true;
    }

    public boolean startGame() {
        return true;
    }

    public void setNumberOfPlayers(int players) {
        gameModel.setNumberOfPlayers(players);
    }

    public void setNumberOfHandCards(int numOfCards) {
        gameModel.setNumberOfHandCards(numOfCards);
    }

    public void initializeGame() {
        gameModel.intializeGame();
    }

    public List<ICard> getPlayerHand() {
        return gameModel.getPlayerHand();
    }

    public String[] getAllCardsNames() {
        return new String[]{"1B", "1G", "1R", "1Y", "2+B", "2+G", "2+R", "2+Y", "2B", "2G", "2R", "2Y", "3B", "3G",
                "3R", "3Y", "4B", "4G", "4R", "4Y", "5B", "5G", "5R", "5Y", "6B", "6G", "6R", "6Y", "7B", "7G", "7R",
                "7Y", "8B", "8G", "8R", "8Y", "9B", "9G", "9R", "9Y", "ChangeColorC", "ChangeDirectionB",
                "ChangeDirectionG", "ChangeDirectionR", "ChangeDirectionY", "PlusB", "PlusG", "PlusR", "PlusY", "StopB",
                "StopG", "StopR", "StopY", "SuperTakiC", "TakiB", "TakiG", "TakiR", "TakiY"};
    }

    public void doCardAction(ICard card) {
        gameModel.setChoosenCardInThisTurn(card);
        card.doAction(gameModel);
    }

    public void setChoosenCard(ICard card) {
        gameModel.setChoosenCardInThisTurn(card);
    }

    public void gameRound() {
        gameModel.gameRound();
    }

    public boolean isWon() {
        return gameModel.isWon();
    }

    public boolean leaderboardBack() {
        return true;
    }

    public ICard getTopPileCard() {
        return gameModel.getTopPileCard();
    }
}
