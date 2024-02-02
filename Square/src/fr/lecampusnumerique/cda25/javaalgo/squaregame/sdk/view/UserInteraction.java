package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception.IncorrectInputException;

public interface UserInteraction {

    int waitForInt() throws IncorrectInputException;
    String waitForString();
    char waitForChar() throws IncorrectInputException;

}
