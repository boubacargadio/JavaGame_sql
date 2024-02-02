package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tools;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.connect4.model.Connect4Cell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.gomoku.model.GomokuCell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe.model.TicTacToeCell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.Cell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.CellCreator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;

public class CellFactory implements CellCreator {

    private static CellFactory instance;

    public static CellFactory getInstance(){
        if(instance == null){
            instance = new CellFactory();
        }
        return instance;
    }

    private CellFactory(){

    }

    public Cell createCell(GameTypes type){
        GameType type1 = (GameType) type;
        return switch (type1){
            case TICTACTOE -> new TicTacToeCell();
            case CONNECT4 -> new Connect4Cell();
            case GOMOKU -> new GomokuCell();
            default -> null;
        };
    }
}
