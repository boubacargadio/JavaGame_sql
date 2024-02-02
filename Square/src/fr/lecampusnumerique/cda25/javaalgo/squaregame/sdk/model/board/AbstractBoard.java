package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.Cell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.CellCreator;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.Symbol;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols.exception.IncompatibleSymbolException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.exceptions.OffBoardException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener.BoardObserver;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBoard implements Board{

    private final List<Cell> cells = new ArrayList<>();

    private int size;
    private int minSize;

    private CellCreator cellFactory;

    protected int getSize(){
        return this.size;
    }

    protected int getMinSize(){
        return this.minSize;
    }

    protected AbstractBoard(int size, int min, GameTypes type, CellCreator cellFactory){
        this.minSize=min;
        this.size=Math.max(min, size);
        this.cellFactory = cellFactory;
        init(type);
    }

    protected void init(GameTypes type){
        for (int i = 0; i < getSize()*getSize(); i++) {
            addCell(getCellFactory().createCell(type));
        }
    }

    protected CellCreator getCellFactory(){
        return cellFactory;
    }

    protected void setCellFactory(CellCreator cellCreator){
        this.cellFactory = cellCreator;
    }

    protected void addCell(Cell cell){
        cells.add(cell);
    }

    @Override
    public void clear() {
        for (ClearableComponent cell: cells) {
            cell.clear();
        }
    }

    @Override
    public boolean occupy(Coordinates coordinates, Symbol symbol) throws OffBoardException, IncompatibleSymbolException {
        return getCellAt(coordinates).occupy(symbol);
    }

    protected Cell getCellAt(Coordinates coordinates) throws OffBoardException {
        if (checkCoordinates(coordinates))
            return cells.get(makeIndex(coordinates));
        throw new OffBoardException(coordinates);
    }

    protected Cell getCellAt(int index) throws OffBoardException{
        if(index<cells.size())
            return cells.get(index);
        throw new OffBoardException(makeCoordinatesByIndex(index));
    }

    protected boolean checkCoordinates(Coordinates coordinates){
        return makeIndex(coordinates) < cells.size();
    }

    protected int makeIndex(Coordinates coordinates){
        return coordinates.getRaw()*size + coordinates.getColumn();
    }

    @Override
    public List<Symbol> getRaw(int raw) throws OffBoardException {
        return getRaw(raw, 0, this.size);
    }

    @Override
    public List<Symbol> getColumn(int column)  throws OffBoardException{
        return getColumn(column, 0, this.getSize());
    }

    @Override
    public List<Symbol> getRaw(int raw, int start, int length) throws OffBoardException {
        if(raw<0 || raw >= this.size)
            throw new OffBoardException(raw, "Raw");
        List<Symbol> symbols = new ArrayList<>();
        for (int i = raw*this.size+start; i<raw*this.size + length && i<(raw+1)*this.size; i++) {
            symbols.add(cells.get(i).getSymbol());
        }
        return symbols;
    }

    @Override
    public List<Symbol> getColumn(int column, int start, int length) throws OffBoardException {
        if(column<0 || column >= this.size)
            throw new OffBoardException(column, "Column");
        List<Symbol> symbols = new ArrayList<>();
        for (int i = column+start*size; i < length * (column+size) && i < size * (column+size); i=i+size) {
            symbols.add(cells.get(i).getSymbol());
        }
        return symbols;
    }

    @Override
    public List<Symbol> getDiagonal(Coordinates start, int direction)  throws OffBoardException{
        return getDiagonal(start, direction, size);
    }

    private List<Symbol> getRisingDiagonal(Coordinates start, int direction, int length) throws OffBoardException{
        Coordinates copyStart = start.clone();
           List<Symbol> symbols = new ArrayList<>();
           while(copyStart.getColumn()<size && copyStart.getColumn()>=0
                   && copyStart.getRaw()>=0 && copyStart.getRaw()<size
                   && symbols.size()<length){
               symbols.add(getCellAt(copyStart).getSymbol());
               copyStart.setColumn(copyStart.getColumn()+1);
               copyStart.setRaw(copyStart.getRaw()-1);
           }

           return symbols;
    }

    private List<Symbol> getFallingDiagonal(Coordinates start, int direction, int length) throws OffBoardException{
        Coordinates copyStart = start.clone();
        List<Symbol> symbols = new ArrayList<>();
        while(copyStart.getColumn()<size && copyStart.getColumn()>=0
                && copyStart.getRaw()>=0 && copyStart.getRaw()<size
                && symbols.size()<length){
            symbols.add(getCellAt(copyStart).getSymbol());
            copyStart.setColumn(copyStart.getColumn()+1);
            copyStart.setRaw(copyStart.getRaw()-1);
        }

        return symbols;
    }

    @Override
    public List<Symbol> getDiagonal(Coordinates start, int direction, int length)  throws OffBoardException{
        if(getCellAt(start) != null){
            if(direction == RISING){
                return getRisingDiagonal(start, direction, length);
            } else {
                return getFallingDiagonal(start, direction, length);
            }
        }
        return null;
    }

    @Override
    public boolean isOccupied(Coordinates coordinates) throws OffBoardException {
        return getCellAt(coordinates).isOccupied();
    }

    @Override
    public List<Coordinates> getAvailableCells() {
        List<Coordinates> availables = new ArrayList<>();
        for (int i = 0; i < cells.size(); i++) {
            if (!cells.get(i).isOccupied()){
                availables.add(makeCoordinatesByIndex(i));
            }
        }
        return availables;
    }

    protected Coordinates makeCoordinatesByIndex(int index){
        return new Coordinates(index/size, index%size);
    }

    @Override
    public boolean isFull() {
        return getAvailableCells().isEmpty();
    }

    protected int getCellsSize(){
        return cells.size();
    }


    @Override
    public String getRepresentation() {
        StringBuilder rep = new StringBuilder(getRawSeparatorRepresentation());
        try {
            for (int i = 0; i < getSize(); i++) {
                for (int j = 0; j < getSize(); j++) {
                    rep.append(getCellAt(i*getSize()+j).getRepresentation());
                }
                rep.append(getLineEnd());
                rep.append(getRawSeparatorRepresentation());
            }
            rep.append(getFloorRepresentation());
        } catch (OffBoardException e) {
            System.out.println(e.getMessage());
        }
        return rep.toString();
    }

    protected abstract String getRawSeparatorRepresentation();
    protected abstract String getFloorRepresentation();
    protected abstract String getLineEnd();
    protected abstract String getLine();

    @Override
    public boolean areCoordinatesValid(Coordinates coordinates) {
        return checkCoordinates(coordinates);
    }

    @Override
    public void addBoardObserver(BoardObserver observer) {
        if (observer != null){
            for (Cell cell: cells) {
                cell.addBoardObserver(observer);
            }
        }
    }

    @Override
    public void removeBoardObserver(BoardObserver observer) {
        if (observer != null){
            for (Cell cell: cells) {
                cell.removeBoardObserver(observer);
            }
        }
    }
}
