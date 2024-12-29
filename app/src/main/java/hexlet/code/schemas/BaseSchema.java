package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    private Map<String, Predicate<T>> checks = new LinkedHashMap<>();

    protected abstract boolean isBlank(T value);

    public boolean isValid(T value) {

        for (Predicate<T> predicate : checks.values()) {
            if (!predicate.test(value)) {
                return false;
            }
        }

        return true;
    }

    public void addCheck(String checkName, Predicate<T> predicate) {
        checks.put(checkName, predicate);
    }
}
