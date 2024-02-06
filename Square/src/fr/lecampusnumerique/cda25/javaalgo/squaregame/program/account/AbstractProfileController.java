package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.*;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.AbstractInternalController;

public abstract class AbstractProfileController extends AbstractInternalController {


    private final ProfileManager profileManager = ProfileManager.getInstance();

    protected Profile getCurrent() {
        return profileManager.getCurrent();
    }

    private final ProfileDAO profileDAO = SqlProfileDAO.getInstance();

    protected ProfileDAO getProfileDAO() {
        return profileDAO;
    }

    public AbstractProfileController() {
        super();
    }


    protected ProfileManager getProfileManager() {
        return profileManager;
    }
}
