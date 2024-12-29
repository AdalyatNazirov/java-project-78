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
    public void testStringSchemaRequiredReturnFalseIfNullSource(String input) {
        var schema = validator.string().required();

        assertFalse(schema.isValid(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "hex", "hello world"})
    public void testStringSchemaRequiredReturnFalseIfNotNullSource(String input) {
        var schema = validator.string().required();

        assertTrue(schema.isValid(input));
    }
}
