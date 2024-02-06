package fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.update.bash;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.account.update.ProfileUpdateView;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.Profile;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.form.AbstractBashForm;

import java.lang.reflect.Field;

public class BashProfileUpdateView extends AbstractBashForm<Profile> implements ProfileUpdateView {
    @Override
    protected Profile createEmpty() {
        if(getData() != null) return getData();
        return new Profile();
    }

    @Override
    protected void showQuestion(Field field, Profile source) {
        try {
            field.setAccessible(true);
            show(field.getName()+": (current value is "+ field.get(source) + ")");
        } catch (IllegalAccessException e) {
            show(e.getMessage());
            super.showQuestion(field, source);
        }
    }

}
