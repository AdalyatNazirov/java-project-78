package hexled.code;

import hexlet.code.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
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
}
