package com.kholodkov.inject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//todo: different between .getDeclaredFields() and .getFields?

/**
 * Spring#7-1 1:02:53
 */
public class FieldReflector {

    /**
     * 1) Non static
     * 2) All scopes
     * 3) From all parents
     * 4) clazz fields - include
     * 5) upperBound fields - exclude
     *
     * Collections.addAll(fields, current.getDeclaredFields());
     * The behavior of this convenience method is identical to that of
     * fields.addAll(asList(current.getDeclaredFields()));
     * but this method is likely to run significantly faster under most implementations.(JavaDoc)
     * Additional I think this method is more intuitive
     *
     * .getDeclaredFields() - all fields (include privet) in this class
     * .getFields - return all public fields (this class and parent class)
     */
    public static List<Field> collectUpTo(Class<?> clazz, Class<?> upperBound) {
        List<Field> fields = new ArrayList<>();
        Class<?> current = clazz;
        while (current != upperBound) {
            Collections.addAll(fields, current.getDeclaredFields());
            current = current.getSuperclass();
        }
        return fields;
    }

    public static List<Field> filterInject(List<Field> allFields) {
        List<Field> injectedFields = new ArrayList<>();
        for (Field field :allFields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                injectedFields.add(field);
            }
        }
        return injectedFields;
    }
}
