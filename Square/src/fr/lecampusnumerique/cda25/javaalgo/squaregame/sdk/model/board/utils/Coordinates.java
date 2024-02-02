package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils;

public class Coordinates {

    private int raw;

    private int column;

    public int getRaw() {
        return raw;
    }

    public void setRaw(int raw) {
        this.raw = Math.max(raw, 0);
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = Math.max(column, 0);
    }

    public Coordinates() {
        this(0, 0);
    }

    public Coordinates(int raw, int column) {
        this.raw = raw;
        this.column = column;
    }

    public void update(int raw, int column){
        setRaw(raw);
        setColumn(column);
    }

    @Override
    public String toString() {
        return "("+getRaw()+","+getColumn()+")";
    }

    @Override
    public Coordinates clone() {
        return new Coordinates(getRaw(), getColumn());
    }
}
