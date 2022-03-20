package com.game.taki;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
    @FXML
    private ImageView pickCardFromDeck;
    @FXML
    private MenuButton chooseColorButton;
    @FXML
    private ImageView playerCardImages;
    @FXML
    private ListView<String> handList;

    @FXML
    protected EventHandler<ActionEvent> onPickCardFromDeckClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    @FXML
    protected EventHandler<MouseEvent> onPickCardFromHandClick = new EventHandler<>() {
        @Override
        public void handle(MouseEvent actionEvent) {
            ImageView imageCard = (ImageView) actionEvent.getSource();
            String cardName = imageCard.getId(), color = cardName.substring(cardName.length() - 1);
            String nameWithoutColor = cardName.substring(0, cardName.length() - 1), name = "";
            int numberCard;
            boolean isNumber;
            try {
                numberCard = Integer.parseInt(cardName.substring(0, 1));
                if (cardName.charAt(1) != '+') {
                    name = cardName.substring(0, 1);
                    color = cardName.substring(1, 2);
                    isNumber = true;
                } else {
                    name = cardName.substring(0, 2);
                    color = cardName.substring(2, 3);
                    isNumber = false;
                }
            } catch(NumberFormatException e){
                isNumber = false;
            }
            ICard card;
            if (isNumber) {
                card = new Card(name, color);
            } else {
                switch (nameWithoutColor) {
                    case "2+":
                        card = new DrawTwoCard(new Card("2+", color));
                        break;
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
                    default:
                        card = null;
                }
            }
            assert card != null;
            model.doCardAction(card);
            // card.doAction(model.getGame());
            // if (String.cardName[0])
            // ICard card = new Card()
        }
    };
    @FXML
    protected EventHandler<ActionEvent> onChooseColorButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };
    @FXML
    protected EventHandler<ActionEvent> onSettingsButtonClick = new EventHandler<>() {
        @Override
        public void handle(ActionEvent actionEvent) {

        }
    };

    @Override
    public void updateScene() {
        List<ICard> hand = this.model.getPlayerHand();
        List<String> handString = new ArrayList<>();
        for (ICard c : hand) {
            handString.add(c.getName() + c.getColor());
        }
        ObservableList<String> observableHand = FXCollections.observableArrayList(handString);
        this.handList.setItems(observableHand);
        this.handList.setCellFactory(arg -> new ListCell<String>() {
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
                            img.setImage(new Image(cardName));
                            break;
                        }
                    }
                    setGraphic(img);
                    setOnMouseClicked(onPickCardFromHandClick);
                    setId(cardName);
                }
            }
        });
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

}
