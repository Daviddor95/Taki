package com.game.taki;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import java.util.Objects;

public class GameController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private ImageView pileTopCard;
//    @FXML
//    private ImageView pickCardFromDeck;
//    @FXML
//    private MenuButton chooseColorButton;
//    @FXML
//    private ImageView playerCardImages;
    @FXML
    private ListView<String> handList;

    @FXML
    protected EventHandler<ActionEvent> onPickCardFromDeckClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    @FXML
    protected EventHandler<ActionEvent> onPickCardFromListClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
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
            updateScene();
            model.gameRound();
            updateScene();
            // handList.setDisable(true);
        }
    };
    @FXML
    protected EventHandler<ActionEvent> onChooseColorButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };

    @Override
    public void updateScene() {
        if (this.model.isWon()) {
            try {
                new WinScreenView().start(this.stage);
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
        List<ICard> hand = this.model.getPlayerHand();
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
                            // System.out.println(cardName);
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
                    setId(cardName);
                }
            }
        });
        this.handList.refresh();
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
