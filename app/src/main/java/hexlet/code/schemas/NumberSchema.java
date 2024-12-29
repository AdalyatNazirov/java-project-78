package hexlet.code.schemas;

/**
 * A schema for validating {@link Integer} values.
 * Provides methods to define validation rules such as required, positivity, and range constraints.
 */
public class NumberSchema extends BaseSchema<Integer> {

    /**
     * Marks the number as required.
     * A number will not pass validation if it is {@code null}.
     *
     * @return The current {@link NumberSchema} instance for method chaining.
     */
    public NumberSchema required() {
        required = true;
        return this;
    }

    /**
     * Adds a validation rule to ensure the number is positive.
     * The number must be greater than 0 to pass validation.
     *
     * @return The current {@link NumberSchema} instance for method chaining.
     */
    public NumberSchema positive() {
        addCheck("positive", number -> number > 0);
        return this;
    }

    /**
     * Adds a validation rule to ensure the number is within a specified range, inclusive.
     *
     * @param min The minimum allowed value (inclusive).
     * @param max The maximum allowed value (inclusive).
     * @return The current {@link NumberSchema} instance for method chaining.
     */
    public NumberSchema range(int min, int max) {
        addCheck("range", number -> (number >= min && number <= max));
        return this;
    }

    /**
     * Determines if the number is considered blank.
     * A number is considered blank if it is {@code null}.
     *
     * @param value The number to check.
     * @return {@code true} if the number is blank, otherwise {@code false}.
     */
    @Override
    protected boolean isBlank(Integer value) {
        return value == null;
    }
}
