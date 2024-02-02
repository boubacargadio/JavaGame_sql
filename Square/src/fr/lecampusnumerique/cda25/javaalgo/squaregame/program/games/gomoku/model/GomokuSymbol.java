package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.gomoku.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

public enum GomokuSymbol implements Symbol {

    N("N"),
    B("B"),
    DEFAULT("+"),
    ;

    private String representation;

    @Override
    public String getRepresentation() {
        return representation;
    }

    GomokuSymbol(String representation) {
        this.representation = representation;
    }
}
