package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

public abstract class AbstractPlayerInteractionsStrategy implements PlayerInteractionsStrategy {

    protected final static String RAW_QUESTION = "Veuillez saisir la ligne:";
    protected final static String COLUMN_QUESTION = "Veuillez saisir la colonne:";


    private View view;
    private UserInteraction userInteraction;
    private GameTypes gameTypes;
    private boolean newTurn = true;
    protected void setNewTurn(boolean newTurn){
        this.newTurn = newTurn;
    }

    protected boolean isNewTurn() {
        return newTurn;
    }

    protected View getView() {
        return view;
    }

    protected UserInteraction getUserInteraction() {
        return userInteraction;
    }


    public AbstractPlayerInteractionsStrategy(View view, UserInteraction userInteraction, GameTypes gameTypes) {
        this.view = view;
        this.userInteraction = userInteraction;
        this.gameTypes = gameTypes;
    }

    @Override
    public Coordinates createCoordinates(Board board) {
        setNewTurn(true);
        view.show(RAW_QUESTION);
        int raw = getRaw(board);
        view.show(COLUMN_QUESTION);
        int column = getColumn(board);
        setNewTurn(false);
        return new Coordinates(raw, column);
    }

    protected abstract int getRaw(Board board);
    protected abstract int getColumn(Board board);
}
