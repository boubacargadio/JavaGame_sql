package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ClassAttributesStringFactory {

    public static List<Field> getFieldsFrom(Object o){
        if(o != null) return List.of(o.getClass().getDeclaredFields());
        return new ArrayList<>();
    }

    public static String[] getFieldsNameFrom(Object o) {
        final List<String> lines = new ArrayList<>();
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

        for (final String field : getFieldsNameFrom(o)) {
            builder.append(field);
            builder.append("\n");
        }
        builder.delete(builder.length() - 2, builder.length());

        builder.append('\n');

        return builder.toString();
    }
}
