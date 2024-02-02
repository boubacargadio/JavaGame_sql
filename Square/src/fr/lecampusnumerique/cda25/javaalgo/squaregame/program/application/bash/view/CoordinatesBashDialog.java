package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerInteractionsStrategy;

public class CoordinatesBashDialog extends AbstractBashDialog<Coordinates, Board> {

    private PlayerInteractionsStrategy strategy;
    private GameTypes gameTypes;

    public CoordinatesBashDialog(PlayerInteractionsStrategy strategy, GameTypes gameTypes) {
        this.strategy = strategy;
    }

    @Override
    public Coordinates showDialog(Board params) {
        return strategy.createCoordinates(params);
    }
}
