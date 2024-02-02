package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.listener;

public interface BoardObservable {

    void addBoardObserver(BoardObserver observer);
    void removeBoardObserver(BoardObserver observer);
}
