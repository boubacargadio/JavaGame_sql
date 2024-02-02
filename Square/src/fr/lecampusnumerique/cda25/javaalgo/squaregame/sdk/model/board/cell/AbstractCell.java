package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.exception.IncompatibleSymbolException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener.BoardObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCell implements Cell{

    private final List<BoardObserver> observers = new ArrayList<>();

    private Symbol symbol;

    private Symbol defaultSymbol;

    public Symbol getSymbol() {
        return symbol;
    }

    protected void setSymbol(Symbol symbol) {
        this.symbol = symbol;
        this.defaultSymbol = symbol;
        notifyOnCellOccupied();
    }

    public boolean isOccupied(){
        return symbol != getSymbol();
    }

    protected Symbol getDefault(){
        return defaultSymbol;
    }

    protected AbstractCell(Symbol symbol) {
        this.symbol = symbol;
    }


    @Override
    public String getRepresentation() {
        return "| "+getSymbol().getRepresentation()+ " ";
    }

    @Override
    public void clear() {
        symbol = getDefault();
    }

    @Override
    public boolean occupy(Symbol symbol) throws IncompatibleSymbolException {
        if(isSymbolCompatible(symbol)){
            if(isOccupied()){
                return false;
            } else {
                setSymbol(symbol);
                return true;
            }
        } else {
            throw new IncompatibleSymbolException("TicTacToe");
        }
    }

    protected abstract boolean isSymbolCompatible(Symbol symbol);

    @Override
    public void addBoardObserver(BoardObserver observer) {
        if(observer != null) observers.add(observer);
    }

    @Override
    public void removeBoardObserver(BoardObserver observer) {
        if(observer != null) observers.remove(observer);
    }

    protected void notifyOnCellOccupied(){
        for (BoardObserver observer: observers) {
            observer.onCellOccupied(this.symbol);
        }
    }
}
