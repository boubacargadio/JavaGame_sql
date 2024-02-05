package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.AbstractProfileController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.bash.BashProfileShowMenu;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.bash.BashProfileShowView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.controller.AbstractInternalController;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;

public class ShowProfileController extends AbstractProfileController {

    private ShowProfileMenu menu;

    private ShowProfileView view;


    public ShowProfileController() {
        super();
    }

    @Override
    protected void initView() {
        if(getCurrentView() == null){
            addContent(new BashProfileShowView());
        }
        if(getMenu() == null){
            addContent(new BashProfileShowMenu());
        }
    }

    @Override
    public void show() {
        super.show();
        getCurrentView().show(getCurrent().toString());
    }
}
