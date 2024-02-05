package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.Profile;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.ProfileDAO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.SqlProfileDAO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.ProfileManager;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.AbstractInternalController;

public abstract class AbstractProfileController extends AbstractInternalController {


    private final Profile current = ProfileManager.getInstance().getCurrent();

    protected Profile getCurrent() {
        return current;
    }

    private final ProfileDAO profileDAO = SqlProfileDAO.getInstance();

    protected ProfileDAO getProfileDAO() {
        return profileDAO;
    }

    public AbstractProfileController() {
        super();
    }


}
