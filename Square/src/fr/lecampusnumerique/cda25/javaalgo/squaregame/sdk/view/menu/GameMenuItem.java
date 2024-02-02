package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.Controller;

import java.util.List;

public interface GameMenuItem {

    List<GameMenuItem> getChildren();
    List<GameMenuItem> getSiblings();

    List<GameMenuItem> getPreviousLevel();

    GameMenuItem getParent();

    String getText();

    String getInformation();

    char getShortCut();

    <T extends Controller> Class<T> getControllerClass();

}
