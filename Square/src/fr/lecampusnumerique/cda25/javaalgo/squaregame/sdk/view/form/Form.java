package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.form;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.UserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

public interface Form<T> extends View, UserInteraction {

    void showValues(T data);
    T getFormData();

}
