package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.OpenCellGameBoard;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;

public class TicTacToeBoard extends OpenCellGameBoard {

    public final static int DEFAULT_SIZE = 3;
    public final static int MIN_SIZE = 3;

    public TicTacToeBoard(){
        this(DEFAULT_SIZE);
    }

    public TicTacToeBoard(int size) {
        super(size, MIN_SIZE, GameType.TICTACTOE);
    }

    protected String getRawSeparatorRepresentation(){
        return getLine();
    }

    @Override
    protected String getFloorRepresentation() {
        return "";
    }

    @Override
    protected String getLineEnd() {
        return "|\n";
    }
}
