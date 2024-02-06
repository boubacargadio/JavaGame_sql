package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerInteractionsStrategy;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception.IncorrectInputException;

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

    @Override
    public void clear() {

    }

    @Override
    public int waitForInt() throws IncorrectInputException {
        return 0;
    }

    @Override
    public String waitForString() {
        return null;
    }

    @Override
    public char waitForChar() throws IncorrectInputException {
        return 0;
    }

    @Override
    public void show(String message) {

    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void addContent(Containable containable) {

    }

    @Override
    public void removeContent(Containable containable) {

    }

    @Override
    public void switchContent(Containable in, Containable out) {

    }
}
