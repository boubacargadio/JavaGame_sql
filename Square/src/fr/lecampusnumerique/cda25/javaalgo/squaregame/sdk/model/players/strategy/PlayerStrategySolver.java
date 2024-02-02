package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;

public interface PlayerStrategySolver {

    Coordinates generateCoordinates(Board board);

}
