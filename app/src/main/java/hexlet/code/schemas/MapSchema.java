package hexlet.code.schemas;

import java.util.Map;

/**
 * A schema for validating {@link Map} objects.
 * Allows validation based on map size, required fields, and specific key-value validations using a shape definition.
 */
public class MapSchema extends BaseSchema<Map> {

    /**
     * Marks the map as required.
     * A map will not pass validation if it is {@code null}.
     *
     * @return The current {@link MapSchema} instance for method chaining.
     */
    public MapSchema required() {
        required = true;
        return this;
    }

    /**
     * Adds a validation rule to ensure the map has the exact number of keys specified.
     *
     * @param size The expected size of the map.
     * @return The current {@link MapSchema} instance for method chaining.
     */
    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                map -> map.keySet().size() == size
        );
        return this;
    }

    /**
     * Adds a validation rule to ensure that the map's keys and values match the specified schemas.
     *
     * @param schemas A map where each key is a string corresponding to a key in the map being validated,
     *                and the value is a {@link BaseSchema} that validates the corresponding value.
     * @return The current {@link MapSchema} instance for method chaining.
     */
    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        addCheck("shape",
                map -> {
                    var result = schemas.entrySet()
                            .stream()
                            .reduce(true, (acc, entry) ->
                                            acc && entry.getValue().isValid((String) map.get(entry.getKey())),
                                    (acc1, acc2) -> acc1 && acc2);
                    return result;
                }
        );
        return this;
    }

    /**
     * Determines if the map is considered blank.
     * A map is considered blank if it is {@code null}.
     *
     * @param value The map to check.
     * @return {@code true} if the map is blank, otherwise {@code false}.
     */
    @Override
    protected boolean isBlank(Map value) {
        return value == null;
    }
}
