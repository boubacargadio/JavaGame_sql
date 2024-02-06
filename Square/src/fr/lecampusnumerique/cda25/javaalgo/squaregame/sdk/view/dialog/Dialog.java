package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.dialog;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

public interface Dialog<T, U> extends View, UserInteraction {

    T showDialog(U params);

}
