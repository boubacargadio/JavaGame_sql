package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

import java.util.Arrays;
import java.util.List;

public enum TicTacToeSymbol implements Symbol {

    DEFAULT(" "),
    X("X"),
    Y("Y"),
    O("O"),
    ;

    private String representation;

    @Override
    public String getRepresentation() {
        return representation;
    }

    TicTacToeSymbol(String representation) {
        this.representation = representation;
    }

    public static List<TicTacToeSymbol> getPlayerTicTacToeSymbols(){
        return Arrays.stream(TicTacToeSymbol.values())
                .filter(ticTacToeSymbol -> ticTacToeSymbol != DEFAULT)
                .toList();
    }
}
