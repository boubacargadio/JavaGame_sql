package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerInteractionsStrategy;

public interface Player {

    Symbol getSymbol();
    PlayerInteractionsStrategy getCoordinatesStrategy();
    String getName();

}
