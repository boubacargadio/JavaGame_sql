package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.ProfileDTO;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.utils.ClassAttributesStringFactory;

public class Profile {

    private String first_name;
    private String last_name;
    private String email;
    private String picture;
    private String telephone;

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

    public Profile(String first_name, String last_name, String email, String picture, String telephone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.picture = picture;
        this.telephone = telephone;
    }

    public Profile(){

    }

    @Override
    public String toString() {
        return ClassAttributesStringFactory.makeString(this);
    }

    public ProfileDTO extractDTO(){
        return extractDTO(-1);
    }

    public ProfileDTO extractDTO(long id){
        return new ProfileDTO(id, getFirst_name(), getLast_name(), getEmail(), getPicture(), getTelephone());
    }

}
