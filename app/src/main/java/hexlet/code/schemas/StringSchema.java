package hexlet.code.schemas;

import org.apache.commons.lang3.StringUtils;

/**
 * A schema for validating {@link String} values.
 * Provides methods to define validation rules such as required, minimum length, and containment checks.
 */
public class StringSchema extends BaseSchema<String> {

    /**
     * Marks the string as required.
     * A string will not pass validation if it is {@code null} or blank (empty or contains only whitespace).
     *
     * @return The current {@link StringSchema} instance for method chaining.
     */
    public StringSchema required() {
        required = true;
        return this;
    }

    /**
     * Adds a validation rule to ensure the string has a minimum length.
     *
     * @param minLength The minimum number of characters the string must have.
     * @return The current {@link StringSchema} instance for method chaining.
     */
    public StringSchema minLength(final int minLength) {
        addCheck(
                "minLength",
                value -> StringUtils.length(value) >= minLength);
        return this;
    }

    /**
     * Adds a validation rule to ensure the string contains a specific sequence of characters.
     *
     * @param searchSeq The sequence of characters that must be present in the string.
     * @return The current {@link StringSchema} instance for method chaining.
     */
    public StringSchema contains(final String searchSeq) {
        addCheck(
                "contains",
                value -> StringUtils.contains(value, searchSeq));
        return this;
    }

    /**
     * Determines if the string is considered blank.
     * A string is considered blank if it is {@code null}, empty, or contains only whitespace.
     *
     * @param value The string to check.
     * @return {@code true} if the string is blank, otherwise {@code false}.
     */
    @Override
    public boolean isBlank(String value) {
        return StringUtils.isBlank(value);
    }
}
