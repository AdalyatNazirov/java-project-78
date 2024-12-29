package hexled.code;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    private static Validator validator;

    @BeforeAll
    public static void setup() {
        validator = new Validator();
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testStringSchemaRequiredReturnsFalseIfNullSource(String input) {
        var schema = validator.string().required();

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "hex", "hello world"})
    public void testStringSchemaRequiredReturnsTrueIfNotNullSource(String input) {
        var schema = validator.string().required();

        assertTrue(schema.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = "1")
    public void testStringSchemaMinLengthReturnsFalseIfTooShort(String input) {
        var schema = validator.string().minLength(3);

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"hex", "hello world"})
    public void testStringSchemaMinLengthReturnsTrueIfLongSource(String input) {
        var schema = validator.string().minLength(3);

        assertTrue(schema.isValid(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testStringSchemaMinLengthReturnsFalseIfBlankOrShortStringWhenRequired(String input) {
        var schema = validator.string().required().minLength(3);

        assertFalse(schema.isValid(input));
    }


    @ParameterizedTest
    @ValueSource(strings = "1")
    public void testStringSchemaContainsReturnsFalseIfContainsNone(String input) {
        var schema = validator.string().contains("wh");

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"hex", "hello world"})
    public void testStringSchemaContainsReturnsTrueIfContains(String input) {
        var schema = validator.string().contains("he");

        assertTrue(schema.isValid(input));
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testStringSchemaContainsReturnsTrueIfContainsWhenRequired(String input) {
        var schema = validator.string().required().contains("he");

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @NullSource
    public void testNumberSchemaRequiredReturnsFalseIfNullSource(Integer input) {
        var schema = validator.number().required();

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1})
    public void testNumberSchemaRequiredReturnsTrueForNonNull(Integer input) {
        var schema = validator.number().required();

        assertTrue(schema.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    public void testNumberSchemaPositiveReturnsFalse(Integer input) {
        var schema = validator.number().positive();

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(ints = {-1, 0, 1})
    public void testNumberSchemaRangeReturnsTrueForNullOrAnyInRange(Integer input) {
        var schema = validator.number().range(-1, 1);

        assertTrue(schema.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(ints = {-2, 2})
    public void testNumberSchemaRangeReturnsFalseForAnyOutside(Integer input) {
        var schema = validator.number().range(-1, 1);

        assertFalse(schema.isValid(input));
    }
}
