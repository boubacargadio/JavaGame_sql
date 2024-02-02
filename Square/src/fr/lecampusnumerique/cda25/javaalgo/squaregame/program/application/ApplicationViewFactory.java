package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view.BashApplicationViewContainer;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.menu.ApplicationMenu;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.BashApplicationMenu;

public class ApplicationViewFactory {

    public static ViewContainer createViewContainer(ApplicationType type){
        return switch (type){
            case BASH -> new BashApplicationViewContainer();
            default -> null;
        };
    }

    public static ApplicationMenu createApplicationMenu(ApplicationType type){
        return switch (type){
            case BASH -> new BashApplicationMenu();
            default -> null;
        };

    }
}
