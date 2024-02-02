package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.connect4.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.AbstractCell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

public class Connect4Cell extends AbstractCell {

    public Connect4Cell() {
        super(Connect4Symbol.DEFAULT);
    }

    @Override
    protected boolean isSymbolCompatible(Symbol symbol) {
        return symbol instanceof Connect4Cell;
    }
}
