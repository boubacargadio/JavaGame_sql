package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tictactoe.model.TicTacToeSymbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.strategy.PlayerInteractionsStrategy;

public class TicTacToePlayer extends AbstractPlayer {

    public TicTacToePlayer(String name, TicTacToeSymbol symbol, PlayerInteractionsStrategy coordinatesStrategy) {
        super(name, symbol, coordinatesStrategy);
    }

    public void setTicTacToeSymbol(TicTacToeSymbol symbol){
        super.setSymbol(symbol);
    }

    public String getRepresentation(){
        return getSymbol().getRepresentation();
    }

    public TicTacToeSymbol getSymbol(){
        return (TicTacToeSymbol) super.getSymbol();
    }

}
