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
            // handList.get @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            ImageView imageCard = (ImageView) actionEvent.getSource();
            String cardName = imageCard.getId();
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
