package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.validators;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;

public abstract class AbstractGameValidator implements GameValidator{


    @Override
    public boolean isGamePlayable(Board board) {
        return !board.isFull();
    }
        
}
