package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.bash;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.ShowProfileView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view.BashView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.Profile;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;

public class BashProfileShowView extends BashView implements ShowProfileView {


    @Override
    public void showProfile(Profile profile) {
        show(profile.toString());
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
}
