package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.DbAccess;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.ProfileDTO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DAO;

import java.util.List;

public class ProfileDAO implements DAO<ProfileDTO, Long> {

    private static ProfileDAO instance;

    public static ProfileDAO getInstance() {
        if(instance == null) instance = new ProfileDAO();
        return instance;
    }

    private DbAccess dbAccess = DbAccess.getInstance();

    private ProfileDAO() {
        //TODO initialize connection to database

    }

    @Override
    public ProfileDTO findById(Long aLong) {
        return null;
    }

    @Override
    public List<ProfileDTO> findAll() {
        return null;
    }

    @Override
    public ProfileDTO create(ProfileDTO dto) {
        return null;
    }

    @Override
    public ProfileDTO update(ProfileDTO dto) {
        return null;
    }

    @Override
    public boolean remove(ProfileDTO dto) {
        return false;
    }

    @Override
    public boolean removeById(Long aLong) {
        return false;
    }
}
