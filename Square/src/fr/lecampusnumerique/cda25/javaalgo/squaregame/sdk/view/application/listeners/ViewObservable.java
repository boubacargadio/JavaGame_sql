package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners;

public interface ViewObservable {

    void addViewObserver(ViewObserver observer);

    void removeViewObserver(ViewObserver observer);

}
