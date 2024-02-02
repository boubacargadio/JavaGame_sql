package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;

public interface BoardObserver {

    void onCellOccupied(Symbol symbol);

}
