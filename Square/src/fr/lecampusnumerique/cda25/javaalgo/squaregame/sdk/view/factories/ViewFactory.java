package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.factories;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

public interface ViewFactory {

    View createPlayerCreationView();

    View createCoordinatesCreationView();


    View createBoardStatusView();

}
