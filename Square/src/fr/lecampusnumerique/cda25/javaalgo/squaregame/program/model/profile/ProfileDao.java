package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DAO;

import java.util.List;

public class ProfileDao implements DAO<ProfileDTO, Long> {

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
