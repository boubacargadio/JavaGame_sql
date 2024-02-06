package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.dialog;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view.BashUserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.dialog.Dialog;

public class ConnectionDialog extends BashUserInteraction implements Dialog<String[], String> {

    private final static String EMAIL_QUESTION="Please enter your email:";
    private final static String PASS_QUESTION="Please enter your password:";

    @Override
    public void clear() {

    }

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void addContent(Containable containable) {

    }

    @Override
    public void removeContent(Containable containable) {

    }

    @Override
    public void switchContent(Containable in, Containable out) {

    }

    @Override
    public String[] showDialog(String params) {
        show(params);
        show(EMAIL_QUESTION);
        String email = waitForString();
        show(PASS_QUESTION);
        String pass = waitForString();
        return new String[]{email, pass};
    }
}
