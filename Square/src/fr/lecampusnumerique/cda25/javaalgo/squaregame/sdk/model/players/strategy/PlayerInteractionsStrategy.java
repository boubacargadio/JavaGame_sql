package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;

public interface PlayerInteractionsStrategy {

    Coordinates createCoordinates(Board board);


}
