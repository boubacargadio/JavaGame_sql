package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners;

public interface MenuObservable {

    void addApplicationMenuObserver(MenuObserver observer);
    void removeApplicationMenuObserver(MenuObserver observer);

}
