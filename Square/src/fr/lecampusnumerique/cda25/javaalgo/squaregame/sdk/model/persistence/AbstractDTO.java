package fr.lecampusnumerique.cda25.javaalgo.squaregame.sdk.model.persistence;

import java.lang.reflect.Field;
import java.net.IDN;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDTO<ID> implements DTO<ID>{

    protected String[] getFields() {
        final List<String> lines = new ArrayList<>();
        for (final Field field: this.getClass().getFields()) {
            field.setAccessible(true);
            try {
                lines.add(field.getName() + " = " + field.get(this));
            } catch (final IllegalAccessException e) {
                lines.add(field.getName() + " > " + e.getClass().getSimpleName());
            }
        }
        return lines.toArray(new String[lines.size()]);
    }

    @Override
    public final String toString() {
        final StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());

        builder.append('(');

        for (final String field : this.getFields()) {
            builder.append(field);
            builder.append(", ");
        }
        builder.delete(builder.length() - 2, builder.length());

        builder.append(')');

        return builder.toString();
    }
}
