package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.gomoku;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.game.AbstractGame;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.validators.GameValidator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.opponents.Opposable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

public class Gomoku extends AbstractGame {

    public Gomoku(){
        this(null, null, null, null, null, GameType.GOMOKU);
    }

    protected Gomoku(Board board, Opposable opponents, View view, UserInteraction userInteractions, GameValidator gameValidator, GameTypes gameType) {
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
}
