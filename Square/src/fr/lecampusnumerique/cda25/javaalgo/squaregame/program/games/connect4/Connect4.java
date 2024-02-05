package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.connect4;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.game.AbstractGame;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.validators.GameValidator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.opponents.Opposable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;

public class Connect4 extends AbstractGame {

    public Connect4(){
        this(null, null, null, null, null, null);

    }

    protected Connect4(Board board, Opposable opponents, View view, UserInteraction userInteractions, GameValidator gameValidator, GameType gameType) {
        super(board, opponents, view, userInteractions, gameValidator, gameType);
    }


    @Override
    protected String createVictoryMessage() {
        return null;
    }

    @Override
    protected String createTieMessage() {
        return null;
    }

    @Override
    protected String createExitMessage() {
        return null;
    }

    @Override
    public void setViewMode(ApplicationType viewType) {

    }
}
