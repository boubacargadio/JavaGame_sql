package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.connect4.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

public enum Connect4Symbol implements Symbol {

    DEFAULT(" "),
    R("R"),
    J("J"),
    ;

    private String representation;

    @Override
    public String getRepresentation() {
        return representation;
    }

    Connect4Symbol(String representation) {
        this.representation = representation;
    }


}
