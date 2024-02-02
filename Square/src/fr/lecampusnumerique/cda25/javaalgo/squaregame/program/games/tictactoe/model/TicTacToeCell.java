package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.AbstractCell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

public class TicTacToeCell extends AbstractCell {
    public TicTacToeCell() {
        super(TicTacToeSymbol.DEFAULT);
    }

    @Override
    protected boolean isSymbolCompatible(Symbol symbol) {
        return symbol instanceof TicTacToeSymbol;
    }
}
