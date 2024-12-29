package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * An abstract base class to define a schema for validating generic data types.
 * Provides mechanisms to add validation rules and check if a given value satisfies those rules.
 *
 * @param <T> The type of value that this schema validates.
 */
public abstract class BaseSchema<T> {

    private Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean required;

    /**
     * Determines if a value is considered "blank."
     * Subclasses must implement this method to define what constitutes a blank value for type {@code T}.
     *
     * @param value The value to check.
     * @return {@code true} if the value is blank, otherwise {@code false}.
     */
    protected abstract boolean isBlank(T value);


    /**
     * Checks if the input value satisfies all defined validation rules.
     * If the value is blank and the {@code required} flag is {@code false}, it is considered valid.
     * If any validation rule fails, the method returns {@code false}.
     *
     * @param value The value to validate.
     * @return {@code true} if the value is valid, otherwise {@code false}.
     */
    public boolean isValid(T value) {
        if (isBlank(value)) {
            return !required;
        }

        for (Predicate<T> predicate : checks.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Adds a named validation rule to the schema.
     *
     * @param checkName The name of the validation rule.
     * @param predicate The predicate defining the validation rule.
     */
    public void addCheck(String checkName, Predicate<T> predicate) {
        checks.put(checkName, predicate);
    }
}
