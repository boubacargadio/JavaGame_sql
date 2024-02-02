package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.exceptions;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.utils.Coordinates;

public class OffBoardException extends Exception{

    public OffBoardException(Coordinates coordinates) {
        super("Cell with coordinates "+coordinates.toString()+" is off limits");
    }

    public OffBoardException(int index, String type) {
        super(type + " at position "+ index + " is off limits");
    }

}
