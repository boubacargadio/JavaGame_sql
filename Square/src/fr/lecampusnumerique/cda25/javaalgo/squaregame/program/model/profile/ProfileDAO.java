package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DAO;

public interface ProfileDAO extends DAO<ProfileDTO, Long>  {

    ProfileDTO findByEmail(String email);


}
