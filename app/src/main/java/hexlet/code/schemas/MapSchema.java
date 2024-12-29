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

    @Override
    protected boolean isBlank(Map value) {
        return value == null;
    }
}
