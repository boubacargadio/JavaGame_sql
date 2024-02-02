package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.listeners;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.menu.ApplicationMenuItems;

public interface MenuObserver {

    void onMenuClicked(ApplicationMenuItems menuItem);

    void onQuitAsked();
}
