
package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

/**
 * A utility class for creating various types of schemas for validation.
 * Provides methods to create schemas for strings, numbers, and maps.
 */
public class Validator {

    /**
     * Creates a new instance of {@link StringSchema}, which is used to validate strings.
     *
     * @return A new {@link StringSchema} instance.
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creates a new instance of {@link NumberSchema}, which is used to validate numbers.
     *
     * @return A new {@link NumberSchema} instance.
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creates a new instance of {@link MapSchema}, which is used to validate maps.
     *
     * @return A new {@link MapSchema} instance.
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
