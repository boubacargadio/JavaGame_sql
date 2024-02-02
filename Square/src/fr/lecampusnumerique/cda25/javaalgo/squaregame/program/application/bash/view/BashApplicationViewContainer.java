package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.View;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.ViewContainer;

import java.util.ArrayList;
import java.util.List;

public class BashApplicationViewContainer implements ViewContainer {

    private View view = new BashView();
    private final List<Containable> containables = new ArrayList<>();

    @Override
    public void show(String message) {
        view.show(message);
    }


    @Override
    public void clear() {
        for (Containable containable:
             containables) {
            containable.clear();
        }
    }

    @Override
    public void addContent(Containable containable) {
        if(containable != null) {
            containables.add(containable);
            containable.show();
        }
    }

    @Override
    public void removeContent(Containable containable) {
        if(containable != null) {
            containable.hide();
            containables.remove(containable);
        }
    }

    @Override
    public void switchContent(Containable in, Containable out) {
        removeContent(out);
        addContent(in);
    }
}
