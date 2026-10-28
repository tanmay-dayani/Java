package minibank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class AnnotationValidator {
    private AnnotationValidator() { }
    public static List<String> validate(Object object) {
        List<String> errors = new ArrayList<>();
        for (Field field : object.getClass().getSuperclass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(object);
                if (field.isAnnotationPresent(Positive.class) && value instanceof Long amount && amount < 0) {
                    errors.add(field.getName() + " " + field.getAnnotation(Positive.class).message());
                }
                if (field.isAnnotationPresent(MaxLength.class) && value instanceof String text
                        && text.length() > field.getAnnotation(MaxLength.class).value()) {
                    errors.add(field.getName() + " exceeds the permitted length");
                }
            } catch (IllegalAccessException exception) {
                errors.add("Could not validate " + field.getName());
            }
        }
        return errors;
    }
}
