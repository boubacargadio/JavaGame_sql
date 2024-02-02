package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.opponents;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.ClearableComponent;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.Player;

public interface Opposable extends ClearableComponent {

    boolean hasPlayers();

    boolean isEmpty();

    boolean isFull();

    Player getCurrentPlayer();

    int getMaxPlayers();

    Player next();

    void addPlayer(Player player) throws OpponentsException;

    boolean removePlayer(Player player);

    boolean substitutePlayer(Player out, Player in) throws OpponentsException;

    void reset();

    Player getPlayerBySymbol(Symbol symbol);

}
