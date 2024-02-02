package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.exception.IncompatibleSymbolException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener.BoardObservable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.ClearableComponent;

public interface Cell extends ClearableComponent, BoardObservable {
    String getRepresentation();

    boolean isOccupied();

    boolean occupy(Symbol symbol) throws IncompatibleSymbolException;

    Symbol getSymbol();

}
