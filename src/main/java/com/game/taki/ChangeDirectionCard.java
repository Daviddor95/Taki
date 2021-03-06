package com.game.taki;

public class ChangeDirectionCard extends DecoratedCard{

    public ChangeDirectionCard(ICard decoratedCard) {
        super(decoratedCard);
    }

    @Override
    public void doAction(GameModel game) {
        decoratedCard.doAction(game);
        if (game.getNumberOfTimesItsStillMyTurn() == 0 || game.getNumberOfTimesItsStillMyTurn() == 1){
            addedBehavior(game);
        }
    }

    protected void addedBehavior(GameModel game) {
        if (game.getPlayers().size() != 2) {
            game.ReverseOrderOfPlayers();
        }
    }
}
