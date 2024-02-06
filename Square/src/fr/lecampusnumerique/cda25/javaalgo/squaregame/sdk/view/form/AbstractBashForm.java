package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.form;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.application.bash.view.BashUserInteraction;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.utils.ClassAttributesStringFactory;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.container.Containable;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.view.exception.IncorrectInputException;

import java.lang.reflect.Field;
import java.util.List;

public abstract class AbstractBashForm<T> extends BashUserInteraction implements Form<T> {

    private T data;

    protected T getData() {
        return data;
    }

    @Override
    public void clear() {

    }

    @Override
    public void show(String message) {
        System.out.println(message);
    }

    @Override
    public void show() {
        if(data!=null) showValues(this.data);
    }

    @Override
    public void hide() {

    }

    @Override
    public void addContent(Containable containable) {

    }

    @Override
    public void removeContent(Containable containable) {

    }

    @Override
    public void switchContent(Containable in, Containable out) {

    }

    @Override
    public void showValues(T data) {
        show(ClassAttributesStringFactory.makeString(data));
    }

    @Override
    public T showAndGetFormData() {
        show("Please enter values:");
        T dest = createEmpty();
        List<Field> fields = ClassAttributesStringFactory.getFieldsFrom(dest);
        for (Field field:
             fields) {
            showQuestion(field, dest);

            if(field.getType().equals(String.class)){
                String answer = waitForString();
                try {
                    field.setAccessible(true);
                    field.set(dest, answer);
                } catch (IllegalAccessException e) {
                    show(e.getMessage());
                }
            } else if (field.getType().equals(Integer.class)) {
                try {
                    int answer = waitForInt();
                    field.setAccessible(true);
                    field.setInt(dest, answer);
                } catch (IncorrectInputException | IllegalAccessException e) {
                    show(e.getMessage());
                }
            }
        }
        return dest;
    }

    protected void showQuestion(Field field, T source){
        show(field.getName().replace('_', ' ')+": ");
    }

    protected abstract T createEmpty();

    @Override
    public void fill(T data) {
        if(data != null) this.data=data;
    }
}
