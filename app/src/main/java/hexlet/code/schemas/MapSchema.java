package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        required = true;
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                map -> map.keySet().size() == size
        );
        return this;
    }

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

    @Override
    protected boolean isBlank(Map value) {
        return value == null;
    }
}
