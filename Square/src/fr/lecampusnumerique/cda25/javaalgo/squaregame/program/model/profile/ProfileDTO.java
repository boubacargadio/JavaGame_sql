package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.AbstractDTO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DTO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.utils.ClassAttributesStringFactory;

public class ProfileDTO extends AbstractDTO<Long> {

    private long id;
    private String first_name;
    private String last_name;
    private String email;
    private String picture;
    private String telephone;

    public ProfileDTO() {
    }


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = (Long)id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ProfileDTO(long id, String first_name, String last_name, String email, String picture, String telephone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.picture = picture;
        this.telephone = telephone;
    }

}
