package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.account;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.Controller;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.InternalController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DAO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Container;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu.InternalControllerMenu;

public abstract class AbstractAccountController implements InternalController, Containable, Container {

    private InternalControllerMenu menu;
    private View view;
    private DAO dao;


    @Override
    public void show() {

    }

    @Override
    public void clear() {

    }

    @Override
    public void addContent(Containable containable) {

    }

    @Override
    public void removeContent(Containable containable) {

    }

    @Override
    public void switchContent(Containable in, Containable out) {

    }

    @Override
    public void hide() {

    }

}
