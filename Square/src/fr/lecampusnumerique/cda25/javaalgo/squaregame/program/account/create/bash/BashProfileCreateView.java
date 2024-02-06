package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.create.bash;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.create.ProfileCreateView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.update.ProfileUpdateView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.Profile;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.form.AbstractBashForm;

public class BashProfileCreateView extends AbstractBashForm<Profile> implements ProfileCreateView {
    @Override
    protected Profile createEmpty() {
        return new Profile();
    }
}
