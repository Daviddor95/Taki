package com.game.taki;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class GameController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private ImageView pileTopCard;
    @FXML
    private ListView<String> handList;
    @FXML
    private Label p1Counter;
    @FXML
    private Label p2Counter;
    @FXML
    private Label p3Counter;
    @FXML
    private Label p4Counter;
    @FXML
    private ImageView pc1;
    @FXML
    private ImageView pc2;
    @FXML
    private ImageView pc3;
    @FXML
    protected EventHandler<MouseEvent> onPickCardFromHandClick = new EventHandler<>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            String cardName = handList.getSelectionModel().getSelectedItem(), color = cardName.substring(cardName.length() - 1);
            String nameWithoutColor = cardName.substring(0, cardName.length() - 1);
            ICard card;
            try {
                Integer.parseInt(cardName.substring(0, 1));
                if (cardName.charAt(1) != '+') {
                    card = new Card(nameWithoutColor, color);
                } else {
                    card = new DrawTwoCard(new Card("2+", color));
                }
            } catch (NumberFormatException e) {
                switch (nameWithoutColor) {
                    case "ChangeColor":
                        card = new ChangeColorCard(new Card("ChangeColor", color));
                        break;
                    case "ChangeDirection":
                        card = new ChangeDirectionCard(new Card("ChangeDirection", color));
                        break;
                    case "Plus":
                        card = new PlusCard(new Card("Plus", color));
                        break;
                    case "Stop":
                        card = new StopCard(new Card("Stop", color));
                        break;
                    case "SuperTaki":
                        card = new SuperTakiCard(new Card("SuperTaki", color));
                        break;
                    case "Taki":
                        card = new TakiCard(new Card("Taki", color));
                        break;
                    default:
                        card = null;
                        break;
                }
            }
            model.setChoosenCard(card);
            // updateScene();
            model.gameRound();
            updateScene();
            // handList.setDisable(true);
        }
    };

    @Override
    public void updateScene() {
        if (this.model.whoWon() != -1) {
            try {
                new WinScreenView().start(this.stage);
                this.model.winScreen();
                if (this.model.whoWon() == this.model.getPersonIndex()) {
                    this.model.updateScore();
                }
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String topPileCardName = model.getTopPileCard().getName() + model.getTopPileCard().getColor() + ".jpg";
        try {
            String imgName = getClass().getResource(topPileCardName).toURI().toString();
            pileTopCard.setImage(new Image(imgName ,70 ,110, true, true));
        } catch (URISyntaxException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        this.handList.setDisable(false);
        List<String> counters = new ArrayList<>();
        for (int i = 0; i < this.model.getPlayers().size(); i++) {
            counters.add("Number of \ncards: " + this.model.getPlayers().get(i).getCardsCollect().size());
        }
        int order = this.model.getPersonIndex();
        this.p1Counter.setText(counters.get(order));
        this.p2Counter.setText(counters.get(Math.abs(order - 1)));
        if (this.model.getPlayers().size() >= 3) {
            this.p3Counter.setText(counters.get(Math.abs(order - 2)));
        } else {
            this.pc2.setVisible(false);
            this.pc3.setVisible(false);
        }
        if (this.model.getPlayers().size() == 4) {
            this.p4Counter.setText(counters.get(Math.abs(order - 3)));
        } else {
            this.pc3.setVisible(false);
        }
        CardsCollection hand = this.model.getPlayerHand();
        List<String> handString = new ArrayList<>();
        for (ICard c : hand) {
            handString.add(c.getName() + c.getColor());
        }
        ObservableList<String> observableHand = FXCollections.observableArrayList(handString);
        this.handList.setItems(observableHand);
        this.handList.setCellFactory(arg -> new ListCell<>() {
            private ImageView img = new ImageView();
            @Override
            public void updateItem(String cardName, boolean isEmpty) {
                super.updateItem(cardName, isEmpty);
                if (isEmpty) {
                    setGraphic(null);
                } else {
                    String[] cards = model.getAllCardsNames();
                    for (String cardString : cards) {
                        if (cardName.equals(cardString)) {
                            try {
                                img.setImage(new Image(getClass().getResource(cardName + ".jpg").toURI().toString(),70 ,110, true, true));
                            } catch (URISyntaxException e) {
                                System.out.println("error");
                                e.printStackTrace();
                            }
                            break;
                        }
                    }
                    setGraphic(img);
                    setOnMouseClicked(onPickCardFromHandClick);
                    // updateScene();
                    setId(cardName);
                }
            }
        });
        this.handList.refresh();
        this.model.takeCards();
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void setView(Application v) {
        this.view = v;
    }

    @Override
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void initialize() {
        // this.handList.setOnMouseClicked();
    }

}
