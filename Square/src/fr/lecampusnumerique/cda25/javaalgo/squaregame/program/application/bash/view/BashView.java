package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;

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
}
