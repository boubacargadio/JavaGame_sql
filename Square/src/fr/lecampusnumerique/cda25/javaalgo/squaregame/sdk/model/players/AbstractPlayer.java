package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerInteractionsStrategy;

public abstract class AbstractPlayer {

    public AbstractPlayer(String name, Symbol symbol, PlayerInteractionsStrategy coordinatesStrategy) {
        this.name = name;
        this.symbol = symbol;
        this.coordinatesStrategy = coordinatesStrategy;
    }

    private Symbol symbol;
    private PlayerInteractionsStrategy coordinatesStrategy;
    private String name;


    public Symbol getSymbol(){
        return symbol;
    }

    protected void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }

    public PlayerInteractionsStrategy getCoordinatesStrategy() {
        return coordinatesStrategy;
    }

    public String getName() {
        return name;
    }
}
