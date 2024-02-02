package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception.IncorrectInputException;

public class HumanPlayerInteractionsStrategy extends AbstractPlayerInteractionsStrategy {

    public HumanPlayerInteractionsStrategy(View view, UserInteraction userInteraction, GameTypes gameTypes) {
        super(view, userInteraction, gameTypes);
    }

    @Override
    protected int getRaw(Board board) {
        try {
            return getUserInteraction().waitForInt();
        } catch (IncorrectInputException e) {
            getView().show(RAW_QUESTION);
            return getRaw(board);
        }
    }

    @Override
    protected int getColumn(Board board) {
        try {
            return getUserInteraction().waitForInt();
        } catch (IncorrectInputException e) {
            getView().show(COLUMN_QUESTION);
            return getColumn(board);
        }
    }
}
