package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.gomoku.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.AbstractCell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

public class GomokuCell extends AbstractCell {


    public GomokuCell() {
        super(GomokuSymbol.DEFAULT);
    }

    @Override
    protected boolean isSymbolCompatible(Symbol symbol) {
        return symbol instanceof GomokuSymbol;
    }

    @Override
    public String getRepresentation() {
        return "--"+getSymbol().getRepresentation()+"--";
    }
}
