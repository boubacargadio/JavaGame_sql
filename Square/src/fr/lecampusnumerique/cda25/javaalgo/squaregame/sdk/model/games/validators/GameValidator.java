package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.validators;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;

public interface GameValidator {

    boolean isGamePlayable(Board board);
    boolean hasWinner(Board board);
    Coordinates getBestMove(Board board);

}
