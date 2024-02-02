package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.symbols;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.cell.Cell;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.games.GameTypes;

public interface CellCreator {

    Cell createCell(GameTypes type);

}
