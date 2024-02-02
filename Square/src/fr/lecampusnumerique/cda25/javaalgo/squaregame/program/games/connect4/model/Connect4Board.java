package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.connect4.model;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.OpenCellGameBoard;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.exception.IncompatibleSymbolException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.exceptions.OffBoardException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.GameType;

public class Connect4Board extends OpenCellGameBoard {


    public final static int DEFAULT_SIZE = 7;
    public final static int MIN_SIZE = 7;

    public Connect4Board() {
        this(DEFAULT_SIZE);
    }

    public Connect4Board(int size) {
        super(size, MIN_SIZE, GameType.CONNECT4);
    }

    @Override
    protected String getRawSeparatorRepresentation() {
        return "";
    }

    @Override
    protected String getFloorRepresentation() {
        return getLine();
    }

    @Override
    public boolean occupy(Coordinates coordinates, Symbol symbol) throws OffBoardException, IncompatibleSymbolException {
        Coordinates destination = calculateFirstAvailableCoordinate(coordinates);
        return super.occupy(destination, symbol);
    }

    @Override
    protected String getLineEnd() {
        return "|\n";
    }

    private Coordinates calculateFirstAvailableCoordinate(Coordinates coord) throws OffBoardException{
        Coordinates result = new Coordinates(0, coord.getColumn());
        do {
            result.update(result.getRaw()+1, result.getColumn());
        } while (areCoordinatesValid(result) && !isOccupied(result));
        result.update(result.getRaw()-1, result.getColumn());
        return result;
    }


}
