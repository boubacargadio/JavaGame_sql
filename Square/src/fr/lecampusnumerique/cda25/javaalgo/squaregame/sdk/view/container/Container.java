package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container;

public interface Container {

    void addContent(Containable containable);

    void removeContent(Containable containable);

    void switchContent(Containable in, Containable out);

}
