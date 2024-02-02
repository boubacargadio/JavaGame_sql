package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.gomoku.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tools.CellFactory;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.AbstractBoard;

public class GomokuBoard extends AbstractBoard {



    public final static int DEFAULT_SIZE = 19;
    public final static int MIN_SIZE = 19;


    public GomokuBoard(){
        this(DEFAULT_SIZE);
    }

    public GomokuBoard(int size){
        this(size, MIN_SIZE);
    }

    protected GomokuBoard(int size, int min) {
        super(size, min, GameType.GOMOKU, CellFactory.getInstance());
    }

    @Override
    protected String getRawSeparatorRepresentation() {
        return makeLine();
    }

    @Override
    protected String getFloorRepresentation() {
        return "";
    }

    @Override
    protected String getLineEnd() {
        return "\n";
    }

    @Override
    protected String getLine() {
        return makeLine();
    }

    private String makeLine(){
        StringBuilder rep = new StringBuilder();
        rep.append("  |  ".repeat(Math.max(0, getSize())));
        rep.append('\n');
        return rep.toString();
    }
}
