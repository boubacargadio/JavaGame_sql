package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.games.tools.CellFactory;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.AbstractOpenCellBoard;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;

public abstract class OpenCellGameBoard extends AbstractOpenCellBoard {
    protected OpenCellGameBoard(int size, int min, GameTypes type) {
        super(size, min, type, CellFactory.getInstance());
    }
}
