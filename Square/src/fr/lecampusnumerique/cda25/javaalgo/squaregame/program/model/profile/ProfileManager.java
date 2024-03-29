package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.PersistenceAccessException;

public class ProfileManager {

    private final static String DEFAULT_FIRST_NAME = "John";
    private final static String DEFAULT_LAST_NAME = "Doe";
    private final static String DEFAULT_STRING = "";

    private Profile current;

    private long current_id = -1;

    public long getCurrent_id() {
        return current_id;
    }

    public boolean isConnected(){
        return current_id >=0;
    }

    public Profile getCurrent() {
        if(current == null){
            current = new Profile(DEFAULT_FIRST_NAME, DEFAULT_LAST_NAME, DEFAULT_STRING, DEFAULT_STRING, DEFAULT_STRING);
        }
        return current;
    }

    private static ProfileManager instance;

    public static ProfileManager getInstance() {
        if(instance == null) instance = new ProfileManager();
        return instance;
    }

    private ProfileManager() {
    }

    public void setCurrentById(Long id) throws PersistenceAccessException {
        ProfileDTO dto = SqlProfileDAO.getInstance().findById(id);
        current = convert(dto);
        current_id = dto.getId();
    }


    public void setCurrentByEmail(String email) throws PersistenceAccessException {
        ProfileDTO dto = SqlProfileDAO.getInstance().findByEmail(email);
        current = convert(dto);
        current_id = dto.getId();
    }

    public static Profile convert(ProfileDTO dto){
        return new Profile(dto.getFirst_name(), dto.getLast_name(), dto.getEmail(), dto.getPicture(), dto.getTelephone());
    }


}
