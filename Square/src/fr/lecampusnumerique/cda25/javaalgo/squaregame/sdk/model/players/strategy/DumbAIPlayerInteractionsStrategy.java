package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

import java.util.List;

public class DumbAIPlayerInteractionsStrategy extends AbstractPlayerInteractionsStrategy {

    private Coordinates coordinates;


    public DumbAIPlayerInteractionsStrategy(View view, UserInteraction userInteraction, GameTypes gameTypes) {
        super(view, userInteraction, gameTypes);
    }

    @Override
    protected int getRaw(Board board) {
        generateNewCoordinates(board);
        return coordinates.getRaw();
    }

    @Override
    protected int getColumn(Board board) {
        generateNewCoordinates(board);
        return coordinates.getColumn();
    }

    private void generateNewCoordinates(Board board){
        if(isNewTurn() && !board.isFull()){
            List<Coordinates> availables = board.getAvailableCells();
            coordinates = availables.get((int) Math.abs(Math.random()*availables.size()));
            setNewTurn(false);
        }
    }
}
