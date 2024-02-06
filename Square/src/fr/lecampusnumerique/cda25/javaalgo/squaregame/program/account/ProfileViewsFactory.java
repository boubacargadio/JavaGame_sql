package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.ShowProfileMenu;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.ShowProfileView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.bash.BashProfileShowMenu;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.show.bash.BashProfileShowView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.application.ApplicationType;

public class ProfileViewsFactory {


    public static ShowProfileView createShowProfileView(ApplicationType type){
        if(type == ApplicationType.BASH)
            return new BashProfileShowView();
        return new BashProfileShowView();
    }

    public static ShowProfileMenu createShowProfileMenu(ApplicationType type){
        if(type == ApplicationType.BASH)
            return new BashProfileShowMenu();
        return new BashProfileShowMenu();
    }

}
