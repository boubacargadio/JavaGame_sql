package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.board.ClearableComponent;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Container;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.menu.InternalControllerMenu;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractInternalController implements InternalController, Containable, Container {

    private InternalControllerMenu menu;
    private View currentView;
    private ApplicationType viewType;
    private final List<Containable> containables = new ArrayList<>();
    private final List<ClearableComponent> clearables = new ArrayList<>();

    protected InternalControllerMenu getMenu() {
        return menu;
    }

    protected View getCurrentView() {
        return currentView;
    }

    protected ApplicationType getViewType() {
        return viewType;
    }

    protected void setMenu(InternalControllerMenu menu) {
        this.menu = menu;
    }

    protected void setCurrentView(View currentView) {
        this.currentView = currentView;
    }

    protected void setViewType(ApplicationType viewType) {
        this.viewType = viewType;
    }

    protected AbstractInternalController(){
        this(ApplicationType.BASH);
    }

    protected AbstractInternalController(ApplicationType viewType) {
        this.viewType = viewType;
    }

    @Override
    public void setViewMode(ApplicationType viewType) {
        clear();
        this.viewType = viewType;
//        show();
    }

    protected ApplicationType getViewMode(){
        return viewType;
    }


    @Override
    public void show() {
        initView();
        currentView.show();
        menu.show();
    }

    protected abstract void initView();

    @Override
    public void clear() {
        for (ClearableComponent cp:
             clearables) {
            clearables.clear();
        }
    }

    @Override
    public void addContent(Containable containable) {
        if(containable!=null) {
            containables.add(containable);
            clearables.add(containable);
            if(containable instanceof InternalControllerMenu) {
                this.menu = (InternalControllerMenu) containable;
            }
            else if(containable instanceof View) {
                this.currentView = (View) containable;
            }
        }
    }

    @Override
    public void removeContent(Containable containable) {
        if(containable!=null) {
            containables.remove(containable);
            clearables.remove(containable);
            if(containable instanceof InternalControllerMenu && containable == menu) {
                this.menu.hide();
                this.menu = null;
            }
            else if(containable instanceof View && containable == currentView) {
                this.currentView.hide();
                this.currentView = null;
            }
//            this.show();
        }
    }

    @Override
    public void switchContent(Containable in, Containable out) {
        removeContent(out);
        addContent(in);
    }

    @Override
    public void hide() {
        for (Containable cta:
             containables) {
            cta.hide();
        }
    }

}
