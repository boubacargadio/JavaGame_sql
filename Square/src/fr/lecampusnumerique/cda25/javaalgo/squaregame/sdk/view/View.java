package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.ClearableComponent;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Container;

public interface View extends ClearableComponent, Container, Containable {

    void show(String message);

}
