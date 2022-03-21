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
import java.util.ArrayList;
import java.util.List;

public class GameController implements IController {
    private Model model;
    private Application view;
    private Stage stage;
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
    protected EventHandler<MouseEvent> onPickCardFromHandClick = new EventHandler<>() {
        @Override
        public void handle(MouseEvent actionEvent) {
            ImageView imageCard = (ImageView) actionEvent.getSource();
            String cardName = imageCard.getId(), color = cardName.substring(cardName.length() - 1);
            String nameWithoutColor = cardName.substring(0, cardName.length() - 1), name = "";
            ICard card;
            try {
                Integer.parseInt(cardName.substring(0, 1));
                if (cardName.charAt(1) != '+') {
                    card = new Card(name, color);
                } else {
                    card = new DrawTwoCard(new Card("2+", color));
                }
            } catch (NumberFormatException e){
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
            model.gameRound();
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
        List<ICard> hand = this.model.getPlayerHand();
        List<String> handString = new ArrayList<>();
        for (ICard c : hand) {
            handString.add(c.getName() + c.getColor() + ".jpg");
        }
        ObservableList<String> observableHand = FXCollections.observableArrayList(handString);

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
        this.handList.setItems(observableHand);
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
