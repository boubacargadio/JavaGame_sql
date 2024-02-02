package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.dialog.Dialog;

public abstract class AbstractBashDialog<T, U> implements Dialog<T, U> {

    private final View view = new BashView();
    private final UserInteraction userInteraction = new BashUserInteraction();

    protected View getView() {
        return view;
    }

    protected UserInteraction getUserInteraction() {
        return userInteraction;
    }

}
