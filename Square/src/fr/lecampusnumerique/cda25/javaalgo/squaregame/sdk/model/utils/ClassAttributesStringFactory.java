package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.utils;

import fr.lecampusnumerique.cda25.javaalgo.squaregame.program.model.profile.Profile;
import fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence.DTO;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ClassAttributesStringFactory {

    public static String[] getFieldsFrom(Object o) {
        final List<String> lines = new ArrayList<>();
        Class<? extends DTO> ob = DTO.class;
        Method[] methods = ob.getDeclaredMethods();
        List<Field> fields = List.of(o.getClass().getFields());
        for (final Field field: o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                lines.add(field.getName().replace('_', ' ') + ": " + field.get(o));
            } catch (final IllegalAccessException e) {
                lines.add(field.getName() + " > " + e.getClass().getSimpleName());
            }
        }
        return lines.toArray(new String[lines.size()]);
    }

    public static String makeString(Object o) {
        final StringBuilder builder = new StringBuilder(o.getClass().getSimpleName());

        builder.append(":\n");

        for (final String field : getFieldsFrom(o)) {
            builder.append(field);
            builder.append("\n");
        }
        builder.delete(builder.length() - 2, builder.length());

        builder.append('\n');

        return builder.toString();
    }
}
