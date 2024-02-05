package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;

public class BashView implements View {
    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {
        clear();
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
}
