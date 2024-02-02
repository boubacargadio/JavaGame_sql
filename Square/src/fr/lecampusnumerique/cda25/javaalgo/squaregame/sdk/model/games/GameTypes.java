package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerStrategySolver;

import java.util.List;

public interface GameTypes {

    List<PlayerStrategySolver> getAvailableSolvers();

}
