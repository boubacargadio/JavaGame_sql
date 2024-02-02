package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners;

public class ViewEvent<T> {

    private T eventContent;

    public T getEventContent() {
        return eventContent;
    }

    public ViewEvent(T eventContent) {
        this.eventContent = eventContent;
    }

}
