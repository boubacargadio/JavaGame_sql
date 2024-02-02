package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.menu;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners.MenuObservable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu.InternalControllerMenu;

public interface TurnGameMenu  extends InternalControllerMenu, MenuObservable {

    void showTurnMenu();

}
