package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.dialog.ConnectionDialog;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.PersistenceAccessException;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.ProfileDTO;

public abstract class AbstractConnectedProfileController extends AbstractProfileController {


    @Override
    public void show() {
        if(!getProfileManager().isConnected())
            tryConnect();
        super.show();
    }

    private void tryConnect() {
        ConnectionDialog dialog = new ConnectionDialog();
        String[] infos = dialog.showDialog("Please enter your email to connect");
        try {
            ProfileDTO dto = getProfileDAO().findByEmailAndPassword(infos[0], infos[1]);
            if (dto!=null)
                getProfileManager().setCurrentByEmail(infos[0]);
            else{
                getCurrentView().show("Incorrect email or password!");
                tryConnect();
            }
        } catch (PersistenceAccessException e) {
            getCurrentView().show(e.getMessage());
            tryConnect();
        }
    }
}
