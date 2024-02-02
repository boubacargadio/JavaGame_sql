package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.opponents;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.players.Player;

import java.util.ArrayList;
import java.util.List;

public abstract class Opponents implements Opposable{

    private final int maxPlayers;
    private final List<Player> players = new ArrayList<>();

    private int current;

    @Override
    public boolean hasPlayers(){
        return !players.isEmpty();
    }

    @Override
    public boolean isEmpty(){
        return players.isEmpty();
    }

    @Override
    public boolean isFull(){
        return players.size()==maxPlayers;
    }

    @Override
    public Player getCurrentPlayer(){
        return players.get(current);
    }

    @Override
    public int getMaxPlayers(){
        return maxPlayers;
    }

    protected Opponents(int maxPlayers) {
        this.maxPlayers = maxPlayers;
        this.current=0;
    }

    @Override
    public Player next(){
        current++;
        if(current>=players.size()){
            current=0;
        }
        return getCurrentPlayer();
    }

    @Override
    public void addPlayer(Player player) throws OpponentsException {
        if(isFull()) throw new OpponentsException("Players are already set");
        if(player == null) throw new OpponentsException("Player can not be null");
        players.add(player);
    }

    @Override
    public boolean removePlayer(Player player){
        return players.remove(player);
    }

    @Override
    public boolean substitutePlayer(Player out, Player in) throws OpponentsException{
        if(players.remove(out)) return players.add(in);
        throw new OpponentsException("Player to remove is not present");
    }

    @Override
    public void reset(){
        this.players.clear();
    }

    @Override
    public Player getPlayerBySymbol(Symbol symbol){
        return players.stream().filter(player -> player.getSymbol() == symbol).findFirst().orElse(null);
    }

    @Override
    public void clear() {
        this.players.clear();
    }
}
