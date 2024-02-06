package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.DbAccess;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DAO;

import java.util.List;

public class SqlProfileDAO implements ProfileDAO {

    private static SqlProfileDAO instance;

    public static SqlProfileDAO getInstance() {
        if(instance == null) instance = new SqlProfileDAO();
        return instance;
    }

    private DbAccess dbAccess = DbAccess.getInstance();

    private SqlProfileDAO() {
        //TODO initialize connection to database

    }

    @Override
    public ProfileDTO findById(Long aLong) {
        return null;
    }

    public ProfileDTO findByEmail(String email) {
        return null;
    }

    @Override
    public ProfileDTO findByEmailAndPassword(String email, String passsword) {
        return null;
    }

    @Override
    public boolean updatePassword(String email, String oldPass, String newPass) {
        return false;
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
