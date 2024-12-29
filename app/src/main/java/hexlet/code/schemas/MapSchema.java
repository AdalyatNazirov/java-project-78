package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema required() {
        addCheck(
                "required",
                map -> !isBlank(map)
        );
        return this;
    }

    public MapSchema sizeof(int size) {
        addCheck(
                "sizeof",
                map -> isBlank(map) || map.keySet().size() == size
        );
        return this;
    }

    @Override
    protected boolean isBlank(Map value) {
        return value == null;
    }
}
