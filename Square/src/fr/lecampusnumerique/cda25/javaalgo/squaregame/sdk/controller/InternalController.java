package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;

public interface InternalController extends Controller, Containable {

    void setViewMode(ApplicationType viewType);

}
