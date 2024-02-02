package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerStrategySolver;

import java.util.ArrayList;
import java.util.List;


public enum GameType implements GameTypes {

    TICTACTOE(null),
    CONNECT4(null),
    GOMOKU(null)
    ;

    private final List<PlayerStrategySolver> availableSolvers;

    @Override
    public List<PlayerStrategySolver> getAvailableSolvers() {
        return availableSolvers;
    }

    GameType(List<PlayerStrategySolver> availableSolvers) {
        this.availableSolvers = availableSolvers != null ? availableSolvers : new ArrayList<>();
    }
}
