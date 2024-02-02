package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.exception.IncompatibleSymbolException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.exceptions.OffBoardException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener.BoardObservable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;

import java.util.List;

public interface Board extends ClearableComponent, BoardObservable {

    int FALLING = 0;
    int RISING = 1;

    boolean isOccupied(Coordinates coordinates) throws OffBoardException;

    boolean isFull();

    String getRepresentation();

    boolean occupy(Coordinates coordinates, Symbol symbol) throws OffBoardException, IncompatibleSymbolException;

    List<Symbol> getRaw(int raw) throws OffBoardException;

    List<Symbol> getColumn(int column) throws OffBoardException;

    List<Symbol> getRaw(int raw, int start, int length) throws OffBoardException;

    List<Symbol> getColumn(int column, int start, int length) throws OffBoardException;

    List<Symbol> getDiagonal(Coordinates start, int direction) throws OffBoardException;

    List<Symbol> getDiagonal(Coordinates start, int direction, int length) throws OffBoardException;

    List<Coordinates> getAvailableCells();

    boolean areCoordinatesValid(Coordinates coordinates);
}
