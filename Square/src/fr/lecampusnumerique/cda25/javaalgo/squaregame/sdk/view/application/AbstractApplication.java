package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.ApplicationFactory;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.InternalController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.factory.ControllerFactory;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.factory.ControllerFactoryException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners.MenuObserver;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.menu.ApplicationMenu;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.menu.ApplicationMenuItems;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractApplication implements Application, MenuObserver {



    private InternalController currentController;

    private ApplicationMenu menu;

    private ViewContainer container;

    private ApplicationType type;
    private ApplicationStatus status;

    private final List<Containable> controllers = new ArrayList<>();

    protected AbstractApplication(ApplicationType type){
        ApplicationMenu menu = ApplicationFactory.createApplicationMenu(type);
        if(menu == null){
            this.type = ApplicationType.getDefault();
            this.menu = ApplicationFactory.createApplicationMenu(this.type);
        } else {
            this.type = type;
            this.menu=menu;
        }
        assert menu != null;
        menu.addApplicationMenuObserver(this);
        container = ApplicationFactory.createViewContainer(this.type);
    }

    @Override
    public void hide() {
        for (Containable containable:
             controllers) {
            containable.hide();
        }

    }

    @Override
    public void show() {
        container.show("Welcome to Square games world!");
        container.show("");
        status=ApplicationStatus.MENU;
        makeState();
    }

    private void makeState(){
        switch (status){
            case MENU -> {
                menu.showMainMenu();
                makeState();
            }
            case PLAYING -> {
                currentController.show();
                status = ApplicationStatus.MENU;
                makeState();
            }
            case EXIT -> showExitMessage();
        }
    }

    private void showExitMessage() {
        container.show("Goodbye folks!");
    }

    @Override
    public void addContent(Containable containable) {
        if(containable != null){
            controllers.add(containable);
//            containable.show();
        }
    }

    @Override
    public void removeContent(Containable containable) {
        if(containable != null){
            containable.hide();
            controllers.remove(containable);
        }
    }

    @Override
    public void switchContent(Containable in, Containable out) {
        removeContent(out);
        addContent(in);
    }

    @Override
    public void onMenuClicked(ApplicationMenuItems menuItem) {
        if(menuItem != null){
            if(menuItem.getControllerClass() != null){
                try {
                    this.currentController = ControllerFactory.createInternalController(menuItem);
                    addContent(currentController);
                    status = ApplicationStatus.PLAYING;
                } catch (ControllerFactoryException e) {
                    container.show(e.getMessage());
                }
            }
        }
    }

    @Override
    public void onQuitAsked() {
        status = ApplicationStatus.EXIT;
    }
}
