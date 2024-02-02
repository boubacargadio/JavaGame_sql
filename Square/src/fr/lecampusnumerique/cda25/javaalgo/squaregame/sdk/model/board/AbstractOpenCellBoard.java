package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.CellCreator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;

public abstract class AbstractOpenCellBoard extends AbstractBoard{

    protected AbstractOpenCellBoard(int size, int min, GameTypes type, CellCreator cellFactory) {
        super(size, min, type, cellFactory);
    }

    protected String getLine(){
        return "=".repeat(Math.max(0, getSize() * 4 + 1)) +
                '\n';
    }

    @Override
    protected String getLineEnd() {
        return "|";
    }
}
