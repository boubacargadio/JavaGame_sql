package fr.lecampusnumerique.cda25.javaalgo.squaregame;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.create.bash.BashProfileCreateView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.update.bash.BashProfileUpdateView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.Profile;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.ProfileDTO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.SqlProfileDAO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.utils.ClassAttributesStringFactory;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.form.Form;

import java.util.List;

public class ProfileSqlMainDebug {

    public static void main(String[] args) {

        SqlProfileDAO dao = SqlProfileDAO.getInstance();

        List<ProfileDTO> allProfiles = dao.findAll();
        for (ProfileDTO dto:
             allProfiles) {
            show(dto);
        }

        Form<Profile> view = new BashProfileCreateView();
        Profile test = view.showAndGetFormData();

        ProfileDTO newProfile = test.extractDTO();
        ProfileDTO created = dao.create(newProfile);
        show(created);

        boolean passChanged = dao.updatePassword(created.getEmail(), "", "changeme");
        System.out.println(passChanged ? "Pass updated": "Not changed");

        ProfileDTO connected = dao.findByEmailAndPassword(created.getEmail(), "changeme");
        System.out.println(connected);

        view = new BashProfileUpdateView();
        view.fill(test);
        test = view.showAndGetFormData();
        ProfileDTO updated = dao.update(test.extractDTO(created.getId()));
        show(updated);

        boolean removed = dao.remove(created);
        System.out.println(removed ? "Removed" : "Still here!");

        show(dao.findById(created.getId()));


    }

    private static void show(ProfileDTO dto){
        System.out.println(ClassAttributesStringFactory.makeString(dto));
    }
}
