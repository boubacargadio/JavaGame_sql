package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.Board;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.game.AbstractGame;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.validators.GameValidator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.opponents.Opposable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;

public class TicTacToe extends AbstractGame {

    public TicTacToe(){
        this(null, null, null, null, null, null);

    }

    protected TicTacToe(Board board, Opposable opponents, View view, UserInteraction userInteractions, GameValidator gameValidator, GameType gameType) {
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
